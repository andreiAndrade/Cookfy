package br.com.cookfyrest.service;

import br.com.cookfyrest.entity.RecipeBook;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RecipeBookRepository extends PagingAndSortingRepository<RecipeBook, Long> {

}
