package br.com.cookfyrest.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;

import br.com.cookfyrest.model.Recipe;
import br.com.cookfyrest.util.HibernateUtil;


public class RecipesDAO {
	private Session session;
	private static RecipesDAO instance;
	private EntityManager em;

	public RecipesDAO() {
		this.em = HibernateUtil.instance().getEntityManager();
	}

	public static RecipesDAO instance() {
		if (instance == null) {
			instance = new RecipesDAO();
		}
		return instance;
	}

	public Recipe findRecipesByName(String name) {
		return new Recipe();
	}

	public List<Recipe> findRecipesByToken(String token) {
		return new ArrayList<Recipe>();
	}

	public Recipe findRecipeById(int id) {
		String statement = "* FROM recipe where id = :id";
		Query query = em.createQuery(statement, Recipe.class);
		query.setParameter("id", id);
		
		return (Recipe)query.getSingleResult();
	}

	public List<Recipe> listRecipeByUserId(int user_id) {
		String statement = "* FROM recipe r join user2recipe u2r where u2r.user_id = :user_id";
		Query query = em.createQuery(statement, Recipe.class);
		query.setParameter("user_id", user_id);

		List<Recipe> receitas = query.getResultList();

		return receitas;
	}

	public List<Recipe> listRecipeByCategoryId(int category_id) {
		String statement = "* FROM recipe r join recipes2category r2c where r2c.category_id = :category_id";
		Query query = em.createQuery(statement, Recipe.class);
		query.setParameter("category_id", category_id);

		List<Recipe> receitas = query.getResultList();

		return receitas;
	}

	public List<Recipe> listRecipesByRecipeBookId(int recipeBook_id) {
		String statement = "* FROM recipe r join recipe2recipebook r2rb where r2rb.recipebook_id = :recipeBook_id";
		Query query = em.createQuery(statement, Recipe.class);
		query.setParameter("recipeBook_id", recipeBook_id);

		List<Recipe> receitas = query.getResultList();

		return receitas;
	}

}
