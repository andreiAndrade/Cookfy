package br.com.cookfy.controller;

import br.com.cookfy.dao.AuthenticationDAO;
import br.com.cookfy.dao.SignupDAO;
import br.com.cookfy.model.Signup;

public class SignupController {
	
	public String signup(Signup signup) {
		
		SignupDAO.getInstance().register(signup);
		
		String token = AuthenticationDAO.getInstance().login(signup.getUsername(), signup.getPassword());
		
		return token;
		
	}

}
