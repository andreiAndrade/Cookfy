package br.com.cookfyrest.dao;

import br.com.cookfyrest.model.Authentication;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by Andrei Andrade on 06/10/2016.
 */
public class AuthenticationDAO {
    private static AuthenticationDAO instance;
    private EntityManager em;

    public static AuthenticationDAO instance() {
        if (instance == null) {
            instance = new AuthenticationDAO();
        }
        return instance;
    }

    private AuthenticationDAO() {
        this.em = Persistence.createEntityManagerFactory("pu_cookfy").createEntityManager();
    }

    public void save(Authentication authentication) {
        this.em.getTransaction().begin();
        this.em.merge(authentication);
        this.em.getTransaction().commit();
    }

    public void delete(Authentication authentication) {
        authentication.setStatus(false);
        this.em.getTransaction().begin();
        this.em.merge(authentication);
        this.em.getTransaction().commit();
    }
}