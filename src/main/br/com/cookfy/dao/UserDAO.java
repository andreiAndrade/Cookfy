package br.com.cookfy.dao;

import br.com.cookfy.model.User;

public class UserDAO {
	private static UserDAO instance;

	private UserDAO() {
	}

	public static synchronized UserDAO getInstance() {
		if (instance == null) {
			instance = new UserDAO();
		}
		return instance;
	}
	
	public User save(User user) {
		//session.saveOrUpdate(user);
		return new User();
	}
	
	
	public User findByUsername(String username){
		//return (User) sessao.load(User.class, username);
		
		return new User();
	}
	
	public User findByEmail(String email){
		//return (User) sessao.load(User.class, email);
		
		return new User();
	}
}
