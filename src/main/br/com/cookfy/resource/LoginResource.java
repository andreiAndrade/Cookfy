package br.com.cookfy.resource;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.cookfy.controller.LoginController;
import br.com.cookfy.dto.LoginDTO;

/**
 * Created by Andrei Andrade on 29/08/2016.
 */
@Path("login")
public class LoginResource {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(LoginDTO login) {
		LoginController loginController = new LoginController();
		loginController.login(login);

		if (loginController.isLoginSuccess()) {
			return Response.ok(loginController.getAuthenticationDTO()).build();
		} else {
			return Response.status(Status.UNAUTHORIZED).entity(loginController.getError()).build();
		}
	}
}
