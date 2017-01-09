/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.database.dao;

import com.mycompany.mavenproject2.database.ConnectionManager;
import com.mycompany.mavenproject2.database.ConnectionManagerFactory;
import com.mycompany.mavenproject2.database.Database;
import com.mycompany.mavenproject2.model.Account;
import java.sql.*;
import java.util.*;


/**
 *
 * @author robertrook
 */
public abstract class AccountDAO {
    
    
    protected abstract Database getDatabase();
    protected abstract String getSQLCreate();
    protected abstract String getSQLDelete();
    protected abstract String getSQLReadByID();
    protected abstract String getSQLBestaat();
    protected abstract String getSQLreadByGebruikersnaam();
    
   
    
    public void create(Account account)   {
        
        Connection connection = null;
        PreparedStatement preparedStatement  = null;  
        ResultSet result = null;
        
        try {
            ConnectionManagerFactory connectionManagerFactory = new ConnectionManagerFactory();
            ConnectionManager connectionManager = connectionManagerFactory.getConnectionManager(getDatabase());
            connection = connectionManager.getConnection();
            
  
            // String query = "INSERT INTO Account (idAccount, Gebruikersnaam, Wachtwoord, Datum_Aanmaak,accountype_id) VALUES(?, ?, ?, ?, ?)";
            String query = getSQLCreate();
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, account.getIdAccount());
            preparedStatement.setString(2, account.getGebruikersnaam());
            preparedStatement.setString(3, account.getWachtwoord());

            java.util.Date date = account.getDatum_Aanmaak();

            preparedStatement.setDate(4, new java.sql.Date(date.getTime()));

            preparedStatement.setInt(5, account.getAccountype_id());
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
    
    
    public void delete(Account account)   {
        
        Connection connection = null;
        PreparedStatement preparedStatement  = null;  
        ResultSet result = null;
        
        
        
        try {
        // Load the JDBC MySQL Driver
            ConnectionManagerFactory connectionManagerFactory = new ConnectionManagerFactory();
            ConnectionManager connectionManager = connectionManagerFactory.getConnectionManager(getDatabase());
            connection = connectionManager.getConnection();
            



            // String query = "DELETE FROM Account WHERE idAccount = ?";
            String query = getSQLDelete();

            preparedStatement = connection.prepareStatement(query);


            preparedStatement.setInt(1, account.getIdAccount());
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
    
    public Account readByIdAccount (Account account)  {
        
        Connection connection = null;
        PreparedStatement preparedStatement  = null;  
        ResultSet result = null;
        
        Account gevondenAccount = new Account();
        
        try {
        
            

            ConnectionManagerFactory connectionManagerFactory = new ConnectionManagerFactory();
            ConnectionManager connectionManager = connectionManagerFactory.getConnectionManager(getDatabase());
            connection = connectionManager.getConnection();
            

            //  String query = "SELECT * FROM Account WHERE Account.idAccount = ?";
            String query = getSQLReadByID();


            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, account.getIdAccount());

            

            if (result.next()){
                gevondenAccount.setIdAccount(result.getInt("idAccount"));
                gevondenAccount.setGebruikersnaam(result.getString("Gebruikersnaam"));
                gevondenAccount.setWachtwoord(result.getString("Wachtwoord"));
                gevondenAccount.setDatum_Aanmaak(result.getDate("Datum_Aanmaak"));
                gevondenAccount.setAccountype_id(result.getInt("accountype_id"));
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
        
        
        
        return gevondenAccount;
        
    }
    
     public boolean bestaatAccount (Account account)  {
        
        Connection connection = null;
        PreparedStatement preparedStatement  = null;  
        ResultSet result = null;
        boolean output = false;
        
        try {
       

            ConnectionManagerFactory connectionManagerFactory = new ConnectionManagerFactory();
            ConnectionManager connectionManager = connectionManagerFactory.getConnectionManager(getDatabase());
            connection = connectionManager.getConnection();
            
            // String query = "SELECT * FROM Account WHERE Account.idAccount = ?";
            String query = getSQLBestaat();

            

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, account.getIdAccount());
            result = preparedStatement.executeQuery();

            if (result.next()){
                output = true;
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
        
        
        return output;
        
    }
    
    
     public Account readByGebruikersnaam (Account account) {
         
        Connection connection = null;
        PreparedStatement preparedStatement  = null;  
        ResultSet result = null;
        Account accountGevonden = new Account(); 
        
        
        try {
        
            ConnectionManagerFactory connectionManagerFactory = new ConnectionManagerFactory();
            ConnectionManager connectionManager = connectionManagerFactory.getConnectionManager(getDatabase());
            connection = connectionManager.getConnection();
            

            //String query = "SELECT * FROM Account WHERE account.Gebruikersnaam = ?";
            String query = getSQLreadByGebruikersnaam();
            preparedStatement = connection.prepareStatement(query);


            preparedStatement.setString(1, account.getGebruikersnaam());

            result = preparedStatement.executeQuery();

               

            if (result.next()){

                accountGevonden.setIdAccount(result.getInt("idAccount"));
                accountGevonden.setGebruikersnaam(result.getString("Gebruikersnaam"));
                accountGevonden.setWachtwoord(result.getString("Wachtwoord"));
                accountGevonden.setDatum_Aanmaak(result.getDate("Gebruikersnaam"));
                accountGevonden.setAccountype_id(result.getInt("accountype_id"));

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
      
        
        return accountGevonden;
            
            
        
        
    }
     
     /*
     public void update(Account account) throws SQLException  {
        
        connection = ConnectionManager.getConnection();
        

        String query = "UPDATE Artikel SET Artikel.naam = ?, "
                + " Artikel.prijs = ?, Artikel.voorraad = ? "
                + "WHERE Artikel.idArtikel = ?";
                       
       
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, artikel.getNaam());
        preparedStatement.setBigDecimal(2, artikel.getPrijs());
        preparedStatement.setInt(3, artikel.getVoorraad());
        preparedStatement.setInt(4, artikel.getIdArtikel());
        preparedStatement.executeUpdate();

        
        connection.close();


      
    }

*/ 
    
}
