package br.com.cookfyrest.model.dto;

import java.util.List;

import br.com.cookfyrest.model.entity.RecipeStep;
import br.com.cookfyrest.model.domain.DifficultyDomain;

public class RecipeDTO {
	
	public RecipeDTO(){}
	
	public RecipeDTO(String recipe_name, Long chef_id, DifficultyDomain difficulty, Integer prepTime, Integer cookTime,
			List<Long> category_id, List<RecipeStep> recipeStep, List<String> ingredient_measure, String picture) {
		this.recipe_name = recipe_name;
		this.chef_id = chef_id;
		this.difficulty = difficulty;
		this.prepTime = prepTime;
		this.cookTime = cookTime;
		this.category_id = category_id;
		this.recipeStep = recipeStep;
		this.ingredient_measure = ingredient_measure;
		this.picture = picture;
	}
	
	List<Long> category_id;
	List<RecipeStep> recipeStep;
	List<String> ingredient_measure;
	String recipe_name;
	Long chef_id;
	DifficultyDomain difficulty;
	Integer prepTime;
	Integer cookTime;
	String picture;
	
	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

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

	public DifficultyDomain getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(DifficultyDomain difficulty) {
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

	public List<Long> getCategory_id() {
		return category_id;
	}

	public void setCategory_id(List<Long> category_id) {
		this.category_id = category_id;
	}

	public List<RecipeStep> getRecipeStep() {
		return recipeStep;
	}

	public void setRecipeStep(List<RecipeStep> recipeStep) {
		this.recipeStep = recipeStep;
	}

	public List<String> getIngredient_measure() {
		return ingredient_measure;
	}

	public void setIngredient_measure(List<String> ingredient_measure) {
		this.ingredient_measure = ingredient_measure;
	}
}