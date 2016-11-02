package br.com.cookfyrest.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Andrei Andrade on 05/10/2016.
 */
@Entity(name = "RECIPE_BOOK")
@XmlRootElement
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class RecipeBook implements Serializable {

    @Transient
    private static final String SEQ = "seq_recipe_book";

    @Id
    @SequenceGenerator(name = SEQ, sequenceName = SEQ, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = SEQ)
    private Long id;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;


    @ManyToMany
    @JoinTable(
            name = "RECIPE_RECIPE_BOOK",
            joinColumns = {
                    @JoinColumn(name = "RECIPEBOOK_ID")},
            inverseJoinColumns = {
                    @JoinColumn(name = "RECIPE_ID")
            })
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

    public RecipeBook(String name, User user) {
        this.name = name;
        this.user = user;
    }

    public RecipeBook() {
    }

    public void addRecipe(Recipe recipe) {
        if (Objects.isNull(this.recipes)) {
            this.recipes = new ArrayList<>();
        }
        this.recipes.add(recipe);
        recipe.addRecipeBook(this);
    }

    public void deleteRecipe(Recipe recipe) {
        this.recipes.remove(recipe);
        recipe.deleteRecipeBook(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecipeBook that = (RecipeBook) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        return recipes != null ? recipes.equals(that.recipes) : that.recipes == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (recipes != null ? recipes.hashCode() : 0);
        return result;
    }
}
