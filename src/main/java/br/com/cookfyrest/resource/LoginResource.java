package br.com.cookfyrest.resource;

import br.com.cookfyrest.controller.LoginController;
import br.com.cookfyrest.dto.AuthenticationDTO;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Andrei Andrade on 29/08/2016.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/login")
public class LoginResource {

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public AuthenticationDTO login(@RequestParam(value = "login") String login,
                                      @RequestParam(value = "hash") String hash) {
        AuthenticationDTO dto = new AuthenticationDTO("token", 1L);
        return dto;
    }
}
