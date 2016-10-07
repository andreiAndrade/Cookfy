package br.com.cookfyrest.resource;

import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cookfyrest.controller.RecipeController;
import br.com.cookfyrest.dao.RecipesDAO;
import br.com.cookfyrest.model.Recipe;

/**
 * Created by Andrei Andrade on 02/10/2016.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/recipes")
public class RecipesResource {

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Recipe> listRecipes() {
        RecipeController recipeController = new RecipeController();
        return recipeController.list();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{recId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Recipe findRecipe(@PathVariable("recId") Long recId) {
        RecipeController recipeController = new RecipeController();
        return recipeController.list().get(0);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{bookId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Recipe> listRecipesOfBook(@PathVariable("bookId") int book_id){
    	RecipesDAO dao = new RecipesDAO();
    	return dao.listRecipesByRecipeBookId(book_id);
    	//RecipeController recipeController = new RecipeController();
        //return recipeController.list();
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Recipe> listRecipesOfUser(@PathVariable("userId") int user_id){
    	RecipesDAO dao = new RecipesDAO();
    	return dao.listRecipeByUserId(user_id);
    	
    	//RecipeController recipeController = new RecipeController();
        //return recipeController.list();
    }
    
}
