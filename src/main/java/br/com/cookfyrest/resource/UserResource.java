package br.com.cookfyrest.resource;

import br.com.cookfyrest.model.React;
import br.com.cookfyrest.model.domain.ReactDomain;
import br.com.cookfyrest.repository.ReactRepository;
import br.com.cookfyrest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;

/**
 * Created by Andrei Andrade on 29/10/2016.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/users")
public class UserResource {

    private UserRepository userRepo;
    private ReactRepository reactRepo;

    @Autowired
    UserResource(UserRepository userRepo, ReactRepository reactRepo) {
        this.userRepo = userRepo;
        this.reactRepo = reactRepo;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/reacts")
    public ResponseEntity<List<React>> getFavorites(@RequestParam(name = "id") Long id, @RequestParam(name = "react", required = false) String[] reactsType) {
        List<React> reacts = new ArrayList<>();

        if (reactsType == null || reactsType.length == 0) {
            reacts = this.userRepo.findOne(id).getMyReacts();
        } else {
            for (String react : reactsType) {
                ReactDomain reactDomain;

                try {
                    reactDomain = ReactDomain.valueOf(react);
                } catch (IllegalFormatException ife) {
                    continue;
                }

                reacts.addAll(reactRepo.findByReactAndUser(reactDomain, userRepo.findOne(id)));
            }
        }

        return reacts.isEmpty() ?
                new ResponseEntity<>(reacts, HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(reacts, HttpStatus.OK);
    }
}
