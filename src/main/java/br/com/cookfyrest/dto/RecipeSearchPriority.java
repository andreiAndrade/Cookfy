package br.com.cookfyrest.dto;

import java.util.List;

import br.com.cookfyrest.model.entity.Ingredient;
import br.com.cookfyrest.model.entity.Recipe;


public class RecipeSearchPriority {
	Recipe recipe;
	List<Ingredient> ingredients;
	Integer priority;
	
	
	public RecipeSearchPriority(Recipe recipe, List<Ingredient> ingredients, Integer priority) {
		this.recipe = recipe;
		this.ingredients = ingredients;
		this.priority = priority;
	}
	
	public RecipeSearchPriority() {
	}

	public Recipe getRecipe() {
		return recipe;
	}


	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}


	public List<Ingredient> getIngredients() {
		return ingredients;
	}


	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}


	public Integer getPriority() {
		return priority;
	}


	public void setPriority(Integer priority) {
		this.priority = priority;
	}

}
