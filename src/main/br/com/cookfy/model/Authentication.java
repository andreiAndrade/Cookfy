package br.com.cookfy.model;

import org.hibernate.annotations.Type;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Authentication {
    @Id
    @GeneratedValue
    private int id;

    private int userID;

    private String token;

    @Column(name = "date_created")
    private Date dateCreated;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean status;

    public Authentication() {}

    public Authentication(int userID, String token) {
        this.userID = userID;
        this.token = token;
        this.status = true;
        this.dateCreated = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
