package br.com.cookfyrest.controller;

import br.com.cookfyrest.dao.AuthenticationDAO;
import br.com.cookfyrest.dao.IdentityDAO;
import br.com.cookfyrest.dao.UserDAO;
import br.com.cookfyrest.dto.AuthenticationDTO;
import br.com.cookfyrest.dto.ErrorDTO;
import br.com.cookfyrest.dto.LoginDTO;
import br.com.cookfyrest.entity.Authentication;
import br.com.cookfyrest.entity.User;
import br.com.cookfyrest.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Date;
import java.util.UUID;

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
