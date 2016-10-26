package br.com.cookfyrest.resource;

import br.com.cookfyrest.dto.AuthenticationDTO;
import br.com.cookfyrest.model.Authentication;
import br.com.cookfyrest.model.Identity;
import br.com.cookfyrest.model.User;
import br.com.cookfyrest.repository.AuthenticationRepository;
import br.com.cookfyrest.repository.IdentityRepository;
import br.com.cookfyrest.repository.UserRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;


/**
 * Created by Andrei Andrade on 29/08/2016.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/signup")
public class SignupResource {


    UserRepository userRepo;
    IdentityRepository identityRepo;

    @Autowired
    SignupResource(UserRepository userRepo, IdentityRepository identityRepo) {
        this.userRepo = userRepo;
        this.identityRepo = identityRepo;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity signup(@RequestBody User user) {
        userRepo.save(user);
        Identity identity = new Identity(user);
        identityRepo.save(identity);

        return new ResponseEntity(HttpStatus.CREATED);
    }
}