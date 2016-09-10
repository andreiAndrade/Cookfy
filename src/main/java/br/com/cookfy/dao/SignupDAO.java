package br.com.cookfy.dao;

import br.com.cookfy.model.Signup;

public class SignupDAO {
	private static SignupDAO instance;

	private SignupDAO() {
	}

	public static synchronized SignupDAO getInstance() {
		if (instance == null) {
			instance = new SignupDAO();
		}
		return instance;
	}
	
	public void register(Signup signup) {
		
	}
}
