package br.com.cookfyrest.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.cookfyrest.model.entity.RecipeBook;

//@RepositoryRestResource(collectionResourceRel = "recipeBook", path = "recipeBook")
public interface RecipeBookRepository extends PagingAndSortingRepository<RecipeBook, Long>{
	List<RecipeBook> findByUserId(long user_id);
}
