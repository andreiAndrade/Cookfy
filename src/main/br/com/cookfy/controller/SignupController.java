package br.com.cookfy.controller;

import br.com.cookfy.dao.IdentityDAO;
import br.com.cookfy.dao.UserDAO;
import br.com.cookfy.dto.LoginDTO;
import br.com.cookfy.dto.SignupDTO;
import br.com.cookfy.model.Identity;
import br.com.cookfy.model.User;

public class SignupController {

    private String errorMessage;
    private boolean signupSuccess;
    private String token;

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean isSignupSuccess() {
        return signupSuccess;
    }

    public String getToken() {
        return token;
    }

    public void signup(SignupDTO dto) {

        if (!validade(dto)) {
            this.signupSuccess = false;
        }
        ;

        User user = new User(dto.getName(), dto.getUsername(), dto.getEmail());
        user = UserDAO.instance().save(user);
        if (user == null) {
            this.errorMessage = "Ocorreu um erro inesperado ao realizar o cadastro";
            this.signupSuccess = false;
            return;
        }

        Identity identity = new Identity(user.getId(), dto.getAdapter(), dto.getHash());
        identity = IdentityDAO.instance().save(identity);
        if (identity == null) {
            this.errorMessage = "Ocorreu um erro inesperado ao realizar o cadastro";
            this.signupSuccess = false;
            return;
        }

        LoginDTO login = new LoginDTO(user.getName(), identity.getHash());
        this.token = LoginController.login(login);
        this.signupSuccess = true;
    }

    private boolean validade(SignupDTO dto) {
        /*
         * Checks if exist already username
    	 * Checks if exist already email
    	 */
        StringBuilder messageBuilder = new StringBuilder();
        boolean isValid = true;

        if (UserDAO.instance().findByUsername(dto.getUsername()) != null) {
            messageBuilder.append("Username");
            isValid = false;
        }
        if (UserDAO.instance().findByEmail(dto.getEmail()) != null) {
            if (messageBuilder.length() > 0) messageBuilder.append(" e ");
            messageBuilder.append("Email");
            isValid = false;
        }

        messageBuilder.append(" already exist!");
        this.errorMessage = messageBuilder.toString();
        return isValid;
    }

}
