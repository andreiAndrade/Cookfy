package br.com.cookfyrest.dao;

import br.com.cookfyrest.model.Recipes;
import br.com.cookfyrest.util.HibernateUtil;
import org.hibernate.Session;

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
