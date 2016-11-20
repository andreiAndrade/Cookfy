package br.com.cookfyrest.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.cookfyrest.model.entity.Recipe;
import br.com.cookfyrest.model.entity.User;
import org.springframework.data.repository.query.Param;

/**
 * Created by Andrei Andrade on 17/10/2016.
 */
public interface RecipeRepository extends PagingAndSortingRepository<Recipe, Long>{
	//List<Recipe> findRecipeByIngredient(Long ingredient_id);
	List<Recipe> findRecipeByChef(User chef);

	@Query("select r from Recipe r where lower(r.name) like lower(:name)")
	List<Recipe> findByName(@Param("name") String name);
}
