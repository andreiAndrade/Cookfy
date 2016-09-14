package br.com.cookfy.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Created by Andrei Andrade on 10/09/2016.
 */
public abstract class AbstractDAO {

    private DataSource dataSource;
    private Connection connection;
    private final static String JNDI_NAME = "yourJndiName";

    protected AbstractDAO() {
        InitialContext initial;
        try {
            initial = new InitialContext();
            DataSource dataSource = (DataSource) initial.lookup(JNDI_NAME);
            this.dataSource = dataSource;
        }
        catch (NamingException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    protected void releaseConnection() throws SQLException {
        if(connection != null) {
            connection.close();
        }
        connection = null;
    }

    protected Statement getStatement() throws SQLException {
//        if(connection != null) {
//            RuntimeException rt = new
//                    RuntimeException(this.getClass().getName() + ": Creating new statement
//            while previous query was not " + "properly closed. \nClosing previous
//            connection...");
//            releaseConnection();
//            throw rt;
//        }
//        connection = getConnection();
//        return connection.createStatement();
        return null;
    }

}