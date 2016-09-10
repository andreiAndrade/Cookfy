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
		return new User();
	}
}
