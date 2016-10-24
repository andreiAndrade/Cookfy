package br.com.cookfyrest.repository;

import br.com.cookfyrest.model.Recipe;
import br.com.cookfyrest.model.RecipeIngredient;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by Andrei Andrade on 24/10/2016.
 */
public interface RecipeIngredientRepository extends PagingAndSortingRepository<RecipeIngredient, Long> {

    List<RecipeIngredient> findByRecipe(Recipe recipe);
}
