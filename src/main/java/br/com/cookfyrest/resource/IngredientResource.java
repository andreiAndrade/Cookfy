package br.com.cookfyrest.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cookfyrest.model.entity.Ingredient;
import br.com.cookfyrest.repository.IngredientRepository;

@RestController
@EnableAutoConfiguration
@RequestMapping("/ingredient")
public class IngredientResource {
	@Autowired
	IngredientRepository ingredientRepo;
	
	@RequestMapping(
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredientDTO){
		Ingredient ingredient = ingredientRepo.findByNameIgnoreCase(ingredientDTO.getName());
		if(ingredient == null){
			Ingredient ingredientCreated = ingredientRepo.save(ingredientDTO);
			if (ingredientCreated != null) {
				return new ResponseEntity<>(ingredientCreated, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		}else{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
		}
	}
}
