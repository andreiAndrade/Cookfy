package br.com.cookfyrest.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Andrei Andrade on 20/10/2016.
 */
@Entity(name = "USER_REACT_RECIPE")
@XmlRootElement
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class UserReactRecipe implements Serializable {
    @Transient
    private static final String SEQ = "seq_user_react_recipe";
    @Id
    @SequenceGenerator(name = SEQ, sequenceName = SEQ, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = SEQ)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Recipe recipe;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    private Boolean favority;

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
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getFavority() {
        return favority;
    }

    public void setFavority(Boolean favority) {
        this.favority = favority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserReactRecipe that = (UserReactRecipe) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (recipe != null ? !recipe.equals(that.recipe) : that.recipe != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        return favority != null ? favority.equals(that.favority) : that.favority == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (recipe != null ? recipe.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (favority != null ? favority.hashCode() : 0);
        return result;
    }
}
