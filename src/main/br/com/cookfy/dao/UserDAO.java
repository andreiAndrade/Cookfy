package br.com.cookfy.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.cookfy.model.User;
import br.com.cookfy.util.HibernateUtil;

import javax.persistence.Query;
import java.util.List;

public class UserDAO {
    private static UserDAO instance;
    private Session session;

    private UserDAO() {
        this.session = HibernateUtil.instance().getSessionFactory().openSession();
    }

    public static UserDAO instance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

    public User save(User user) {
        try {
            Transaction tx = session.beginTransaction();
            session.save(user);
            tx.commit();
        } catch (Exception e) {
            return null;
        }

        return user;
    }

    public User findByUsername(String username) {
        String statment = "FROM User u WHERE u.name = :name";
        Query query = session.createQuery(statment);
        query.setParameter("name", username);

        List<User> list = query.getResultList();
        return (list.isEmpty() || list == null) ? null : list.get(0);

    }

    public User findByEmail(String email) {
        // return (User) sessao.load(User.class, email);

        return new User();
    }
}
