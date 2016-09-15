package br.com.cookfy.dao;

import java.util.UUID;

public class AuthenticationDAO {
	private static AuthenticationDAO instance;

	private AuthenticationDAO() {
		
	}

	public static AuthenticationDAO instance() {
		if (instance == null) {
			instance = new AuthenticationDAO();
		}
		return instance;
	}
	
	public String login(String username, String hash) {
		return UUID.randomUUID().toString();
	}
	
	public void setOnlineState(int user_id, String token){
		//do something to set state to online
	}
	
}
