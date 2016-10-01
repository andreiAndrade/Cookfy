package br.com.cookfy.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Andrei Andrade on 17/09/2016.
 */
@XmlRootElement
public class AuthenticationDTO {
    String token;
    int id;

    public AuthenticationDTO() {
    }

    public AuthenticationDTO(String token, int id) {
        this.token = token;
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
