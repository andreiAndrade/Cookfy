package br.com.cookfyrest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.cookfyrest.model.Category;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long>{
	
}
