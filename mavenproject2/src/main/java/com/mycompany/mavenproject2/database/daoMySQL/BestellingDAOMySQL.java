/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.database.daoMySQL;
import com.mycompany.mavenproject2.database.dao.BestellingDAO;
import com.mycompany.mavenproject2.database.Database;

/**
 *
 * @author robertrook
 */
public class BestellingDAOMySQL extends BestellingDAO {
    
    protected Database database = Database.MySQL;
    protected String getSQLcreate = "INSERT INTO BESTELLING"
                    + "(IDBESTELLING, IDKLANT, DATUM_BESTELLING, IDACCOUNT) VALUES"
                    + "(?,?,?,?)";
    protected String getSQLdelete = "DELETE FROM Bestelling WHERE idBestelling = ?";
    protected String getSQLreadById = "SELECT * FROM Bestelling WHERE idBestelling = ?";
    protected String getSQLexistsById = "SELECT * FROM Bestelling WHERE idBestelling = ?";
    protected String getSQLreadAll = "SELECT * FROM Bestelling";
    protected String getSQLreadByIdKlant = "SELECT * FROM Bestelling WHERE idKlant = ?";
    protected String getSQLexistsByIdKlant = "SELECT * FROM Bestelling WHERE idKlant = ?";
    protected String getSQLupdate = "UPDATE Bestelling SET idKlant = ?, "
                        + "Datum_Bestelling = ?, idAccount = ? "
                        + "WHERE Bestelling.idBestelling = ?";
   
    @Override
    public Database getDatabase(){
        return this.database;
    }
    
    @Override
    public String getSQLcreate(){
        return this.getSQLcreate;
    }
    
    @Override
    public String getSQLdelete(){
        return this.getSQLdelete;
    }
    
    @Override
    public String getSQLreadById(){
        return this.getSQLreadById;
    }
    
    @Override
    public String getSQLexistsById(){
        return this.getSQLexistsById;
    }
    
    @Override
    public String getSQLreadAll(){
        return this.getSQLreadAll;
    }
    
    @Override
    public String getSQLreadByIdKlant(){
        return this.getSQLreadByIdKlant;
    }
    
    @Override
    public String getSQLexistsByIdKlant(){
        return this.getSQLexistsByIdKlant;
    }
    
    @Override
    public String getSQLupdate(){
        return this.getSQLupdate;
    }
    
}
