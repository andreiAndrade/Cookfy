package br.com.cookfyrest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.cookfyrest.model.entity.Ingredient;

public interface IngredientRepository extends PagingAndSortingRepository<Ingredient, Long>{
	public Ingredient findByNameIgnoreCase(String ingredient_name);
}
