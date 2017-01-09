/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.database;

/**
 *
 * @author robertrook
 */
public class ConnectionManagerFactory {
    public ConnectionManager getConnectionManager (Database database){
        switch (database) {
            case MySQL:
                return new ConnectionManagerMySQL();
                         
            case Oracle:
                return new ConnectionManagerOracle();

                    
            default:
                return new ConnectionManagerMySQL();
                
        }
        
    }
    
}
