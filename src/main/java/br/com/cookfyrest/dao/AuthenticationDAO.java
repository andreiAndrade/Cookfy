package br.com.cookfyrest.dao;

import br.com.cookfyrest.model.Authentication;
import br.com.cookfyrest.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.UUID;

public class AuthenticationDAO {
    private static AuthenticationDAO instance;
    private Session session;

    public static AuthenticationDAO instance() {
        if (instance == null) {
            instance = new AuthenticationDAO();
        }
        return instance;
    }

    private AuthenticationDAO() {
        this.session = HibernateUtil.instance().getSessionFactory().openSession();
    }

    public String login(String username, String hash) {
        return UUID.randomUUID().toString();
    }

    public Authentication setOnlineState(Authentication authentication) {
        try {
            Transaction tx = session.beginTransaction();
            session.save(authentication);
            tx.commit();
        } catch (Exception e) {
            return null;
        }

        return authentication;
    }

}
