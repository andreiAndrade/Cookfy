package br.com.cookfyrest.resource;

import br.com.cookfyrest.dto.AuthenticationDTO;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    public AuthenticationDTO getLogin(@RequestParam(value = "user") String user,
                                      @RequestParam(value = "hash") String hash) {

        System.out.println("User: " + user);
        System.out.println("Hash: " + hash);
        return new AuthenticationDTO("token", 1L);
    }
}
