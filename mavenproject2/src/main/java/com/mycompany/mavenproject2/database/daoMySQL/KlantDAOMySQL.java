/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.database.daoMySQL;
import com.mycompany.mavenproject2.database.dao.KlantDAO;
import com.mycompany.mavenproject2.database.Database;

/**
 *
 * @author robertrook
 */
public class KlantDAOMySQL extends KlantDAO {
    
    protected Database database = Database.MySQL;
    protected String SQLcreate ="INSERT INTO KLANT"
	    	+ "(IDKLANT, VOORNAAM, ACHTERNAAM, TUSSENVOEGSEL, TELEFOONNUMMER, EMAILADRES) VALUES"
	    	+ "(?,?,?,?,?,?)";
    protected String SQLdelete = "DELETE FROM Klant WHERE idKlant = ?";
    protected String SQLreadById =  "SELECT * FROM Klant WHERE Klant.idKlant = ?";
    protected String SQLexistsById = "SELECT * FROM Klant WHERE Klant.idKlant = ?";
    protected String SQLreadByIdKlant = "SELECT * FROM Bestelling WHERE idKlant = ?";
    protected String SQLexistsBestellingByIdKlant = "SELECT * FROM Bestelling WHERE idKlant = ?";
    protected String SQLreadAll = "SELECT * FROM Klant";
    protected String SQLreadByAchternaam = "SELECT * FROM Klant WHERE Klant.Achternaam = ?";
    protected String SQLreadexistsByAchternaam = "SELECT * FROM Klant WHERE Klant.Achternaam = ?";
    protected String SQLupdate = "UPDATE Klant SET Klant.Voornaam = ?, "
                        + "klant.Achternaam = ?, klant.Tussenvoegsel = ?, klant.Telefoonnummer = ?, "
                        + "klant.Emailadres = ?"
                        + "WHERE Klant.idKlant = ?";   
    
    @Override
    public Database getDatabase(){
        return this.database;
    }
    
 
    @Override
    public String getSQLcreate(){
        return this.SQLcreate;
    }
    
    @Override
    public  String getSQLdelete(){
        return this.SQLdelete;
    }
    
    @Override
    public  String getSQLreadById(){
        return this.SQLreadById;
    }
    
    @Override
    public  String getSQLexistsById(){
        return this.SQLexistsById;
    }
    
    @Override
    public  String getSQLreadByIdKlant(){
        return this.SQLreadByIdKlant;
    }
    
    @Override
    public  String getSQLexistsBestellingByIdKlant(){
        return this.SQLexistsBestellingByIdKlant;
    }
    
    @Override
    public  String getSQLreadAll(){
        return this.SQLreadAll;
    }
    
    @Override
    public  String getSQLreadByAchternaam(){
        return this.SQLreadByAchternaam;
    }
    
    @Override
    public String getSQLreadexistsByAchternaam(){
        return this.SQLreadexistsByAchternaam;
    }
    
    @Override
    public String getSQupdate(){
        return this.SQLupdate;
    }      
    
    
}
