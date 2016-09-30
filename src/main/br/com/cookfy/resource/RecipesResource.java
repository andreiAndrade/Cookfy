package br.com.cookfy.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.cookfy.dao.RecipesDAO;
import br.com.cookfy.model.Recipes;

@Path("recipes")
public class RecipesResource {

	@Path("{userID}")
	@GET
	@Produces("application/json")
	//lista receitas pelo id do usuario
	public List<Recipes> listRecipesOfAUser(@PathParam("userId") int user_id){
		RecipesDAO dao = new RecipesDAO();
		List<Recipes> recipes = dao.listRecipesByUserId(user_id);
		
		return recipes;
	}
	
	@Path("{bookId}")
	@GET
	@Produces("application/json")
	//lista receitas pelo id do recipe book
	public List<Recipes> listRecipesOfABook(@PathParam("bookId") int recipeBook_id){
		RecipesDAO dao = new RecipesDAO();
		List<Recipes> recipes = dao.listRecipesByRecipeBookId(recipeBook_id);
		
		return recipes;
	}
	
	@Path("{categoryId}")
	@GET
	@Produces("application/json")
	//lista receitas pelo id da categoria
	public List<Recipes> listRecipesOfACategory(@PathParam("categoryId") int category_id){
		RecipesDAO dao = new RecipesDAO();
		List<Recipes> recipes = dao.listRecipesByCategoryId(category_id);
		
		return recipes;
	}
	
	@Path("{recipeId}")
	@GET
	@Produces("application/json")
	//mostra a receita detalhada pelo id da receita
	public Recipes showRecipe(@PathParam("recipeId") int recipe_id){
		RecipesDAO dao = new RecipesDAO();
		Recipes recipe = dao.findRecipesById(recipe_id);
		
		return recipe;
	}

	
}
