package br.com.cookfy.dao;

import br.com.cookfy.model.Identity;

/**
 * Created by Andrei Andrade on 10/09/2016.
 */
public class IdentityDAO {
    private static IdentityDAO instance;

    private IdentityDAO() {
    }

    public static synchronized IdentityDAO getInstance() {
        if (instance == null) {
            instance = new IdentityDAO();
        }
        return instance;
    }

    public Identity save(Identity user) {
        return new Identity();
    }
    
    public boolean isValidPassword(int user_id, String hash){
    	return true;
    }
    
}
