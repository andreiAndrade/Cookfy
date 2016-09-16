package br.com.cookfy.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.cookfy.controller.SignupController;
import br.com.cookfy.dto.SignupDTO;

/**
 * Created by Andrei Andrade on 29/08/2016.
 */
@Path("signup")
public class SignupResource {
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public String signup(SignupDTO dto) {
        String token = SignupController.signup(dto);
        return token;
    }


//    public static void main(String[] args) {
//        SignupDTO s = new SignupDTO();
//        s.setAdapter("application");
//        s.setEmail("email");
//        s.setHash("ushsaushahu");
//        s.setName("nome");
//        s.setUsername("username");
//        String token = signup(s);
//
//
//        System.out.println(token);
//    }
}