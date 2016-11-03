package br.com.cookfyrest.model.entity;

import br.com.cookfyrest.model.domain.ReactDomain;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Andrei Andrade on 20/10/2016.
 */
@Entity(name = "REACT")
@XmlRootElement
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class React implements Serializable {
    @Transient
    private static final String SEQ = "seq_react";
    @Id
    @SequenceGenerator(name = SEQ, sequenceName = SEQ, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = SEQ)
    private Long id;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Recipe recipe;

    @Transient
    private Long recipeId;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private User user;

    @Transient
    private Long userId;

    @Enumerated(EnumType.STRING)
    private ReactDomain react;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;

        if (Objects.nonNull(this.recipe))
            this.recipeId = this.recipe.getId();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;

        if (Objects.nonNull(this.user))
            this.userId = this.user.getId();
    }

    public ReactDomain getReact() {
        return react;
    }

    public void setReact(ReactDomain react) {
        this.react = react;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        React that = (React) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (recipe != null ? !recipe.equals(that.recipe) : that.recipe != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        return react == that.react;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (recipe != null ? recipe.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (react != null ? react.hashCode() : 0);
        return result;
    }
}
