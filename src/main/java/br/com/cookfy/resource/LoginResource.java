package br.com.cookfy.resource;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * Created by Andrei Andrade on 29/08/2016.
 */
@Path("login")
public class LoginResource {
    @POST
    @Consumes("application/json")
    public boolean login(String login){
        return true;
    }
}
