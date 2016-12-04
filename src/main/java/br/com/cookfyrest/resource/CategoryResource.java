package br.com.cookfyrest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<List<Category>> listCategories(){
		List<Category> categories = (List<Category>) categoryRepository.findAll();
		if (!categories.isEmpty()) {
			return new ResponseEntity<>(categories, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@RequestMapping(
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE,
			value = "{categoryId}"
			)
	public ResponseEntity<Category> showCategory(@PathVariable("categoryId") Long category_id){
		Category category = categoryRepository.findOne(category_id);
		if (category != null) {
			return new ResponseEntity<>(category, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<Category> createCategory(@RequestBody Category category){
		Category categoryCreated = categoryRepository.save(category);
		
		if (category != null) {
			return new ResponseEntity<>(categoryCreated, HttpStatus.OK);
		} 
		else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
