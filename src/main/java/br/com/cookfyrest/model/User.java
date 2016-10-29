package br.com.cookfyrest.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * Created by Andrei Andrade on 10/09/2016.
 */
@Entity(name = "user_tab")
@JsonIdentityInfo(generator = JSOGGenerator.class)
@XmlRootElement
public class User implements Serializable {

    @Transient
    private static final String SEQ = "seq_user";

    @Id
    @SequenceGenerator(name = SEQ, sequenceName = SEQ, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = SEQ)
    private Long id;

    private String name;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    @Transient
    private String hash;

    @Transient
    private String adapter;

    @Column(name = "DATE_CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Column(name = "DATE_UPDATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated;

    @OneToMany(mappedBy = "user")
    private List<React> myReacts;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<RecipeBook> myRecipeBooks;
//
//    @OneToMany(mappedBy = "chef", cascade = CascadeType.ALL)
//    private List<Recipe> myRecipes;

    public User() {
    }

    public User(String name, String username, String email) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.dateCreated = new Date();
        this.dateUpdated = new Date();
    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getAdapter() {
        return adapter;
    }

    public void setAdapter(String adapter) {
        this.adapter = adapter;
    }

    public List<React> getMyReacts() {
        return myReacts;
    }

    public void setMyReacts(List<React> myReacts) {
        this.myReacts = myReacts;
    }

    //    public List<RecipeBook> getMyRecipeBooks() {
//        return myRecipeBooks;
//    }
//
//    public void setMyRecipeBooks(List<RecipeBook> myRecipeBooks) {
//        this.myRecipeBooks = myRecipeBooks;
//    }
//
//    public void addRecipeBook(RecipeBook recipeBook) {
//        if (Objects.isNull(this.myRecipeBooks)) {
//            this.myRecipeBooks = new ArrayList<>();
//        }
//        this.myRecipeBooks.add(recipeBook);
//        recipeBook.setUser(this);
//    }

//    public List<Recipe> getMyRecipes() {
//        return myRecipes;
//    }
//
//    public void setMyRecipes(List<Recipe> myRecipes) {
//        this.myRecipes = myRecipes;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (hash != null ? !hash.equals(user.hash) : user.hash != null) return false;
        if (adapter != null ? !adapter.equals(user.adapter) : user.adapter != null) return false;
        if (dateCreated != null ? !dateCreated.equals(user.dateCreated) : user.dateCreated != null) return false;
        return dateUpdated != null ? dateUpdated.equals(user.dateUpdated) : user.dateUpdated == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (hash != null ? hash.hashCode() : 0);
        result = 31 * result + (adapter != null ? adapter.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        result = 31 * result + (dateUpdated != null ? dateUpdated.hashCode() : 0);
        return result;
    }
}
