package br.com.cookfy.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Andrei Andrade on 29/08/2016.
 */
@XmlRootElement
public class Signup {
    private String email;
    private String username;
    private String password;
    private boolean success;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }
}
