package br.com.cookfyrest.resource;

import br.com.cookfyrest.model.React;
import br.com.cookfyrest.model.domain.ReactDomain;
import br.com.cookfyrest.repository.ReactRepository;
import br.com.cookfyrest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by Andrei Andrade on 29/10/2016.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/users")
public class UserResource {

    UserRepository userRepo;
    ReactRepository reactRepo;

    @Autowired
    UserResource(UserRepository userRepo, ReactRepository reactRepo) {
        this.userRepo = userRepo;
        this.reactRepo = reactRepo;
    }

    @RequestMapping(method = RequestMethod.GET,  path = "/reacts")
    public List<React> getFavorities(@RequestParam(name = "id") Long id, @RequestParam(name = "react", required = false) String[] reactsType) {
        List<React> reacts = new ArrayList<>();
        if (Objects.nonNull(reactsType)) {
            Arrays.stream(reactsType).forEach(rt -> reacts.addAll(reactRepo.findByReact(ReactDomain.valueOf(rt))));
        }
        return this.userRepo.findOne(id).getMyReacts();
    }

    public static void main(String[] args) {
        System.out.println(ReactDomain.valueOf("LOE"));
    }
}
