package br.com.cookfyrest.resource;

import br.com.cookfyrest.dto.RecipeSearchPriority;
import br.com.cookfyrest.model.domain.ReactDomain;
import br.com.cookfyrest.model.dto.RecipeDTO;
import br.com.cookfyrest.model.entity.*;
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
    @Autowired
    ReactRepository reactRepo;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Recipe> listRecipes() {
        return (List<Recipe>) recipeRepo.findAll();
    }


    @RequestMapping(method = RequestMethod.POST, path = "/{id}/reacts")
    public void reactRecipe(@PathVariable(value = "id") Long recipeId, @RequestParam(value = "user") Long userId, @RequestParam(value = "react") String reactType) {
        React react = new React();
        react.setRecipe(recipeRepo.findOne(recipeId));
        react.setUser(userRepo.findOne(userId));
        react.setReact(ReactDomain.valueOf(reactType.toUpperCase()));
        reactRepo.save(react);
    }

    @RequestMapping(value = "/ingredients",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RecipeSearchPriority> findRecipesByIngredients(
            @RequestParam(value = "ingredient") String[] ingredients) {
        List<Ingredient> listOfIngredients = new ArrayList<Ingredient>();

        List<RecipeSearchPriority> listOfPriorities = new ArrayList<>();

        System.out.println(ingredients[0]);


        for (String ingredient_name : ingredients) {
            List<Recipe> listOfRecipesOfAnIngredient = new ArrayList<Recipe>();
            Ingredient ingredient = ingredientRepo.findByName(ingredient_name);
            System.out.println(ingredient.getName());
            listOfIngredients.add(ingredient);

            if (ingredient != null) {


                List<RecipeIngredient> recipeIngredient = recipeIngredientRepo.findByIngredient(ingredient);
                //System.out.println(recipeIngredient.get(0).getRecipe().getName());
                for (RecipeIngredient ri : recipeIngredient) {
                    listOfRecipesOfAnIngredient.add(ri.getRecipe());
                }


                //System.out.println(listOfRecipesOfAnIngredient.get(0).getName());
                for (Recipe recipe : listOfRecipesOfAnIngredient) {
                    boolean haveToAdd = true;

                    for (int i = 0; i < listOfPriorities.size(); i++) {
                        if (listOfPriorities.get(i).getRecipe().equals(recipe)) {
                            List<Ingredient> ingredientsOfPrioritizedRecipe = listOfPriorities.get(i).getIngredients();
                            ingredientsOfPrioritizedRecipe.add(ingredient);

                            listOfPriorities.get(i).setPriority(listOfPriorities.get(i).getPriority() + 1);
                            listOfPriorities.get(i).setIngredients(ingredientsOfPrioritizedRecipe);
                            haveToAdd = false;
                        }
                    }
                    if (haveToAdd) {
                        List<Ingredient> iList = new ArrayList<Ingredient>();
                        iList.add(ingredient);
                        RecipeSearchPriority rsp = new RecipeSearchPriority(recipe, iList, 1);
                        listOfPriorities.add(rsp);
                    }
                }
            }
        }
        return listOfPriorities;
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
        //ingrediente vem como uma lista de strings - ingredient;measure
        for (String i : recipeDTO.getIngredient_measure()) {
            String[] ingredientAndMeasure = i.split(";");
            Ingredient ingredient = ingredientRepo.findByName(ingredientAndMeasure[0]);

            if (ingredient == null) {
                ingredient = ingredientRepo.save(new Ingredient(ingredientAndMeasure[0]));
            }
            recipeIngredientRepo.save(new RecipeIngredient(ingredient, ingredientAndMeasure[1], recipe));
        }

//    	//adding relacionamento recipe recipeStep
//    	for(RecipeStep step : recipeDTO.getRecipeStep()){
//    		step.setRecipe(recipe);
//    		recipeStepRepo.save(step);
//    	}

        return recipe;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Recipe findRecipe(@PathVariable(value = "id") Long id) {
        Recipe recipe = recipeRepo.findOne(id);
        recipe.setRecipeIngredients(recipeIngredientRepo.findByRecipe(recipe));

        return recipe;
    }


}
