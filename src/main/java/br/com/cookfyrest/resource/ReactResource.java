package br.com.cookfyrest.resource;

import br.com.cookfyrest.model.entity.React;
import br.com.cookfyrest.model.entity.Recipe;
import br.com.cookfyrest.model.entity.User;
import br.com.cookfyrest.repository.ReactRepository;
import br.com.cookfyrest.repository.RecipeRepository;
import br.com.cookfyrest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Andrei Andrade on 28/10/2016.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/reacts")
public class ReactResource {

    private ReactRepository reactRepo;
    private UserRepository userRepo;
    private RecipeRepository recipeRepo;

    @Autowired
    ReactResource(ReactRepository reactRepo, UserRepository userRepo, RecipeRepository recipeRepo) {
        this.reactRepo = reactRepo;
        this.userRepo = userRepo;
        this.recipeRepo = recipeRepo;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void react(@RequestBody React react) {
        Recipe recipe = recipeRepo.findOne(react.getRecipeId());
        User user = userRepo.findOne(react.getUserId());

        if (user != null && recipe != null) {
            react.setRecipe(recipe);
            react.setUser(user);
            reactRepo.save(react);
        } else {
            ResponseEntity.badRequest();
        }

    }
}
