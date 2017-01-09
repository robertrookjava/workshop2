/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.database.daoMySQL;
import com.mycompany.mavenproject2.database.dao.AccountDAO;
import com.mycompany.mavenproject2.database.Database;

/**
 *
 * @author robertrook
 */
public class AccountDAOMySql extends AccountDAO {
    
    protected Database database = Database.MySQL;
    protected String SQLCreate = "INSERT INTO Account (idAccount, Gebruikersnaam, Wachtwoord, Datum_Aanmaak,accountype_id) VALUES(?, ?, ?, ?, ?)";
    protected String SQLDelete = "DELETE FROM Account WHERE idAccount = ?";
    protected String SQLReadByID = "SELECT * FROM Account WHERE Account.idAccount = ?";
    protected String SQLBestaat =  "SELECT * FROM Account WHERE Account.idAccount = ?";
    protected String SQLreadByGebruikersnaam = "SELECT * FROM Account WHERE account.Gebruikersnaam = ?";
    
    @Override
    public Database getDatabase(){
        return this.database;
    }
 
    @Override
    public String getSQLCreate(){
        return this.SQLCreate;
    }
    @Override
    public String getSQLDelete(){
        return this.SQLDelete;
    }
    
    @Override
    public String getSQLReadByID(){
        return this.SQLReadByID;
    }
    
    @Override
    public String getSQLBestaat(){
        return this.SQLBestaat;
    }
    
    @Override
    public String getSQLreadByGebruikersnaam(){
        return this.SQLreadByGebruikersnaam;
    }
    
}
