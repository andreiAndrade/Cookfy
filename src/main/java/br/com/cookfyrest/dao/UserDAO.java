package br.com.cookfyrest.dao;

import br.com.cookfyrest.model.User;

import javax.persistence.*;

/**
 * Created by Andrei Andrade on 06/10/2016.
 */
public class UserDAO {
    private static UserDAO instance;
    private EntityManager em;

    private UserDAO() {
        this.em = Persistence.createEntityManagerFactory("pu_cookfy").createEntityManager();
    }

    public static UserDAO instance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

    public void save(User user) {
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    public User findByUsernameOrEmail(String user) {
        String statment = "FROM User u WHERE u.username = :username OR u.email = :email";
        TypedQuery query = em.createQuery(statment, User.class);
        query.setParameter("username", user);
        query.setParameter("email", user);

        return (User) query.getSingleResult();
    }
}
