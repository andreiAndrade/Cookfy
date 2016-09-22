package br.com.cookfy.controller;

import br.com.cookfy.dao.IdentityDAO;
import br.com.cookfy.dao.UserDAO;
import br.com.cookfy.dto.LoginDTO;
import br.com.cookfy.dto.SignupDTO;
import br.com.cookfy.model.Identity;
import br.com.cookfy.model.User;

public class SignupController {
	
	private static StringBuilder messageBuilder;

    public static String signup(SignupDTO dto) {
    	
    	if (!validade(dto)) {
    		return messageBuilder.toString();
    	};

        User user = new User(dto.getName(), dto.getUsername(), dto.getEmail());
        user = UserDAO.instance().save(user);
        if (user == null) return null;

        Identity identity = new Identity(user.getId(), dto.getAdapter(), dto.getHash());
        identity = IdentityDAO.instance().save(identity);
        if (identity == null) return null;

        LoginDTO login = new LoginDTO(user.getName(), identity.getHash());
        String token = LoginController.login(login); 
        
        return token;

    }
    
    private static boolean validade(SignupDTO dto) {
    	/*
    	 * Checks if exist already username
    	 * Checks if exist already email
    	 */
    	messageBuilder = new StringBuilder();
    	boolean isValid = true;
    	
    	if (UserDAO.instance().findByUsername(dto.getUsername()) != null) {
    		messageBuilder.append("Username already exist;");
    		isValid = false;
    	}
    	if (UserDAO.instance().findByEmail(dto.getEmail()) != null) {
    		messageBuilder.append("Email already exist;");
    		isValid = false;    		
    	}
    	
    	return isValid;
    }

}
