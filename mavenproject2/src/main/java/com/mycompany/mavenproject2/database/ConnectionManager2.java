/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.database;

import java.sql.*;

/**
 *
 * @author robertrook
 */
public class ConnectionManager2 {
    private static final String url1 = "jdbc:mysql://localhost:3306/Workshop2";    
    private static final String driverName1 = "com.mysql.jdbc.Driver";   
    private static final String username1 = "root";   
    private static final String password1 = "ultimatejazz";
    
   
    
    private static final String url2 = "jdbc:mysql://localhost:3306/Workshop2";    
    private static final String driverName2 = "com.mysql.jdbc.Driver";   
    private static final String username2 = "root";   
    private static final String password2 = "ultimatejazz";
    
    private static Connection connection;
  

    public static Connection getConnection() {
        String url = url1;
        String driverName = driverName1;
        String username = username1;
        String password = password1;
        
    
        try {
            Class.forName(driverName);
            try {
                connection = DriverManager.getConnection(url, username, password);
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
    
    public static Connection getConnection(String database) {
        String url = url1;
        String driverName = driverName1;
        String username = username1;
        String password = password1;
        
        if (database.equalsIgnoreCase("MySql")){
            url = url1;
            driverName = driverName1;
            username = username1;
            password = password1;
        }
        else if (database.equalsIgnoreCase("Oracle")) {
            url = url2;
            driverName = driverName2;
            username = username2;
            password = password2;
        }
            

        try {
            Class.forName(driverName);
            try {
                connection = DriverManager.getConnection(url, username, password);
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
    
}
