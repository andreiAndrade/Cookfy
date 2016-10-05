package br.com.cookfyrest.dto;

/**
 * Created by andrei.andrade on 23/09/2016.
 */
public class AuthenticationDTO {
    private String token;
    private Long id;

    public AuthenticationDTO() {
    }

    public AuthenticationDTO(String token, Long id) {
        this.token = token;
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
