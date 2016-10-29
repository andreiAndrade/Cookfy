package br.com.cookfyrest.resource;

import br.com.cookfyrest.dto.AuthenticationDTO;
import br.com.cookfyrest.model.Authentication;
import br.com.cookfyrest.model.Identity;
import br.com.cookfyrest.model.User;
import br.com.cookfyrest.repository.AuthenticationRepository;
import br.com.cookfyrest.repository.IdentityRepository;
import br.com.cookfyrest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by Andrei Andrade on 29/08/2016.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/login")
public class LoginResource {

    private final UserRepository userRepo;
    private final AuthenticationRepository authenticationRepo;
    private final IdentityRepository identityRepo;

    @Autowired
    LoginResource(UserRepository userRepo, AuthenticationRepository authenticationRepo, IdentityRepository identityRepo){
        this.userRepo = userRepo;
        this.authenticationRepo = authenticationRepo;
        this.identityRepo = identityRepo;
    }

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public AuthenticationDTO login(@RequestParam(value = "username", required = false) String username,
                                   @RequestParam(value = "email", required = false) String email,
                                   @RequestParam(value = "hash") String hash) {

        User user = userRepo.findByUsernameOrEmail(username, email);
        Identity identity = identityRepo.findByUser(user);

        if (Objects.nonNull(identity) && identity.getHash().equals(hash)) {

            String token = UUID.randomUUID().toString().replace("-", "") + new Date().getTime();
            Authentication auth = new Authentication(user, token);
            authenticationRepo.save(auth);

            return new AuthenticationDTO(auth.getToken(), auth.getUser().getId());
        }

        return null;
    }
}
