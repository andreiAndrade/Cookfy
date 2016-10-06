package br.com.cookfyrest.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class HibernateUtil {
    private static HibernateUtil instance = null;
    private static EntityManager em;

    private HibernateUtil() {
        em = Persistence.createEntityManagerFactory("pu_cookfy").createEntityManager();
    }

    public static HibernateUtil instance() {
        if (instance == null) {
            instance = new HibernateUtil();
        }
        return instance;
    }

    public EntityManager getEntityManager() {
        return em;
    }
}
