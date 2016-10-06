package br.com.cookfyrest.controller;

import br.com.cookfyrest.dao.UserDAO;
import br.com.cookfyrest.dto.AuthenticationDTO;
import br.com.cookfyrest.dto.SignupDTO;
import br.com.cookfyrest.model.User;

import java.util.Date;

public class SignupController {

    public AuthenticationDTO signup(SignupDTO signupDTO) {
        User user = buildUser(signupDTO);
        UserDAO.instance().save(user);

        return login(user);
    }

    private AuthenticationDTO login(User user) {
        LoginController loginController = new LoginController();
        return loginController.login(user.getUsername(), user.getHash());
    }

    private User buildUser(SignupDTO signupDTO) {
        User user = new User();
        user.setName(signupDTO.getName());
        user.setUsername(signupDTO.getUsername());
        user.setEmail(signupDTO.getEmail());
        user.setAdapter(signupDTO.getAdapter());
        user.setHash(signupDTO.getHash());
        user.setDateCreated(new Date());
        user.setDateUpdated(new Date());

        return user;
    }
}
