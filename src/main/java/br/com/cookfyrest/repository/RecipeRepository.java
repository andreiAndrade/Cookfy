package br.com.cookfyrest.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.cookfyrest.model.Recipe;
import br.com.cookfyrest.model.User;

/**
 * Created by Andrei Andrade on 17/10/2016.
 */
public interface RecipeRepository extends PagingAndSortingRepository<Recipe, Long>{
	//List<Recipe> findRecipeByIngredient(Long ingredient_id);
	List<Recipe> findRecipeByChef(User chef);
}
