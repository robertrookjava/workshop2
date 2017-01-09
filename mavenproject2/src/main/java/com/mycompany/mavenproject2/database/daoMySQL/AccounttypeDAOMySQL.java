/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.database.daoMySQL;
import com.mycompany.mavenproject2.database.dao.AccounttypeDAO;
import com.mycompany.mavenproject2.database.Database;

/**
 *
 * @author robertrook
 */
public class AccounttypeDAOMySQL extends AccounttypeDAO {
    
   protected Database database = Database.MySQL;
   protected String SQLCreate = "INSERT INTO ACCOUNTYPE"
                    + "(ID, TYPE) VALUES"
                    + "(?,?)";
    
    @Override
    public Database getDatabase(){
        return this.database;
    }
    
  
   @Override
    public String getSQLCreate(){
        return this.SQLCreate;
    }
    
    
}
