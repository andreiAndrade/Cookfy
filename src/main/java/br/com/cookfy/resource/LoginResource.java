package br.com.cookfy.resource;

<<<<<<< HEAD
import javax.ws.rs.GET;
=======

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
>>>>>>> branch 'master' of https://github.com/andreiAndrade/Cookfy.git
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.cookfy.controller.LoginController;
import br.com.cookfy.dto.LoginDTO;

/**
 * Created by Andrei Andrade on 29/08/2016.
 */
@Path("login")
public class LoginResource {

	@GET
	@Produces("application/json")
	public Response login(LoginDTO login) {
		String token = LoginController.login(login);

		if(token.equals(null)){
			return Response.status(Status.UNAUTHORIZED).build();
		}
		
		return Response.ok(token).build();
	}
}
