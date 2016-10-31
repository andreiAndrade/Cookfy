package br.com.cookfyrest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.cookfyrest.model.Ingredient;

public interface IngredientRepository extends PagingAndSortingRepository<Ingredient, Long>{
	public Ingredient findByName(String ingredient_name);
}
