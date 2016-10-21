package br.com.cookfy.controller;

import java.util.Date;
import java.util.UUID;

import org.hibernate.Session;

import br.com.cookfy.dao.AuthenticationDAO;
import br.com.cookfy.dao.IdentityDAO;
import br.com.cookfy.dao.UserDAO;
import br.com.cookfy.dto.AuthenticationDTO;
import br.com.cookfy.dto.ErrorDTO;
import br.com.cookfy.dto.LoginDTO;
import br.com.cookfy.model.Authentication;
import br.com.cookfy.model.User;
import br.com.cookfy.util.HibernateUtil;

public class LoginController {

    private AuthenticationDTO authenticationDTO;
    private ErrorDTO error;
    private boolean loginSuccess;

    public LoginController() {
        this.error = new ErrorDTO();
        this.loginSuccess = false;
        this.authenticationDTO = null;
    }

    public AuthenticationDTO getAuthenticationDTO() {
        return this.authenticationDTO;
    }

    public ErrorDTO getError() {
        return this.error;
    }

    public boolean isLoginSuccess() {
        return this.loginSuccess;
    }

    public void login(LoginDTO login) {
    	System.out.println("Logando!");
        User user;

        user = login.getUser().contains("@") ? UserDAO.instance().findByEmail(login.getUser())
                : UserDAO.instance().findByUsername(login.getUser());

        if (user == null) {
            error.setErrorMessage("Usuário ou senha inválidos!");
            loginSuccess = false;
        } else {
            if (IdentityDAO.instance().isValidPassword(user.getId(), login.getHash())) {

                String token = UUID.randomUUID().toString().replace("-", "") + new Date().getTime();
                Authentication authentication = new Authentication(user.getId(), token);
                authentication = AuthenticationDAO.instance().setOnlineState(authentication);

                if (authentication != null) {
                    authenticationDTO = new AuthenticationDTO();
                    authenticationDTO.setToken(authentication.getToken());
                    authenticationDTO.setId(user.getId());
                } else {
                    error.setErrorMessage("Erro inesperado ao efetuar o login!");
                    loginSuccess = false;
                }
            } else {
                error.setErrorMessage("Usuário ou senha inválidos!");
                loginSuccess = false;
            }
        }
    }

    public static void main(String[] args) {
        Session s = HibernateUtil.instance().getSessionFactory().openSession();

        LoginController lc = new LoginController();
        LoginDTO l = new LoginDTO("andrei.andrade", "asdfghjkl");

        lc.login(l);

        if (!lc.isLoginSuccess()) System.out.println("fudeu");
        else System.out.println("é tois birl");
        
        System.exit(0);
        
    }

}
