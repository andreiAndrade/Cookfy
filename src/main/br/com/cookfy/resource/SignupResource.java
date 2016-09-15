package br.com.cookfy.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import br.com.cookfy.controller.SignupController;
import br.com.cookfy.dto.SignupDTO;

/**
 * Created by Andrei Andrade on 29/08/2016.
 */
@Path("signup")
public class SignupResource {
    @POST
    @Consumes("application/json")
    public String signup(SignupDTO dto) {
        return SignupController.signup(dto);
    }
}