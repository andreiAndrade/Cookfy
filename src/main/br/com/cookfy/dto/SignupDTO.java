package br.com.cookfy.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Andrei Andrade on 10/09/2016.
 */

@XmlRootElement
public class SignupDTO {
    private String name, username, email, hash, adapter;

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


}
