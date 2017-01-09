/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.database.daofactory;
import com.mycompany.mavenproject2.database.dao.AccounttypeDAO;
import com.mycompany.mavenproject2.database.daoMySQL.AccounttypeDAOMySQL;
import com.mycompany.mavenproject2.database.daoOracle.AccounttypeDAOOracle;
import com.mycompany.mavenproject2.database.Database;


/**
 *
 * @author robertrook
 */
public class AccounttypeDaoFactory {
    public AccounttypeDAO getAccounttypeDao (Database database){
       
        switch (database) {
            case MySQL:
                return new AccounttypeDAOMySQL();
                         
            case Oracle:
                return new AccounttypeDAOOracle();

                    
            default:
                return new AccounttypeDAOMySQL();
       
            }
        
    }
}
