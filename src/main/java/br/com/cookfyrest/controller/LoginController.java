package br.com.cookfyrest.controller;

import br.com.cookfyrest.dao.AuthenticationDAO;
import br.com.cookfyrest.dao.UserDAO;
import br.com.cookfyrest.dto.AuthenticationDTO;
import br.com.cookfyrest.model.Authentication;
import br.com.cookfyrest.model.User;

import java.util.Date;
import java.util.UUID;

public class LoginController {
    public AuthenticationDTO login(String login, String hash) {
        User user = UserDAO.instance().findByUsernameOrEmail(login);

        if (user.getHash().equals(hash)) {
            return authenticate(user);
        }

        return null;
    }

    public AuthenticationDTO authenticate(User user) {
        String token = UUID.randomUUID().toString().replace("-", "") + new Date().getTime();
        Authentication authentication = new Authentication(user, token);
        AuthenticationDAO.instance().save(authentication);

        return new AuthenticationDTO(token, user.getId());
    }

//
//    public static void main(String[] args) {
//        Session s = HibernateUtil.instance().getSessionFactory().openSession();
//
//        LoginController lc = new LoginController();
//        LoginDTO l = new LoginDTO("andrei.andrade", "asdfghjkl");
//
//        lc.login(l);
//
//        if (!lc.isLoginSuccess()) System.out.println("fudeu");
//        else System.out.println("é tois birl");
//
//        System.exit(0);
//
//    }
//
}
