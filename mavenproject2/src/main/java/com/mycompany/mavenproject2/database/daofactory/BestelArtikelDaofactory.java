/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.database.daofactory;
import com.mycompany.mavenproject2.database.dao.BestelArtikelDAO;
import com.mycompany.mavenproject2.database.daoMySQL.ArtikelDAOMySQL;
import com.mycompany.mavenproject2.database.daoMySQL.BestelArtikelDAOMySQL;
import com.mycompany.mavenproject2.database.daoOracle.ArtikelDAOOracle;
import com.mycompany.mavenproject2.database.daoOracle.BestelArtikelDAOOracle;
import com.mycompany.mavenproject2.database.Database;

/**
 *
 * @author robertrook
 */
public class BestelArtikelDaofactory {
    public BestelArtikelDAO getBestelArtikelDao (Database database){

        switch (database) {
            case MySQL:
                return new BestelArtikelDAOMySQL();
                         
            case Oracle:
                return new BestelArtikelDAOOracle();
                  
            default:
                return new BestelArtikelDAOOracle();
       
        }
    }
    
}
