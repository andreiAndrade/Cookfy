package br.com.cookfy.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Andrei Andrade on 29/08/2016.
 */
@XmlRootElement
public class Login {
    public String username;
    public String password;

    public Login() {}

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
