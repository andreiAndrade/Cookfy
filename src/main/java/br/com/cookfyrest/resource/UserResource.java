package br.com.cookfyrest.resource;

import br.com.cookfyrest.model.domain.ReactDomain;
import br.com.cookfyrest.model.entity.React;
import br.com.cookfyrest.model.entity.Recipe;
import br.com.cookfyrest.model.entity.RecipeBook;
import br.com.cookfyrest.model.entity.User;
import br.com.cookfyrest.repository.ReactRepository;
import br.com.cookfyrest.repository.RecipeBookRepository;
import br.com.cookfyrest.repository.RecipeRepository;
import br.com.cookfyrest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by Andrei Andrade on 29/10/2016.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/users")
public class UserResource {

    private UserRepository userRepo;
    private ReactRepository reactRepo;
    private RecipeRepository recipeRepo;
    private RecipeBookRepository recipeBookRepo;

    @Autowired
    UserResource(UserRepository userRepo, ReactRepository reactRepo, RecipeRepository recipeRepo, RecipeBookRepository recipeBookRepo) {
        this.userRepo = userRepo;
        this.reactRepo = reactRepo;
        this.recipeRepo = recipeRepo;
        this.recipeBookRepo = recipeBookRepo;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> findUser(@PathVariable(name = "id") Long id) {
        User user = userRepo.findOne(id);
        if (Objects.nonNull(user)) {
            return ResponseEntity.status(HttpStatus.OK).body(user);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@PathVariable(name = "id") Long id, @RequestBody User user) {
        User oldUser = userRepo.findOne(id);
        oldUser.setPicture(user.getPicture());
        return userRepo.save(oldUser);

    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User saveUser(@RequestBody User user) {
        return this.userRepo.save(user);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@RequestBody User user) {
        User oldUser = userRepo.findByUsernameOrEmail(user.getUsername(), user.getEmail());
        return this.userRepo.save(oldUser);
    }

    @RequestMapping(method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteUser(@RequestBody User user) {
        User oldUser = userRepo.findByUsernameOrEmail(user.getUsername(), user.getEmail());
        this.userRepo.delete(oldUser);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}/reacts")
    public ResponseEntity<List<Recipe>> listFavorites(
            @PathVariable(name = "id") Long id,
            @RequestParam(name = "react", required = false) String[] reactsType
    ) {
        List<React> reacts = new ArrayList<>();

        if (reactsType == null || reactsType.length == 0) {
            reacts = this.userRepo.findOne(id).getMyReacts();
        } else {
            for (String react : reactsType) {
                reacts.addAll(reactRepo.findByReactAndUser(ReactDomain.valueOf(react), userRepo.findOne(id)));
            }
        }

        return reacts.isEmpty() ?
                new ResponseEntity<>(reacts.stream().map(React::getRecipe).collect(Collectors.toList()), HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(reacts.stream().map(React::getRecipe).collect(Collectors.toList()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}/recipes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Recipe>> listRecipes(@PathVariable(name = "id") Long id) {
        User user = this.userRepo.findOne(id);
        List<Recipe> recipes = this.recipeRepo.findRecipeByChef(user);

        return recipes.isEmpty() ?
                new ResponseEntity<>(recipes, HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(recipes, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}/recipebooks", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RecipeBook>> listRecipeBooks(@PathVariable(name = "id") Long id) {
        User user = this.userRepo.findOne(id);
        List<RecipeBook> recipeBooks = this.recipeBookRepo.findByUserId(id);

        return recipeBooks.isEmpty() ?
                new ResponseEntity<>(recipeBooks, HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(recipeBooks, HttpStatus.OK);
    }

}
