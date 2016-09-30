package br.com.cookfy.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import br.com.cookfy.model.Recipes;
import br.com.cookfy.util.HibernateUtil;

public class RecipesDAO {
	private Session session;
	private static RecipesDAO instance;

	public RecipesDAO() {
		this.session = HibernateUtil.instance().getSessionFactory().openSession();
	}

	public static RecipesDAO instance() {
		if (instance == null) {
			instance = new RecipesDAO();
		}
		return instance;
	}

	public Recipes findRecipesByName(String name) {
		return new Recipes();
	}

	public List<Recipes> findRecipesByToken(String token) {
		return new ArrayList<Recipes>();
	}

	public Recipes findRecipesById(int id) {
		String statement = "* FROM recipes where id = :id";
		Query query = session.createQuery(statement);
		query.setParameter("id", id);
		
		return (Recipes)query.getSingleResult();
	}

	public List<Recipes> listRecipesByUserId(int user_id) {
		String statement = "* FROM recipes r join user2recipe u2r where u2r.user_id = :user_id";
		Query query = session.createQuery(statement);
		query.setParameter("user_id", user_id);

		List<Recipes> receitas = query.getResultList();

		return receitas;
	}

	public List<Recipes> listRecipesByCategoryId(int category_id) {
		String statement = "* FROM recipes r join recipes2category r2c where r2c.category_id = :category_id";
		Query query = session.createQuery(statement);
		query.setParameter("category_id", category_id);

		List<Recipes> receitas = query.getResultList();

		return receitas;
	}

	public List<Recipes> listRecipesByRecipeBookId(int recipeBook_id) {
		String statement = "* FROM recipes r join recipe2recipebook r2rb where r2rb.recipebook_id = :recipeBook_id";
		Query query = session.createQuery(statement);
		query.setParameter("recipeBook_id", recipeBook_id);

		List<Recipes> receitas = query.getResultList();

		return receitas;
	}

}
