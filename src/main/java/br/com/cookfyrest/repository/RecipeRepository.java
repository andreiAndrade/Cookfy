package br.com.cookfyrest.repository;

import br.com.cookfyrest.model.Recipe;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Andrei Andrade on 17/10/2016.
 */
@RepositoryRestResource(collectionResourceRel = "recipe", path = "recipes")
public interface RecipeRepository extends PagingAndSortingRepository<Recipe, Long>{
}
