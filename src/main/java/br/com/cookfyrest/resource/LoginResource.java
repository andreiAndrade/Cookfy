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
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public AuthenticationDTO login(@RequestParam(value = "user") String login,
                                      @RequestParam(value = "hash") String hash) {
        LoginController loginController = new LoginController();
        return loginController.login(login, hash);
    }
}
