package br.com.cookfyrest.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Andrei Andrade on 20/10/2016.
 */
@Entity(name = "RECIPE_STEP")
@XmlRootElement
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class RecipeStep implements Serializable {
    @Transient
    private static final String SEQ = "seq_recipe_step";
    @Id
    @SequenceGenerator(name = SEQ, sequenceName = SEQ, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = SEQ)
    private Long id;
    //teste

    @Column(name = "STEP_ORDER")
    private Integer stepOrder;

    private String description;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Recipe recipe;

    public RecipeStep(){}
    
    public RecipeStep(String description, Integer stepOrder) {
		this.description = description;
		this.stepOrder = stepOrder;
	}
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStepOrder() {
        return stepOrder;
    }

    public void setStepOrder(int stepOrder) {
        this.stepOrder = stepOrder;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecipeStep that = (RecipeStep) o;

        if (stepOrder != that.stepOrder) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        return recipe != null ? recipe.equals(that.recipe) : that.recipe == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + stepOrder;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (recipe != null ? recipe.hashCode() : 0);
        return result;
    }
}
