package br.com.cookfyrest.resource;

import br.com.cookfyrest.model.Recipe;
import br.com.cookfyrest.model.RecipeIngredient;
import br.com.cookfyrest.repository.RecipeIngredientRepository;
import br.com.cookfyrest.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Andrei Andrade on 24/10/2016.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/recipes")
public class RecipeResource {

    @Autowired
    RecipeRepository recipeRepo;
    @Autowired
    RecipeIngredientRepository recipeIngredientRepo;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Recipe> listRecipes() {
        return (List<Recipe>) recipeRepo.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Recipe findRecipe(@PathVariable(value = "id") Long id) {
        Recipe recipe = recipeRepo.findOne(id);
        recipe.setRecipeIngredients(recipeIngredientRepo.findByRecipe(recipe));

        return recipe;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveRecipe(@RequestBody Recipe recipe) {
        recipeRepo.save(recipe);
    }
}
