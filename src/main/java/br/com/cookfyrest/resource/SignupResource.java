package br.com.cookfyrest.resource;

import br.com.cookfyrest.model.entity.Identity;
import br.com.cookfyrest.model.entity.User;
import br.com.cookfyrest.repository.IdentityRepository;
import br.com.cookfyrest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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


    private UserRepository userRepo;
    private IdentityRepository identityRepo;

    @Autowired
    SignupResource(UserRepository userRepo, IdentityRepository identityRepo) {
        this.userRepo = userRepo;
        this.identityRepo = identityRepo;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> signup(@RequestBody User user) {
        userRepo.save(user);
        Identity identity = new Identity(user);
        identityRepo.save(identity);

        return new ResponseEntity(user, HttpStatus.CREATED);
    }
}