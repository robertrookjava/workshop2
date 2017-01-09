/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author robertrook
 */
public class ConnectionManagerMySQL implements ConnectionManager {
    
    protected String url = "jdbc:mysql://localhost:3306/Workshop2";
    protected String drivername = "com.mysql.jdbc.Driver";
    protected String username = "root"; 
    protected String password = "ultimatejazz";
            
            
    
    @Override
    public Connection getConnection() {
        String url1 = getUrl();
        String drivername1 = getDrivername();
        String username1 = getUsername();
        String password1 = getPassword();
        Connection connection = null;
    
        try {
            Class.forName(drivername1);
            try {
                connection = DriverManager.getConnection(url1, username1, password1);
            } catch (SQLException ex) {
                // log an exception..
                // System.out.println("Failed to create the database connection.");
		System.out.println("Exception thrown  :" + ex); 
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            // System.out.println("Driver not found.");
	    System.out.println("Exception thrown  :" + ex); 
        }
        return connection;
    }
    
    
    
    @Override
    public String getUrl(){
        return this.url;
    }
    
    @Override
    public String getDrivername(){
        return this.drivername;
    }
     
    @Override
    public String getUsername(){
        return this.username;
    }
    
    @Override
    public String getPassword(){
        return this.password;
    }
   
 
    
}
