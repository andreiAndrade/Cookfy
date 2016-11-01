package br.com.cookfyrest.model.entity;

import br.com.cookfyrest.model.domain.DifficultyDomain;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@XmlRootElement
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class Recipe implements Serializable {

    @Transient
    private static final String SEQ = "seq_recipe";
    @Id
    @SequenceGenerator(name = SEQ, sequenceName = SEQ, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = SEQ)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    private DifficultyDomain difficulty;

    @ManyToMany
    @JoinTable(
            name = "RECIPE_RECIPE_BOOK",
            joinColumns = {
                    @JoinColumn(name = "RECIPE_ID")},
            inverseJoinColumns = {
                    @JoinColumn(name = "RECIPEBOOK_ID")})
    private List<RecipeBook> recipeBooks;

    @Transient
    private List<RecipeIngredient> recipeIngredients;

    @ManyToMany
    @JoinTable(
            name = "RECIPE_CATEGORY",
            joinColumns = {
                    @JoinColumn(name = "RECIPE_ID")},
            inverseJoinColumns = {
                    @JoinColumn(name = "CATEGORY_ID")})
    private List<Category> categories;

    private Integer prepTime;

    private Integer cookTime;

    @ManyToOne(cascade = CascadeType.ALL)
    private User chef;

    @OneToMany(mappedBy = "recipe")
    private List<React> reacts;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<RecipeStep> recipeSteps;

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

    public DifficultyDomain getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(DifficultyDomain difficulty) {
        this.difficulty = difficulty;
    }

    public List<RecipeBook> getRecipeBooks() {
        return recipeBooks;
    }

    public void setRecipeBooks(List<RecipeBook> recipeBooks) {
        this.recipeBooks = recipeBooks;
    }

    public void addRecipeBook(RecipeBook recipeBook) {
        if (Objects.isNull(this.recipeBooks)) {
            this.recipeBooks = new ArrayList<>();
        }
        this.recipeBooks.add(recipeBook);
    }

    public void deleteRecipeBook(RecipeBook recipeBook) {
        this.recipeBooks.remove(recipeBook);
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public void addRecipeIngredient(RecipeIngredient recipeIngredient) {
        if (Objects.nonNull(recipeIngredient)) {
            if (Objects.isNull(this.recipeIngredients)) {
                this.recipeIngredients = new ArrayList<>();
            }
            this.recipeIngredients.add(recipeIngredient);
            recipeIngredient.setRecipe(this);
        }
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void addCategory(Category category) {
        if (Objects.nonNull(category)) {
            if (Objects.isNull(this.categories)) {
                this.categories = new ArrayList<>();
            }
            this.categories.add(category);
        }
    }

    public Integer getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public User getChef() {
        return chef;
    }

    public void setChef(User chef) {
        this.chef = chef;
    }

    public List<React> getReacts() {
        return reacts;
    }

    public void setReacts(List<React> reacts) {
        this.reacts = reacts;
    }

    public void addUserReactRecipes(React react) {
        if (Objects.nonNull(react)) {
            if (Objects.isNull(this.reacts)) {
                this.reacts = new ArrayList<>();
            }
            this.reacts.add(react);
            react.setRecipe(this);
        }
    }

    public List<RecipeStep> getRecipeSteps() {
        return recipeSteps;
    }

    public void setRecipeSteps(List<RecipeStep> recipeSteps) {
        this.recipeSteps = recipeSteps;
    }

    public void addRecipeStep(RecipeStep recipeStep) {
        if (Objects.nonNull(recipeStep)) {
            if (Objects.isNull(this.recipeSteps)) {
                this.recipeSteps = new ArrayList<>();
            }
            this.recipeSteps.add(recipeStep);
            recipeStep.setRecipe(this);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recipe recipe = (Recipe) o;

        if (id != null ? !id.equals(recipe.id) : recipe.id != null) return false;
        if (name != null ? !name.equals(recipe.name) : recipe.name != null) return false;
        if (description != null ? !description.equals(recipe.description) : recipe.description != null) return false;
        if (difficulty != null ? !difficulty.equals(recipe.difficulty) : recipe.difficulty != null) return false;
        if (recipeBooks != null ? !recipeBooks.equals(recipe.recipeBooks) : recipe.recipeBooks != null) return false;
        if (recipeIngredients != null ? !recipeIngredients.equals(recipe.recipeIngredients) : recipe.recipeIngredients != null)
            return false;
        if (categories != null ? !categories.equals(recipe.categories) : recipe.categories != null) return false;
        if (prepTime != null ? !prepTime.equals(recipe.prepTime) : recipe.prepTime != null) return false;
        if (cookTime != null ? !cookTime.equals(recipe.cookTime) : recipe.cookTime != null) return false;
        if (chef != null ? !chef.equals(recipe.chef) : recipe.chef != null) return false;
        if (reacts != null ? !reacts.equals(recipe.reacts) : recipe.reacts != null)
            return false;
        return recipeSteps != null ? recipeSteps.equals(recipe.recipeSteps) : recipe.recipeSteps == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (difficulty != null ? difficulty.hashCode() : 0);
        result = 31 * result + (recipeBooks != null ? recipeBooks.hashCode() : 0);
        result = 31 * result + (recipeIngredients != null ? recipeIngredients.hashCode() : 0);
        result = 31 * result + (categories != null ? categories.hashCode() : 0);
        result = 31 * result + (prepTime != null ? prepTime.hashCode() : 0);
        result = 31 * result + (cookTime != null ? cookTime.hashCode() : 0);
        result = 31 * result + (chef != null ? chef.hashCode() : 0);
        result = 31 * result + (reacts != null ? reacts.hashCode() : 0);
        result = 31 * result + (recipeSteps != null ? recipeSteps.hashCode() : 0);
        return result;
    }
}
