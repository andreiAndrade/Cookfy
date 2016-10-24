package br.com.cookfyrest.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cookfyrest.model.Recipe;
import br.com.cookfyrest.model.RecipeBook;
import br.com.cookfyrest.model.User;
import br.com.cookfyrest.repository.RecipeBookRepository;
import br.com.cookfyrest.repository.RecipeRepository;


@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/recipeBook")
public class RecipeBookResource {
	
	@Autowired
	private RecipeBookRepository repository;
	
	@Autowired
	private RecipeRepository recipeRepository;

	@RequestMapping(
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<RecipeBook> listRecipeBooksOfUser(@RequestParam(value = "userId") long user_id){
		List<RecipeBook> listaLivros = new ArrayList<RecipeBook>();
		RecipeBook book = new RecipeBook();
		User user = new User("Bruno", "blabla@blabla", "usernamedoBruno");
		
		book.setName("Cafe da manha");
		book.setId((long) 1);
		book.setUser(user);
		
		
		listaLivros.add(book);
		
		
		return listaLivros;
	}
	
	@RequestMapping(value = "{bookId}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Recipe> listRecipesOfRecipeBook(@PathVariable(value = "bookId") long book_id){
		List<Recipe> listaReceitas = new ArrayList<Recipe>();
		
		Recipe recipe1 = new Recipe();
		Recipe recipe2 = new Recipe();
		Recipe recipe3  = new Recipe();
		Recipe recipe4 = new Recipe();
		
		recipe1.setName("Bolo");
		recipe2.setName("Massa");
		recipe3.setName("Pastel");
		recipe4.setName("Hot dog");
		
		listaReceitas.add(recipe1);
		listaReceitas.add(recipe2);
		listaReceitas.add(recipe3);
		listaReceitas.add(recipe4);
		
		return listaReceitas;
		//return recipeRepository.findRecipesOfBook(book_id);
	}
//	
//	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public Response createRecipeBook(@RequestBody RecipeBook recipeBook){
//		repository.save(recipeBook);
//		return null;
//	}
	
}