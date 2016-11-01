package br.com.cookfyrest.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cookfyrest.model.entity.Category;
import br.com.cookfyrest.repository.CategoryRepository;

@RestController
@EnableAutoConfiguration
@RequestMapping(value="/categories")
public class CategoryResource {

	@Autowired
	CategoryRepository categoryRepository;
	
	@RequestMapping(
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Category> listCategories(){
		return categoryRepository.findAll();
	}
	
	@RequestMapping(
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE,
			value = "{categoryId}"
			)
	public Category showCategory(@PathVariable("categoryId") Long category_id){
		return categoryRepository.findOne(category_id);
	}
	
	
	
}
