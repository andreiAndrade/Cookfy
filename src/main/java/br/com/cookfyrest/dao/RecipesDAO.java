package br.com.cookfyrest.dao;

import br.com.cookfyrest.model.Recipe;
import br.com.cookfyrest.util.HibernateUtil;
import org.hibernate.Session;

public class RecipesDAO {
	private Session session;
	
	private RecipesDAO(){
		this.session = HibernateUtil.instance().getSessionFactory().openSession();
	}
	
	public Recipe findRecipesByName(String name){
		return new Recipe();
	}
	
	public Recipe findRecipesByToken(String token){
		return new Recipe();
	}
	
	
	
	
	
}
