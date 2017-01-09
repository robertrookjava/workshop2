/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.database.daofactory;
import com.mycompany.mavenproject2.database.dao.AccountDAO;
import com.mycompany.mavenproject2.database.daoMySQL.AccountDAOMySql;
import com.mycompany.mavenproject2.database.daoOracle.AccountDAOOracle;
import com.mycompany.mavenproject2.database.ConnectionManagerMySQL;
import com.mycompany.mavenproject2.database.ConnectionManagerOracle;
import com.mycompany.mavenproject2.database.Database;


/**
 *
 * @author robertrook
 */
public class AccountDaoFactory {
    public AccountDAO getAccountDao (Database database){
       
       
        switch (database) {
            case MySQL:
                return new AccountDAOMySql();
                         
            case Oracle:
                return new AccountDAOOracle();

                    
            default:
                return new AccountDAOMySql();
       
            }
        }

        
        
    
    }
