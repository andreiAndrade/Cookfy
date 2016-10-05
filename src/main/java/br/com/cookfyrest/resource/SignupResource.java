package br.com.cookfyrest.resource;

import br.com.cookfyrest.controller.SignupController;
import br.com.cookfyrest.dto.AuthenticationDTO;
import br.com.cookfyrest.dto.SignupDTO;
import br.com.cookfyrest.entity.User;
import br.com.cookfyrest.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
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

    @Autowired
    private UserRepository userRepo;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AuthenticationDTO signup(SignupDTO signup) {
        User user = SignupController.buildUser(signup);
        userRepo.save(user);

        return new AuthenticationDTO("token", 1L);
    }
}