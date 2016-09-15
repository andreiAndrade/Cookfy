package br.com.cookfy.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.cookfy.model.User;
import br.com.cookfy.util.HibernateUtil;

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
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		
		return user;
	}

	public User findByUsername(String username) {
		// return (User) sessao.load(User.class, username);

		return new User();
	}

	public User findByEmail(String email) {
		// return (User) sessao.load(User.class, email);

		return new User();
	}
}
