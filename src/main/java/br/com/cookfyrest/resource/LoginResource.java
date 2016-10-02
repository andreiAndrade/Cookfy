package br.com.cookfyrest.resource;

import br.com.cookfyrest.controller.LoginController;
import br.com.cookfyrest.dto.AuthenticationDTO;
import br.com.cookfyrest.dto.LoginDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * Created by Andrei Andrade on 29/08/2016.
 */
@Path("login")
public class LoginResource {

	@POST
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(LoginDTO login) {

        AuthenticationDTO authentication = new AuthenticationDTO("token", 1);
        return Response.ok(authentication).build();

//		LoginController loginController = new LoginController();
//		loginController.login(login);
//
//		if (loginController.isLoginSuccess()) {
//			return Response.ok(loginController.getAuthenticationDTO()).build();
//		} else {
//			return Response.status(Status.UNAUTHORIZED).entity(loginController.getError()).build();
//		}
	}
}
