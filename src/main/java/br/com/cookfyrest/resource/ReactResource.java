package br.com.cookfyrest.resource;

import br.com.cookfyrest.model.React;
import br.com.cookfyrest.model.User;
import br.com.cookfyrest.repository.ReactRepository;
import br.com.cookfyrest.repository.RecipeRepository;
import br.com.cookfyrest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Andrei Andrade on 28/10/2016.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/reacts")
public class ReactResource {

    ReactRepository reactRepo;
    UserRepository userRepo;
    RecipeRepository recipeRepo;

    @Autowired
    ReactResource(ReactRepository reactRepo, UserRepository userRepo, RecipeRepository recipeRepo) {
        this.reactRepo = reactRepo;
        this.userRepo = userRepo;
        this.recipeRepo = recipeRepo;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void react(@RequestBody React react) {
        react.setRecipe(recipeRepo.findOne(react.getRecipeId()));
        react.setUser(userRepo.findOne(react.getUserId()));

        reactRepo.save(react);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<React> getReacts(@RequestParam(name = "id") Long id) {
        User user = userRepo.findOne(id);
        return reactRepo.findByUser(user);
    }
}
