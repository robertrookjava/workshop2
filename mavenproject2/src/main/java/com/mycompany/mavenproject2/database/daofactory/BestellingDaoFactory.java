/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.database.daofactory;
import com.mycompany.mavenproject2.database.dao.BestellingDAO;
import com.mycompany.mavenproject2.database.daoMySQL.BestelArtikelDAOMySQL;
import com.mycompany.mavenproject2.database.daoMySQL.BestellingDAOMySQL;
import com.mycompany.mavenproject2.database.daoOracle.BestelArtikelDAOOracle;
import com.mycompany.mavenproject2.database.daoOracle.BestellingDAOOracle;
import com.mycompany.mavenproject2.database.Database;

/**
 *
 * @author robertrook
 */
public class BestellingDaoFactory {
    public BestellingDAO getBestellingDao (Database database){
       
    
    switch (database) {
        case MySQL:
                return new BestellingDAOMySQL();
                         
        case Oracle:
            return new BestellingDAOOracle();
                  
        default:
            return new BestellingDAOMySQL();
       
        }
    }
}
