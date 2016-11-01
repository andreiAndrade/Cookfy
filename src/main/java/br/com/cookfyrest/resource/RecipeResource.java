package br.com.cookfyrest.resource;

import br.com.cookfyrest.dto.IngredientDTO;
import br.com.cookfyrest.dto.RecipeDTO;
import br.com.cookfyrest.model.*;
import br.com.cookfyrest.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @Autowired
    IngredientRepository ingredientRepo;
    @Autowired
    UserRepository userRepo;
    @Autowired
    CategoryRepository categoryRepo;
    @Autowired
    RecipeStepRepository recipeStepRepo;

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

    @RequestMapping(value = "/ingredients",
            method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String[] findRecipesByIngredients(
            @RequestParam(value = "ingredient", required = false) String[] ingredients) {
        List<Ingredient> listOfIngredients = new ArrayList<Ingredient>();
        for (String ingredient_name : ingredients) {
            listOfIngredients.add(ingredientRepo.findByName(ingredient_name));
        }

        for (int i = 0; i < listOfIngredients.size(); i++) {

        }


        return ingredients;
    }

    @RequestMapping(
            value = "/myRecipes",
            method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Recipe> listRecipesOfAChef(@RequestParam(value = "chefId") Long chef_id) {

        return recipeRepo.findRecipeByChef(userRepo.findOne(chef_id));
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Recipe createRecipe(
            @RequestBody RecipeDTO recipeDTO) {

        String description = "";
        Recipe recipe = new Recipe();
        List<Category> category = new ArrayList<Category>();
        category.add(categoryRepo.findOne(recipeDTO.getCategory_id()));


        for (RecipeStep step : recipeDTO.getRecipeStep()) {
            description = description + step.getDescription() + ";";
        }

        recipe.setRecipeSteps(recipeDTO.getRecipeStep());
        recipe.setDescription(description);
        recipe.setCategories(category);
        recipe.setChef(userRepo.findOne(recipeDTO.getChef_id()));
        recipe.setCookTime(recipeDTO.getCookTime());
        recipe.setPrepTime(recipeDTO.getPrepTime());
        recipe.setDifficulty(recipeDTO.getDifficulty());
        recipe.setName(recipeDTO.getRecipe_name());

        recipe = recipeRepo.save(recipe);

        //hora de add o relacionamento recipe ingredient
        //verifica se o ingredient ja existe
        //se nao existir ele eh criado SEM DESCRICAO
        for (IngredientDTO i : recipeDTO.getIngredients()) {
            Ingredient ingredient = ingredientRepo.findByName(i.getIngredient());

            if (ingredient == null) {
                ingredient = ingredientRepo.save(new Ingredient(i.getIngredient()));
            }
            recipeIngredientRepo.save(new RecipeIngredient(ingredient, i.getMeasure(), recipe));
        }

//    	//adding relacionamento recipe recipeStep
//    	for(RecipeStep step : recipeDTO.getRecipeStep()){
//    		step.setRecipe(recipe);
//    		recipeStepRepo.save(step);
//    	}

        return recipe;
    }

}
