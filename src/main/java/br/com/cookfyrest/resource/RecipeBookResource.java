package br.com.cookfyrest.resource;

import java.util.List;
import java.util.Objects;
import java.util.zip.CRC32;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cookfyrest.model.dto.RecipeBookDTO;
import br.com.cookfyrest.model.entity.RecipeBook;
import br.com.cookfyrest.repository.RecipeBookRepository;
import br.com.cookfyrest.repository.RecipeRepository;
import br.com.cookfyrest.repository.UserRepository;


@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/recipeBook")
public class RecipeBookResource {
	
	@Autowired
	private RecipeBookRepository repository;
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RecipeBook>> listRecipeBooksOfUser(@RequestParam(value = "userId", required = false) Long user_id){
		List<RecipeBook> recipeBooks = null;

		if (user_id != null) {
			recipeBooks = repository.findByUserId(user_id);
		} else {
			recipeBooks = (List<RecipeBook>) repository.findAll();
		}

		if (!recipeBooks.isEmpty()) {
			return new ResponseEntity<>(recipeBooks, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@RequestMapping(value = "{bookId}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RecipeBook> listRecipesOfRecipeBook(@PathVariable(value = "bookId") long book_id){
		RecipeBook recipeBook = repository.findOne(book_id);
		if (Objects.nonNull(recipeBook)) {
			return new ResponseEntity<>(recipeBook, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RecipeBook> createRecipeBook(@RequestBody RecipeBookDTO recipeBookDTO){
		if (Objects.isNull(recipeBookDTO)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		RecipeBook recipeBook = new RecipeBook(
				recipeBookDTO.getName(), 
				userRepository.findOne(recipeBookDTO.getUser_id()));

		recipeBook = repository.save(recipeBook);
		return new ResponseEntity<>(recipeBook, HttpStatus.CREATED);
	}
	
	@RequestMapping(
			value = "{bookId}/recipes/{recipeId}",
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public RecipeBook addRecipeToRecipeBook(
			@PathVariable("bookId") long book_id, @PathVariable("recipeId") long recipe_id){
	
		RecipeBook book = repository.findOne(book_id);

		book.addRecipe(recipeRepository.findOne(recipe_id));
		repository.save(book);
		
		//return new ResponseEntity<>(repository.findOne(book_id), HttpStatus.OK);
		return repository.findOne(book_id);
	}
	
	@RequestMapping(
			value = "{bookId}/recipes/{recipeId}",
			method = RequestMethod.DELETE, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public RecipeBook deleteRecipeOfRecipeBook(
			@PathVariable("bookId") long book_id, @PathVariable("recipeId") long recipe_id){
		
		RecipeBook book = repository.findOne(book_id);
		book.deleteRecipe(recipeRepository.findOne(recipe_id));
		return repository.findOne(book_id);
	}
	
	@RequestMapping(
			value = "{bookId}",
			method = RequestMethod.DELETE, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteRecipeBook(
			@PathVariable("bookId") long book_id){
		
		repository.delete(book_id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}