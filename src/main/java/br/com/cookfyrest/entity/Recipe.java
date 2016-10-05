package br.com.cookfyrest.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
public class Recipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    @Column(name = "EXECUTION_TIME")
    private String executionTime;

    private String difficulty;

    @ManyToMany
    @JoinTable(
            name = "RECIPE_RECIPEBOOK",
            joinColumns = {
                    @JoinColumn(name = "RECIPE_ID")},
            inverseJoinColumns = {
                    @JoinColumn(name = "RECIPEBOOK_ID")})
    private List<RecipeBook> recipeBooks;

    private String igredients;

    @Column(name = "CATEGORIES_TAG")
    private String categoriesTag;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(String executionTime) {
        this.executionTime = executionTime;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public List<RecipeBook> getRecipeBooks() {
        return recipeBooks;
    }

    public void setRecipeBooks(List<RecipeBook> recipeBooks) {
        this.recipeBooks = recipeBooks;
    }

    public void addRecipeBook(RecipeBook recipeBook) {
        if(Objects.isNull(this.recipeBooks)) {
            this.recipeBooks = new ArrayList<>();
        }
        this.recipeBooks.add(recipeBook);
    }

    public String getIgredients() {
        return igredients;
    }

    public void setIgredients(String igredients) {
        this.igredients = igredients;
    }

    public String getCategoriesTag() {
        return categoriesTag;
    }

    public void setCategoriesTag(String categoriesTag) {
        this.categoriesTag = categoriesTag;
    }
}
