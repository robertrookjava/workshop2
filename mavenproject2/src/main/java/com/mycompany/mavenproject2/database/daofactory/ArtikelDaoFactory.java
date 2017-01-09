/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.database.daofactory;

import com.mycompany.mavenproject2.database.dao.ArtikelDAO;
import com.mycompany.mavenproject2.database.daoMySQL.AccounttypeDAOMySQL;
import com.mycompany.mavenproject2.database.daoMySQL.ArtikelDAOMySQL;
import com.mycompany.mavenproject2.database.daoOracle.AccounttypeDAOOracle;
import com.mycompany.mavenproject2.database.daoOracle.ArtikelDAOOracle;
import com.mycompany.mavenproject2.database.Database;

/**
 *
 * @author robertrook
 */
public class ArtikelDaoFactory {
    public ArtikelDAO getArtikelDao (Database  database){
       
    
        switch (database) {
            case MySQL:
                return new ArtikelDAOMySQL();
                         
            case Oracle:
                return new ArtikelDAOOracle();
                  
            default:
                return new ArtikelDAOMySQL();
       
            }
        
    }
    
}
