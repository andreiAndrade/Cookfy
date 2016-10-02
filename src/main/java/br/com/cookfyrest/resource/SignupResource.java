package br.com.cookfyrest.resource;

import br.com.cookfyrest.dto.AuthenticationDTO;
import br.com.cookfyrest.dto.SignupDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Andrei Andrade on 29/08/2016.
 */
@Path("signup")
public class SignupResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response signup(SignupDTO signup) {

        AuthenticationDTO authentication = new AuthenticationDTO("token", 1);
        return Response.ok(authentication).build();

//        SignupController signupController = new SignupController();
//        signupController.signup(signup);
//
//        if (signupController.isSignupSuccess()) {
//        	return Response.ok(signupController.getAuthenticationDTO()).build();
//        } else {
//        	System.out.println("Erro ao cadastrar!");
//        	return Response.status(Status.BAD_REQUEST).entity(signupController.getError()).build();
//        }
    }
}