package br.com.cookfyrest.model.entity;

import br.com.cookfyrest.model.domain.DifficultyDomain;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;


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

    @Column( length = 100000 )
    private String description;

    @Enumerated(EnumType.STRING)
    private DifficultyDomain difficulty;

    @JsonIgnore
    @ManyToMany(mappedBy = "recipes", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<RecipeBook> recipeBooks;

    @Transient
    private Set<String> recipeBooksName;

    @Transient
    private List<RecipeIngredient> recipeIngredients;

    @JsonIgnore
    @ManyToMany(mappedBy = "recipes", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Category> categories;

    @Column(name = "prep_time")
    private int prepTime;

    @Column(name = "cook_time")
    private int cookTime;
    
    @Column( length = 10485760 )
    private String picture;

    public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@JsonIgnore
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private User chef;

    @OneToMany(mappedBy = "recipe")
    private List<React> reacts;

    @OneToMany(mappedBy = "recipe", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<RecipeStep> recipeSteps;

    @Transient
    private Boolean favority;

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
        if (Objects.nonNull(recipeBooks)) {
            this.recipeBooks = recipeBooks;
        }
    }

    public void addRecipeBook(RecipeBook recipeBook) {
        if (Objects.isNull(this.recipeBooks)) {
            this.recipeBooks = new ArrayList<>();
        }
        this.recipeBooks.add(recipeBook);
    }

    public Set<String> getRecipeBooksName() {
        if (Objects.isNull(this.recipeBooksName)) this.recipeBooksName= new HashSet<>();
        if (Objects.nonNull(this.recipeBooks))
            this.recipeBooks.forEach(c -> recipeBooksName.add(c.getName()));
        return recipeBooksName;
    }

    public void setRecipeBooksName(Set<String> recipeBooksName) {
        this.recipeBooksName = recipeBooksName;
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

    public List<String> getCategoriesName() {
        return this.categories.stream().map(Category::getName).collect(Collectors.toList());
    }

    public User getChef() {
        return chef;
    }

    public void setChef(User chef) {
        this.chef = chef;
    }

    public Long getChefId() {
        return this.chef.getId();
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

    public Boolean getFavority() {
        return favority;
    }

    public void setFavority(Boolean favority) {
        this.favority = favority;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public int getCookTime() {
        return cookTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recipe recipe = (Recipe) o;

        if (prepTime != recipe.prepTime) return false;
        if (cookTime != recipe.cookTime) return false;
        if (id != null ? !id.equals(recipe.id) : recipe.id != null) return false;
        if (name != null ? !name.equals(recipe.name) : recipe.name != null) return false;
        if (description != null ? !description.equals(recipe.description) : recipe.description != null) return false;
        if (difficulty != recipe.difficulty) return false;
        if (recipeBooks != null ? !recipeBooks.equals(recipe.recipeBooks) : recipe.recipeBooks != null) return false;
        if (recipeBooksName != null ? !recipeBooksName.equals(recipe.recipeBooksName) : recipe.recipeBooksName != null)
            return false;
        if (recipeIngredients != null ? !recipeIngredients.equals(recipe.recipeIngredients) : recipe.recipeIngredients != null)
            return false;
        if (categories != null ? !categories.equals(recipe.categories) : recipe.categories != null) return false;
        if (picture != null ? !picture.equals(recipe.picture) : recipe.picture != null) return false;
        if (chef != null ? !chef.equals(recipe.chef) : recipe.chef != null) return false;
        if (reacts != null ? !reacts.equals(recipe.reacts) : recipe.reacts != null) return false;
        if (recipeSteps != null ? !recipeSteps.equals(recipe.recipeSteps) : recipe.recipeSteps != null) return false;
        return favority != null ? favority.equals(recipe.favority) : recipe.favority == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (difficulty != null ? difficulty.hashCode() : 0);
        result = 31 * result + (recipeBooks != null ? recipeBooks.hashCode() : 0);
        result = 31 * result + (recipeBooksName != null ? recipeBooksName.hashCode() : 0);
        result = 31 * result + (recipeIngredients != null ? recipeIngredients.hashCode() : 0);
        result = 31 * result + (categories != null ? categories.hashCode() : 0);
        result = 31 * result + prepTime;
        result = 31 * result + cookTime;
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        result = 31 * result + (chef != null ? chef.hashCode() : 0);
        result = 31 * result + (reacts != null ? reacts.hashCode() : 0);
        result = 31 * result + (recipeSteps != null ? recipeSteps.hashCode() : 0);
        result = 31 * result + (favority != null ? favority.hashCode() : 0);
        return result;
    }
}
