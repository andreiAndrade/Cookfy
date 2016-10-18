package br.com.cookfyrest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Andrei Andrade on 05/10/2016.
 */
@Entity
public class RecipeBook implements Serializable {

    @Transient
    private static final String SEQ = "seq_recipe_book";

    @Id
    @SequenceGenerator(name = SEQ, sequenceName = SEQ, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = SEQ)
    private Long id;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    @ManyToMany(mappedBy = "recipeBooks", cascade = CascadeType.ALL)
    private List<Recipe> recipes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public void addRecipe(Recipe recipe) {
        if (Objects.isNull(this.recipes)) {
            this.recipes = new ArrayList<>();
        }
        this.recipes.add(recipe);
        recipe.addRecipeBook(this);
    }
}
