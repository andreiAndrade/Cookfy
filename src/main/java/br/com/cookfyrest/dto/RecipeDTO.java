package br.com.cookfyrest.dto;

import java.util.Date;
import java.util.List;

import br.com.cookfyrest.model.RecipeStep;

public class RecipeDTO {
	
	public RecipeDTO(){}
	
	public RecipeDTO(String recipe_name, Long chef_id, String difficulty, Integer prepTime, Integer cookTime,
			Long category_id, List<RecipeStep> recipeStep, List<IngredientDTO> ingredients) {
		this.recipe_name = recipe_name;
		this.chef_id = chef_id;
		this.difficulty = difficulty;
		this.prepTime = prepTime;
		this.cookTime = cookTime;
		this.category_id = category_id;
		this.recipeStep = recipeStep;
		this.ingredients = ingredients;
	}
	
	Long category_id;
	List<RecipeStep> recipeStep;
	List<IngredientDTO> ingredients;
	String recipe_name;
	Long chef_id;
	String difficulty;
	Integer prepTime;
	Integer cookTime;
	public String getRecipe_name() {
		return recipe_name;
	}

	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}

	public Long getChef_id() {
		return chef_id;
	}

	public void setChef_id(Long chef_id) {
		this.chef_id = chef_id;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public Integer getPrepTime() {
		return prepTime;
	}

	public void setPrepTime(Integer prepTime) {
		this.prepTime = prepTime;
	}

	public Integer getCookTime() {
		return cookTime;
	}

	public void setCookTime(Integer cookTime) {
		this.cookTime = cookTime;
	}

	public Long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}

	public List<RecipeStep> getRecipeStep() {
		return recipeStep;
	}

	public void setRecipeStep(List<RecipeStep> recipeStep) {
		this.recipeStep = recipeStep;
	}

	public List<IngredientDTO> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<IngredientDTO> ingredients) {
		this.ingredients = ingredients;
	}
}