package br.com.cookfy.resource;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.cookfy.controller.SignupController;
import br.com.cookfy.dto.SignupDTO;

/**
 * Created by Andrei Andrade on 29/08/2016.
 */
@Path("signup")
public class SignupResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response signup(SignupDTO signup) {
        SignupController signupController = new SignupController();
        signupController.signup(signup);
        
        if (signupController.isSignupSuccess()) {
        	return Response.ok(signupController.getAuthenticationDTO()).build();
        } else {
        	System.out.println("Erro ao cadastrar!");
        	return Response.status(Status.BAD_REQUEST).entity(signupController.getError()).build();
        }
    }
}