package br.com.cookfyrest.resource;

import br.com.cookfyrest.controller.SignupController;
import br.com.cookfyrest.dto.AuthenticationDTO;
import br.com.cookfyrest.dto.SignupDTO;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by Andrei Andrade on 29/08/2016.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/signup")
public class SignupResource {

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AuthenticationDTO signup(@RequestBody SignupDTO signup) {
        SignupController signupController = new SignupController();
        return signupController.signup(signup);
    }
}