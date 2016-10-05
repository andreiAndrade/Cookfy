package br.com.cookfyrest.service;

import br.com.cookfyrest.entity.Recipe;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RecipeRepository extends PagingAndSortingRepository<Recipe, Long> {

}
