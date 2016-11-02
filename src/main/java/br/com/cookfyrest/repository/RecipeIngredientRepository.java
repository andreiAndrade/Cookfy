package br.com.cookfyrest.repository;

import br.com.cookfyrest.model.entity.Ingredient;
import br.com.cookfyrest.model.entity.Recipe;
import br.com.cookfyrest.model.entity.RecipeIngredient;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by Andrei Andrade on 24/10/2016.
 */
public interface RecipeIngredientRepository extends PagingAndSortingRepository<RecipeIngredient, Long> {

    List<RecipeIngredient> findByRecipe(Recipe recipe);

	List<RecipeIngredient> findByIngredient(Ingredient ingredient);
}
