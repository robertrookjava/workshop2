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
public interface ConnectionManager {
    
    Connection getConnection();
    String getUrl();
    String getDrivername();
    String getUsername();
    String getPassword();

}
    

