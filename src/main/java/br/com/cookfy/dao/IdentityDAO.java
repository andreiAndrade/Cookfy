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
    	//session.saveOrUpdate(user);
    	
        return new Identity();
    }
    
    public boolean isValidPassword(int user_id, String hash){
    	/**
    	if(sessao.createQuery("From Identity where user_id=:user_id and hash=:hash")
    			.setString("user_id", user_id)
    			.setString("hash", hash).uniqueResult()!=null
    			){
    		return true;
    	}
    	**/
    	return false;
    }
    
}
