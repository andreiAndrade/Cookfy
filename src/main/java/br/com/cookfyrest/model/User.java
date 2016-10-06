package br.com.cookfyrest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by Andrei Andrade on 10/09/2016.
 */
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    private String hash;

    private String adapter;

    @Column(name = "DATE_CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Column(name = "DATE_UPDATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<RecipeBook> recipeBooks;

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
        recipeBook.setUser(this);
    }
}
