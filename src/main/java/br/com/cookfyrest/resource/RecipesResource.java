package br.com.cookfyrest.resource;

import br.com.cookfyrest.entity.Recipe;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Andrei Andrade on 02/10/2016.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/recipes")
public class RecipesResource {

    @RequestMapping(method = RequestMethod.GET, value = "/{recId}", produces = MediaType.APPLICATION_JSON_VALUE )
    public Recipe findRecipe(@PathVariable("recId") Long recId) {
        Recipe recipe = new Recipe();
        recipe.setId(recId);
        recipe.setName("Bolo");
        recipe.setDescription("Modo de preparo: misture os ingredientes, asse e coma!");
        recipe.setDifficulty("Fácil");
        recipe.setExecutionTime("2h");

        return recipe;
    }

}
