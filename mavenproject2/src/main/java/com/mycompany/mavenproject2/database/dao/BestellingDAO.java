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
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.*;

/**
 *
 * @author robertrook
 */
public abstract class BestellingDAO {
    protected abstract Database getDatabase();
    protected abstract String getSQLcreate();
    protected abstract String getSQLdelete();
    protected abstract String getSQLreadById();
    protected abstract String getSQLexistsById();
    protected abstract String getSQLreadAll();
    protected abstract String getSQLreadByIdKlant();
    protected abstract String getSQLexistsByIdKlant();
    protected abstract String getSQLupdate();

    
    
    public int create(Bestelling bestelling)   { // geeft de idBestelling (auto increment) terug
        
        
        Connection connection = null;
        PreparedStatement preparedStatement  = null;  
        ResultSet result = null;
        int idBestelling = 0;
        
        
        try {
            ConnectionManagerFactory connectionManagerFactory = new ConnectionManagerFactory();
            ConnectionManager connectionManager = connectionManagerFactory.getConnectionManager(getDatabase());
            connection = connectionManager.getConnection();
            // String query = "INSERT INTO Artikel (idArtikel, Naam, Prijs, Voorraad) VALUES(?, ?, ?, ?)";
            //String query = "INSERT INTO Artikel  VALUES (?, ?, ?, ?)";

            //String query = "INSERT INTO BESTELLING"
            //        + "(IDBESTELLING, IDKLANT, DATUM_BESTELLING, IDACCOUNT) VALUES"
            //       + "(?,?,?,?)";
            String query = getSQLcreate();


            preparedStatement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, bestelling.getIdBestelling());
            preparedStatement.setInt(2, bestelling.getIdKlant());
            java.util.Date date = bestelling.getDatum_Bestelling();   
            preparedStatement.setDate(3, new java.sql.Date(date.getTime()));
            preparedStatement.setInt (4, bestelling.getIdAccount());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if(rs.next()) {
                idBestelling =rs.getInt(1); 
            
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
       
        return idBestelling;
    }
    
  
         
    
    
    
    public void delete(Bestelling bestelling)   {
        
        
        Connection connection = null;
        PreparedStatement preparedStatement  = null;  
        ResultSet result = null;
        
        try {
            // Load the JDBC MySQL Driver
            ConnectionManagerFactory connectionManagerFactory = new ConnectionManagerFactory();
            ConnectionManager connectionManager = connectionManagerFactory.getConnectionManager(getDatabase());
            connection = connectionManager.getConnection();

            //String query = "DELETE FROM Bestelling WHERE idBestelling = ?";
            String query = getSQLdelete();

            preparedStatement = connection.prepareStatement(query);


            preparedStatement.setInt(1, bestelling.getIdBestelling());
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
    
    public Bestelling readByIdBestelling (Bestelling bestelling)  {
        
        
        Connection connection = null;
        PreparedStatement preparedStatement  = null;  
        ResultSet result = null;
        Bestelling gevondenBestelling = new Bestelling();
        
        try {
            ConnectionManagerFactory connectionManagerFactory = new ConnectionManagerFactory();
            ConnectionManager connectionManager = connectionManagerFactory.getConnectionManager(getDatabase());
            connection = connectionManager.getConnection();

            //String query = "SELECT * FROM Bestelling WHERE idBestelling = ?";
            String query = getSQLreadById();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, bestelling.getIdBestelling());
            result = preparedStatement.executeQuery();

            if (result.next()){
                gevondenBestelling.setIdBestelling(result.getInt("idBestelling"));
                gevondenBestelling.setIdKlant(result.getInt("idKlant"));
                gevondenBestelling.setDatum_Bestelling(result.getDate("Datum_Bestelling"));
                gevondenBestelling.setIdAccount(result.getInt("idAccount"));

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
        
        return gevondenBestelling;
        
    }
    
    // nieuw ->
     public boolean existsByIdBestelling (Bestelling bestelling)  {
        
        
        Connection connection = null;
        PreparedStatement preparedStatement  = null;  
        ResultSet result = null;
        Bestelling gevondenBestelling = new Bestelling();
        boolean exists = false;
        
        try {
            ConnectionManagerFactory connectionManagerFactory = new ConnectionManagerFactory();
            ConnectionManager connectionManager = connectionManagerFactory.getConnectionManager(getDatabase());
            connection = connectionManager.getConnection();

            //String query = "SELECT * FROM Bestelling WHERE idBestelling = ?";
            String query = getSQLexistsById();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, bestelling.getIdBestelling());
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
    // nieuw <-
    
    public Set<Bestelling> readAll()   {
        
        
        
        Connection connection = null;
        PreparedStatement preparedStatement  = null;  
        ResultSet result = null;
        Set<Bestelling> bestellingen = new HashSet<>();
      
        try {
            ConnectionManagerFactory connectionManagerFactory = new ConnectionManagerFactory();
            ConnectionManager connectionManager = connectionManagerFactory.getConnectionManager(getDatabase());
            connection = connectionManager.getConnection();

            //String query = "SELECT * FROM Bestelling";
            String query = getSQLreadAll();
            preparedStatement = connection.prepareStatement(query);
            result = preparedStatement.executeQuery(query);

            while(result.next()){
                Bestelling bestelling = new Bestelling();
                bestelling.setIdBestelling(result.getInt("idBestelling"));
                bestelling.setIdKlant(result.getInt("idKlant"));
                bestelling.setDatum_Bestelling(result.getDate("Datum_Bestelling"));
                bestelling.setIdAccount(result.getInt("idAccount"));

                bestellingen.add(bestelling);
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
    
     public Set<Bestelling> readByIdKlant(Bestelling bestelling)  {
         
        
        Connection connection = null;
        PreparedStatement preparedStatement  = null;  
        ResultSet result = null; 
       
        Set<Bestelling> bestellingen = new HashSet<>();
       
        try {
            ConnectionManagerFactory connectionManagerFactory = new ConnectionManagerFactory();
            ConnectionManager connectionManager = connectionManagerFactory.getConnectionManager(getDatabase());
            connection = connectionManager.getConnection();

            //String query = "SELECT * FROM Bestelling WHERE idKlant = ?";
            String query = getSQLreadByIdKlant();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, bestelling.getIdKlant());
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
    
    public boolean existsByIdKlant(Bestelling bestelling)  {
         
        
        Connection connection = null;
        PreparedStatement preparedStatement  = null;  
        ResultSet result = null;
        boolean exists = false;
       
        Set<Bestelling> bestellingen = new HashSet<>();
       
        try {
            ConnectionManagerFactory connectionManagerFactory = new ConnectionManagerFactory();
            ConnectionManager connectionManager = connectionManagerFactory.getConnectionManager(getDatabase());
            connection = connectionManager.getConnection();

            // String query = "SELECT * FROM Bestelling WHERE idKlant = ?";
            String query = getSQLexistsByIdKlant();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, bestelling.getIdKlant());
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
     
     
     
     
     public void update(Bestelling bestelling)   {
         
         
        
        Connection connection = null;
        PreparedStatement preparedStatement  = null;  
        ResultSet result = null; 
        
        try {
            ConnectionManagerFactory connectionManagerFactory = new ConnectionManagerFactory();
            ConnectionManager connectionManager = connectionManagerFactory.getConnectionManager(getDatabase());
            connection = connectionManager.getConnection();



            //String query = "UPDATE Bestelling SET idKlant = ?, "
            //        + "Datum_Bestelling = ?, idAccount = ? "
            //        + "WHERE Bestelling.idBestelling = ?";
            String query = getSQLupdate();

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, bestelling.getIdKlant());

            java.util.Date date = bestelling.getDatum_Bestelling();   
            preparedStatement.setDate(2, new java.sql.Date(date.getTime()));

            preparedStatement.setInt(3, bestelling.getIdAccount());
            preparedStatement.setInt(4, bestelling.getIdBestelling());
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
