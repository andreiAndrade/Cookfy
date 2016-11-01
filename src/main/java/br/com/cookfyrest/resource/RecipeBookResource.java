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
	public List<RecipeBook> listRecipeBooksOfUser(@RequestParam(value = "userId") long user_id){
//		List<RecipeBook> listaLivros = new ArrayList<RecipeBook>();
//		RecipeBook book = new RecipeBook();
//		User user = new User("Bruno", "blabla@blabla", "usernamedoBruno");
//		
//		book.setName("Cafe da manha");
//		book.setId((long) 1);
//		book.setUser(user);
//		
//		
//		listaLivros.add(book);
//		
//		
//		return listaLivros;
		return repository.findByUserId(user_id);
	}
	
	@RequestMapping(value = "{bookId}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public RecipeBook listRecipesOfRecipeBook(@PathVariable(value = "bookId") long book_id){
//		List<Recipe> listaReceitas = new ArrayList<Recipe>();
//		
//		Recipe recipe1 = new Recipe();
//		Recipe recipe2 = new Recipe();
//		Recipe recipe3  = new Recipe();
//		Recipe recipe4 = new Recipe();
//		
//		recipe1.setName("Bolo");
//		recipe2.setName("Massa");
//		recipe3.setName("Pastel");
//		recipe4.setName("Hot dog");
//		
//		listaReceitas.add(recipe1);
//		listaReceitas.add(recipe2);
//		listaReceitas.add(recipe3);
//		listaReceitas.add(recipe4);
//		
//		return listaReceitas;
		return repository.findOne(book_id);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public RecipeBook createRecipeBook(@RequestBody RecipeBookDTO recipeBookDTO){
		RecipeBook recipeBook = new RecipeBook(
				recipeBookDTO.getName(), 
				userRepository.findOne(recipeBookDTO.getUser_id()));
		
		repository.save(recipeBook);
		//return new ResponseEntity<>(repository.findOne(recipeBook.getId()), HttpStatus.OK);
		return repository.findOne(recipeBook.getId());
	}
	
	@RequestMapping(
			value = "{bookId}/recipes/{recipeId}",
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public RecipeBook addRecipeToRecipeBook(
			@PathVariable("bookId") long book_id, @PathVariable("recipeId") long recipe_id){
	
//		RecipeBook book = repository.findOne(book_id);
//		for (Recipe i : recipe_ids){
//			book.addRecipe(i);
//		}
//		repository.save(book);
		
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