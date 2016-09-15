package br.com.cookfy.controller;

import java.util.UUID;

import br.com.cookfy.dao.AuthenticationDAO;
import br.com.cookfy.dao.IdentityDAO;
import br.com.cookfy.dao.UserDAO;
import br.com.cookfy.dto.LoginDTO;
import br.com.cookfy.model.User;

public class LoginController {

	public static String login(LoginDTO login) {
		User user;
		String token = null;

		user = login.getUser().contains("@") ? UserDAO.instance().findByEmail(login.getUser())
				: UserDAO.instance().findByUsername(login.getUser());

		if (IdentityDAO.instance().isValidPassword(user.getId(), login.getHash())) {
			token = UUID.randomUUID().toString() + ";" + user.getId();
			AuthenticationDAO.instance().setOnlineState(user.getId(), token);
		}

		return token;
	}

}
