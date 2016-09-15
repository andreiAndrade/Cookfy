package br.com.cookfy.controller;

import br.com.cookfy.dao.IdentityDAO;
import br.com.cookfy.dao.UserDAO;
import br.com.cookfy.dto.SignupDTO;
import br.com.cookfy.model.Identity;
import br.com.cookfy.model.User;

public class SignupController {

    public static String signup(SignupDTO dto) {

        User user = new User(dto.getName(), dto.getUsername(), dto.getEmail());

        user = UserDAO.instance().save(user);

        Identity identity = new Identity(user.getId(), dto.getAdapter(), dto.getHash());

        identity = IdentityDAO.instance().save(identity);

        //return LoginController.login();  #tendo como premissa de que o login retorna um token

        return "";

    }

}
