package br.com.cookfyrest.resource;

import br.com.cookfyrest.dto.AuthenticationDTO;
import br.com.cookfyrest.dto.LoginDTO;
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
@RequestMapping(value = "/login")
public class LoginResource {

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public AuthenticationDTO getLogin(@RequestBody LoginDTO loginDTO) {

        return new AuthenticationDTO("token", 1);
    }
}
