package br.com.cookfy.dao;

import org.hibernate.Session;

import br.com.cookfy.model.Recipes;
import br.com.cookfy.util.HibernateUtil;

public class RecipesDAO {
	private Session session;
	
	private RecipesDAO(){
		this.session = HibernateUtil.instance().getSessionFactory().openSession();
	}
	
	public Recipes findRecipesByName(String name){
		return new Recipes();
	}
	
	public Recipes findRecipesByToken(String token){
		return new Recipes();
	}
	
	
	
	
	
}
