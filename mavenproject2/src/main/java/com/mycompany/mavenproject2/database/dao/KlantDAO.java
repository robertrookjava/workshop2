/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.database.dao;

import com.mycompany.mavenproject2.database.ConnectionManager;
import com.mycompany.mavenproject2.database.ConnectionManager2;
import com.mycompany.mavenproject2.database.ConnectionManagerFactory;
import com.mycompany.mavenproject2.database.Database;
import com.mycompany.mavenproject2.model.Bestelling;
import com.mycompany.mavenproject2.model.Klant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;


/**
 *
 * @author robertrook
 */
public abstract class KlantDAO {
    protected abstract Database getDatabase();
    protected abstract String getSQLcreate();
    protected abstract String getSQLdelete();
    protected abstract String getSQLreadById();
    protected abstract String getSQLexistsById();
    protected abstract String getSQLreadByIdKlant();
    protected abstract String getSQLexistsBestellingByIdKlant();
    protected abstract String getSQLreadAll();
    protected abstract String getSQLreadByAchternaam();
    protected abstract String getSQLreadexistsByAchternaam();
    protected abstract String getSQupdate();        
    

    
    
    
    
    public void create(Klant klant)  {
        
        
        Connection connection = null;
        PreparedStatement preparedStatement  = null;  
        ResultSet result = null;
        
        
        try {
            ConnectionManagerFactory connectionManagerFactory = new ConnectionManagerFactory();
            ConnectionManager connectionManager = connectionManagerFactory.getConnectionManager(getDatabase());
            connection = connectionManager.getConnection();
            // String query = "INSERT INTO KLANT"
	    //	+ "(IDKLANT, VOORNAAM, ACHTERNAAM, TUSSENVOEGSEL, TELEFOONNUMMER, EMAILADRES) VALUES"
	    //	+ "(?,?,?,?,?,?)";
            String query = getSQLcreate();
        
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, klant.getIdKlant());
            preparedStatement.setString(2, klant.getVoornaam());
            preparedStatement.setString(3, klant.getAchternaam());
            preparedStatement.setString (4, klant.getTussenvoegsel());
            preparedStatement.setString (5, klant.getTelefoonnummer());
            preparedStatement.setString (6, klant.getEmailadres());
        
            preparedStatement.executeUpdate();
        }
        
        catch (SQLException ex){
            System.out.println(ex);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        finally {
            try { if (result != null)   result.close(); } catch (Exception ex) {ex.printStackTrace();}
            try { if (preparedStatement != null) preparedStatement.close(); } catch (Exception ex) {ex.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (Exception ex) {ex.printStackTrace();}
        }
        
        
        
       
         
    }
    
    

    
    public void delete(Klant klant)   {
        
        
        Connection connection = null;
        PreparedStatement preparedStatement  = null;  
        ResultSet result = null;
        
        try {
            // Load the JDBC MySQL Driver
            ConnectionManagerFactory connectionManagerFactory = new ConnectionManagerFactory();
            ConnectionManager connectionManager = connectionManagerFactory.getConnectionManager(getDatabase());
            connection = connectionManager.getConnection();

            //String query = "DELETE FROM Klant WHERE idKlant = ?";
            String query = getSQLdelete();

            preparedStatement = connection.prepareStatement(query);


            preparedStatement.setInt(1, klant.getIdKlant());
            preparedStatement.executeUpdate();
        }
        catch (SQLException ex){
            System.out.println(ex);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        finally {
            try { if (result != null)   result.close(); } catch (Exception ex) {ex.printStackTrace();}
            try { if (preparedStatement != null) preparedStatement.close(); } catch (Exception ex) {ex.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (Exception ex) {ex.printStackTrace();}
        }
        
    }
    
    public Klant readByIdKLant (Klant klant)  {
        
        Connection connection = null;
        PreparedStatement preparedStatement  = null;  
        ResultSet result = null;
        
        Klant gevondenKlant = new Klant();
        
        try {
            ConnectionManagerFactory connectionManagerFactory = new ConnectionManagerFactory();
            ConnectionManager connectionManager = connectionManagerFactory.getConnectionManager(getDatabase());
            connection = connectionManager.getConnection();

            //String query = "SELECT * FROM Klant WHERE Klant.idKlant = ?";
            String query = getSQLreadById();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, klant.getIdKlant());
            result = preparedStatement.executeQuery();

            if (result.next()){
                gevondenKlant.setIdKlant(result.getInt("idKlant"));
                gevondenKlant.setVoornaam(result.getString("Voornaam"));
                gevondenKlant.setAchternaam(result.getString("Achternaam"));
                gevondenKlant.setTussenvoegsel(result.getString("Tussenvoegsel"));
                gevondenKlant.setTelefoonnummer(result.getString("Telefoonnummer"));
                gevondenKlant.setEmailadres(result.getString("Emailadres"));
            }
     
        }
        catch (SQLException ex){
            System.out.println(ex);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        finally {
            try { if (result != null)   result.close(); } catch (Exception ex) {ex.printStackTrace();}
            try { if (preparedStatement != null) preparedStatement.close(); } catch (Exception ex) {ex.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (Exception ex) {ex.printStackTrace();}
        }
        
        return gevondenKlant;
        
    }
    
    public Boolean existsByIdKLant (Klant klant)  {
        
        Connection connection = null;
        PreparedStatement preparedStatement  = null;  
        ResultSet result = null;
        boolean exists = false;
        
        Klant gevondenKlant = new Klant();
        
        try {
            ConnectionManagerFactory connectionManagerFactory = new ConnectionManagerFactory();
            ConnectionManager connectionManager = connectionManagerFactory.getConnectionManager(getDatabase());
            connection = connectionManager.getConnection();

            //String query = "SELECT * FROM Klant WHERE Klant.idKlant = ?";
            String query = getSQLexistsById();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, klant.getIdKlant());
            result = preparedStatement.executeQuery();

            exists=result.next();
     
        }
        catch (SQLException ex){
            System.out.println(ex);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        finally {
            try { if (result != null)   result.close(); } catch (Exception ex) {ex.printStackTrace();}
            try { if (preparedStatement != null) preparedStatement.close(); } catch (Exception ex) {ex.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (Exception ex) {ex.printStackTrace();}
        }
        
        return exists;
        
    }
    
   
    public Set<Bestelling> readByIdKlant(Klant klant)  {
         
        
        Connection connection = null;
        PreparedStatement preparedStatement  = null;  
        ResultSet result = null; 
       
        Set<Bestelling> bestellingen = new HashSet<>();
       
        try {
            ConnectionManagerFactory connectionManagerFactory = new ConnectionManagerFactory();
            ConnectionManager connectionManager = connectionManagerFactory.getConnectionManager(getDatabase());
            connection = connectionManager.getConnection();

            // String query = "SELECT * FROM Bestelling WHERE idKlant = ?";
            String query = getSQLreadByIdKlant();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, klant.getIdKlant());
            result = preparedStatement.executeQuery();

            while(result.next()){
                Bestelling bestellingGevonden = new Bestelling();
                bestellingGevonden.setIdBestelling(result.getInt("idBestelling"));
                bestellingGevonden.setIdKlant(result.getInt("idKlant"));
                bestellingGevonden.setDatum_Bestelling(result.getDate("Datum_Bestelling"));
                bestellingGevonden.setIdAccount(result.getInt("idAccount"));

                bestellingen.add(bestellingGevonden);


            }
        
        }
        catch (SQLException ex){
            System.out.println(ex);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        finally {
            try { if (result != null)   result.close(); } catch (Exception ex) {ex.printStackTrace();}
            try { if (preparedStatement != null) preparedStatement.close(); } catch (Exception ex) {ex.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (Exception ex) {ex.printStackTrace();}
        }
      
        return bestellingen;
            
            
        
        
    }
    
    public boolean existsBestellingByIdKlant(Klant klant)  {
         
        
        Connection connection = null;
        PreparedStatement preparedStatement  = null;  
        ResultSet result = null;
        boolean exists = false;
       
        Set<Bestelling> bestellingen = new HashSet<>();
       
        try {
            ConnectionManagerFactory connectionManagerFactory = new ConnectionManagerFactory();
            ConnectionManager connectionManager = connectionManagerFactory.getConnectionManager(getDatabase());
            connection = connectionManager.getConnection();

            //String query = "SELECT * FROM Bestelling WHERE idKlant = ?";
            String query = getSQLexistsBestellingByIdKlant();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, klant.getIdKlant());
            result = preparedStatement.executeQuery();
            exists = result.next();

            
        
        }
        catch (SQLException ex){
            System.out.println(ex);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        finally {
            try { if (result != null)   result.close(); } catch (Exception ex) {ex.printStackTrace();}
            try { if (preparedStatement != null) preparedStatement.close(); } catch (Exception ex) {ex.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (Exception ex) {ex.printStackTrace();}
        }
      
        return exists;
            

    }
    
    
    
    
    
    
    
    
    public Set<Klant> readAll()   {
        
        
        Connection connection = null;
        PreparedStatement preparedStatement  = null;  
        ResultSet result = null;
        
        Set<Klant> klanten = new HashSet<>();
      
        try {
            ConnectionManagerFactory connectionManagerFactory = new ConnectionManagerFactory();
            ConnectionManager connectionManager = connectionManagerFactory.getConnectionManager(getDatabase());
            connection = connectionManager.getConnection();

            //String query = "SELECT * FROM Klant";
            String query = getSQLreadAll();
            preparedStatement = connection.prepareStatement(query);
            result = preparedStatement.executeQuery(query);

            while(result.next()){
                Klant klant = new Klant();
                klant.setIdKlant(result.getInt("idKlant"));
                klant.setVoornaam(result.getString("Voornaam"));
                klant.setAchternaam(result.getString("Achternaam"));
                klant.setTussenvoegsel(result.getString("Tussenvoegsel"));
                klant.setTelefoonnummer(result.getString("Telefoonnummer"));
                klant.setEmailadres(result.getString("Emailadres"));
                klanten.add(klant);
                }

        }
        catch (SQLException ex){
            System.out.println(ex);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        finally {
            try { if (result != null)   result.close(); } catch (Exception ex) {ex.printStackTrace();}
            try { if (preparedStatement != null) preparedStatement.close(); } catch (Exception ex) {ex.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (Exception ex) {ex.printStackTrace();}
        }
  
        return klanten;
    }
    
     public Set<Klant> readByAchternaamKlant(Klant klant)  {
         
         
         
        Connection connection = null;
        PreparedStatement preparedStatement  = null;  
        ResultSet result = null;
       
        Set<Klant> klanten = new HashSet<>();
       
        try {
            ConnectionManagerFactory connectionManagerFactory = new ConnectionManagerFactory();
            ConnectionManager connectionManager = connectionManagerFactory.getConnectionManager(getDatabase());
            connection = connectionManager.getConnection();

            // String query = "SELECT * FROM Klant WHERE Klant.Achternaam = ?";
            String query = getSQLreadByAchternaam();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, klant.getAchternaam());
            result = preparedStatement.executeQuery();

            while(result.next()){
                Klant klantGevonden = new Klant();
                klantGevonden.setIdKlant(result.getInt("idKlant"));
                klantGevonden.setVoornaam(result.getString("Voornaam"));
                klantGevonden.setAchternaam(result.getString("Achternaam"));
                klantGevonden.setTussenvoegsel(result.getString("Tussenvoegsel"));
                klantGevonden.setTelefoonnummer(result.getString("Telefoonnummer"));
                klantGevonden.setEmailadres(result.getString("Emailadres"));

                klanten.add(klantGevonden);
              }
        
        }
        catch (SQLException ex){
            System.out.println(ex);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        finally {
            try { if (result != null)   result.close(); } catch (Exception ex) {ex.printStackTrace();}
            try { if (preparedStatement != null) preparedStatement.close(); } catch (Exception ex) {ex.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (Exception ex) {ex.printStackTrace();}
        }
      
        return klanten;
            
            
        
        
    }
     
    public boolean existsByAchternaamKlant(Klant klant)  {
         
         
         
        Connection connection = null;
        PreparedStatement preparedStatement  = null;  
        ResultSet result = null;
        boolean exists = false;
       
        Set<Klant> klanten = new HashSet<>();
       
        try {
            ConnectionManagerFactory connectionManagerFactory = new ConnectionManagerFactory();
            ConnectionManager connectionManager = connectionManagerFactory.getConnectionManager(getDatabase());
            connection = connectionManager.getConnection();

            // String query = "SELECT * FROM Klant WHERE Klant.Achternaam = ?";
            String query = getSQLreadexistsByAchternaam();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, klant.getAchternaam());
            result = preparedStatement.executeQuery();

            exists=result.next();
        
        }
        catch (SQLException ex){
            System.out.println(ex);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        finally {
            try { if (result != null)   result.close(); } catch (Exception ex) {ex.printStackTrace();}
            try { if (preparedStatement != null) preparedStatement.close(); } catch (Exception ex) {ex.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (Exception ex) {ex.printStackTrace();}
        }
      
        return exists;
            
            
        
        
    } 
     
     
     public void update(Klant klant)   {
         
        
        Connection connection = null;
        PreparedStatement preparedStatement  = null;  
        ResultSet result = null; 
        
        try {
            ConnectionManagerFactory connectionManagerFactory = new ConnectionManagerFactory();
            ConnectionManager connectionManager = connectionManagerFactory.getConnectionManager(getDatabase());
            connection = connectionManager.getConnection();



            //String query = "UPDATE Klant SET Klant.Voornaam = ?, "
            //        + "klant.Achternaam = ?, klant.Tussenvoegsel = ?, klant.Telefoonnummer = ?, "
            //        + "klant.Emailadres = ?"
            //        + "WHERE Klant.idKlant = ?";
            String query = getSQupdate();

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, klant.getVoornaam());
            preparedStatement.setString(2, klant.getAchternaam());
            preparedStatement.setString(3, klant.getTussenvoegsel());
            preparedStatement.setString(4, klant.getTelefoonnummer());
            preparedStatement.setString(5, klant.getEmailadres());
            preparedStatement.setInt(6, klant.getIdKlant());
            preparedStatement.executeUpdate();
    
        }
        catch (SQLException ex){
            System.out.println(ex);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        finally {
            try { if (result != null)   result.close(); } catch (Exception ex) {ex.printStackTrace();}
            try { if (preparedStatement != null) preparedStatement.close(); } catch (Exception ex) {ex.printStackTrace();};
            try { if (connection != null) connection.close(); } catch (Exception ex) {ex.printStackTrace();}
        }
      
    }
     
     
    
    
    
}
