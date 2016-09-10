package br.com.cookfy.dao;

import java.util.UUID;

public class AuthenticationDAO {
	private static AuthenticationDAO instance;

	private AuthenticationDAO() {
	}

	public static synchronized AuthenticationDAO getInstance() {
		if (instance == null) {
			instance = new AuthenticationDAO();
		}
		return instance;
	}
	
	public String login(String username, String hash) {
		return UUID.randomUUID().toString();
	}
}
