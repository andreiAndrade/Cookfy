package br.com.cookfyrest.dao;

import br.com.cookfyrest.model.User;
import br.com.cookfyrest.util.HibernateUtil;

import javax.persistence.*;

/**
 * Created by Andrei Andrade on 06/10/2016.
 */
public class UserDAO {
    private static UserDAO instance;
    private EntityManager em;

    private UserDAO() {
        this.em = HibernateUtil.instance().getEntityManager();
    }

    public static UserDAO instance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

    public void save(User user) {
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.clear();
            throw e;
        }
    }

    public User findByUsernameOrEmail(String user) {
        String statment = "FROM User u WHERE u.username = :username OR u.email = :email";
        TypedQuery query = em.createQuery(statment, User.class);
        query.setParameter("username", user);
        query.setParameter("email", user);

        return (User) query.getSingleResult();
    }
}
