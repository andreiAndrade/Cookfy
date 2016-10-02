package br.com.cookfyrest.dao;

import br.com.cookfyrest.model.Identity;
import br.com.cookfyrest.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Andrei Andrade on 10/09/2016.
 */
public class IdentityDAO {
    private static IdentityDAO instance;
    private Session session;

    private IdentityDAO() {
        this.session = HibernateUtil.instance().getSessionFactory().openSession();
    }

    public static IdentityDAO instance() {
        if (instance == null) {
            instance = new IdentityDAO();
        }
        return instance;
    }

    public Identity save(Identity identity) {
//        try {
//            Transaction tx = session.beginTransaction();
//            session.save(identity);
//            tx.commit();
//        } catch (Exception e) {
//            return null;
//        }
//
//        return identity;
        return null;
    }

    public boolean isValidPassword(int userId, String hash) {
//        String statment = "FROM Identity i WHERE i.userId = :userId";
//        Query query = session.createQuery(statment);
//        query.setParameter("userId", userId);
//
//        List<Identity> list = query.getResultList();
//
//        if (!list.isEmpty() && list != null) {
//            return (list.get(0).getHash().equals(hash));
//        }

        return false;
    }

}
