package br.com.cookfyrest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.cookfyrest.model.RecipeStep;

public interface RecipeStepRepository extends PagingAndSortingRepository<RecipeStep, Long>{
	RecipeStep findByDescription(String description);
	
}
