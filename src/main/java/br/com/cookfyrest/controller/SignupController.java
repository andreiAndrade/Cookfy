package br.com.cookfyrest.controller;

import br.com.cookfyrest.dto.AuthenticationDTO;
import br.com.cookfyrest.dto.ErrorDTO;
import br.com.cookfyrest.dto.SignupDTO;
import br.com.cookfyrest.entity.User;
import br.com.cookfyrest.util.HibernateUtil;
import org.hibernate.Session;

public class SignupController {
//
//	private ErrorDTO error;
//	private boolean signupSuccess;
//	private AuthenticationDTO authenticationDTO;
//
//	public SignupController() {
//		this.signupSuccess = false;
//		this.error = new ErrorDTO();
//		this.authenticationDTO = null;
//	}
//
//	public ErrorDTO getError() {
//		return this.error;
//	}
//
//	public boolean isSignupSuccess() {
//		return this.signupSuccess;
//	}
//
//	public AuthenticationDTO getAuthenticationDTO() {
//		return this.authenticationDTO;
//	}
//
//	public void signup(SignupDTO dto) {
//
//		this.signupSuccess = true;
//
//		if (!validade(dto)) {
//			this.signupSuccess = false;
//		}
//
//		User user = new User(dto.getName(), dto.getUsername(), dto.getEmail());
////		user = UserDAO.instance().save(user);
//
//		if (user == null) {
//			this.error.setErrorMessage("Erro inesperado ao cadastrar o usuário. Tente novamente!");
//			this.signupSuccess = false;
//		}
//
////		Identity identity = new Identity(user.getId(), dto.getAdapter(), dto.getHash());
////		identity = IdentityDAO.instance().save(identity);
//
////		if (identity == null) {
////			this.error.setErrorMessage("Erro inesperado ao cadastrar o usuário. Tente novamente!");
////			this.signupSuccess = false;
////		}
////
////		LoginDTO login = new LoginDTO(user.getName(), identity.getHash());
////		login(login);
//	}
//
//	private boolean validade(SignupDTO dto) {
//		/*
//		 * Checks if exist already username Checks if exist already email
//		 */
//		StringBuilder messageBuilder;
//		messageBuilder = new StringBuilder();
//		boolean isValid = true;
//
////		if (UserDAO.instance().findByUsername(dto.getUsername()) != null) {
////			messageBuilder.append("Username");
////			isValid = false;
////		}
////		if (UserDAO.instance().findByEmail(dto.getEmail()) != null) {
////			if (messageBuilder.length() > 0)
////				messageBuilder.append(" and ");
////			messageBuilder.append("Email");
////			isValid = false;
////		}
//		if (!isValid)
//			messageBuilder.append(" already exist;");
//
//		this.error.setErrorMessage(messageBuilder.toString());
//		return isValid;
//	}
//
//	private void login(LoginDTO login) {
//		LoginController loginController = new LoginController();
//		loginController.login(login);
//
//		if (loginController.isLoginSuccess()) {
//			this.authenticationDTO = loginController.getAuthenticationDTO();
//		} else {
//			this.error.setErrorMessage(loginController.getError().getErrorMessage());
//			this.signupSuccess= false;
//		}
//	}
//
//	public static void main(String[] args) {
//        Session s = HibernateUtil.instance().getSessionFactory().openSession();
//
//        SignupController sc = new SignupController();
//        SignupDTO si = new SignupDTO();
//        si.setName("andrei");
//        si.setEmail("andrei@andrei");
//        si.setUsername("andrei.andrade");
//        si.setHash("asdfghjkl");
//        si.setAdapter("application");
//
//        sc.signup(si);
//
//        if (!sc.isSignupSuccess()) System.out.println("fudeu");
//        else System.out.println("é tois birl");
//
//        System.exit(0);
//    }
//
}
