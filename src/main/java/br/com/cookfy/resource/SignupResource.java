package br.com.cookfy.resource;

import br.com.cookfy.model.Signup;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by Andrei Andrade on 29/08/2016.
 */
@Path("signup")
public class SignupResource {
    @POST
    @Consumes("application/json")
    public boolean signup(Signup signup) {
        return true;
    }
}
