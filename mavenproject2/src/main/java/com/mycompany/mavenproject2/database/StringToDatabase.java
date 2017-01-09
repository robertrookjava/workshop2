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
public class StringToDatabase {
    public Database toDatabase (String database){
        if (database.equalsIgnoreCase("MySQL")){
            return Database.MySQL;
        }
        else if (database.equalsIgnoreCase("Oracle")){
            return Database.Oracle;
        }
        return Database.MySQL;
    }
    
}
