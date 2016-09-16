package br.com.cookfy.controller;

import java.util.Date;
import java.util.UUID;

import br.com.cookfy.dao.AuthenticationDAO;
import br.com.cookfy.dao.IdentityDAO;
import br.com.cookfy.dao.UserDAO;
import br.com.cookfy.dto.LoginDTO;
import br.com.cookfy.model.Authentication;
import br.com.cookfy.model.User;
import br.com.cookfy.util.HibernateUtil;
import org.hibernate.Session;

public class LoginController {

    public static String login(LoginDTO login) {
        User user;
        String token = null;

        user = login.getUser().contains("@") ? UserDAO.instance().findByEmail(login.getUser())
                : UserDAO.instance().findByUsername(login.getUser());

        if (user == null) return null;

        if (IdentityDAO.instance().isValidPassword(user.getId(), login.getHash())) {

            Authentication authentication = new Authentication(user.getId(), login.getHash());
            authentication = AuthenticationDAO.instance().setOnlineState(authentication);

            if (authentication != null)
                token = UUID.randomUUID().toString() + ";" + user.getId();
        }

        return token;
    }

    public static void main(String[] args) {
        Session s = HibernateUtil.instance().getSessionFactory().openSession();

        LoginDTO l = new LoginDTO("andrei", "jcgjkjhh");

        String hash = login(l);

        if (hash == null) System.out.println("fudeu");
        else System.out.println("é tois birl");
    }

}
