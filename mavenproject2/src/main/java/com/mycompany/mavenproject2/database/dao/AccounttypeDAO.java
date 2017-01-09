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
import com.mycompany.mavenproject2.model.Accounttype;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author robertrook
 */
public abstract class AccounttypeDAO {
    
    protected abstract Database getDatabase();
    protected abstract String getSQLCreate();
    
    
   
    
    public void create(Accounttype accounttype)   {
        
        Connection connection = null;
        PreparedStatement preparedStatement  = null;  
        ResultSet result = null;
        
        try {
            ConnectionManagerFactory connectionManagerFactory = new ConnectionManagerFactory();
            ConnectionManager connectionManager = connectionManagerFactory.getConnectionManager(getDatabase());
            connection = connectionManager.getConnection();
            // String query = "INSERT INTO Artikel (idArtikel, Naam, Prijs, Voorraad) VALUES(?, ?, ?, ?)";
            //String query = "INSERT INTO Artikel  VALUES (?, ?, ?, ?)";

            //String query = "INSERT INTO ACCOUNTYPE"
            //        + "(ID, TYPE) VALUES"
            //        + "(?,?)";
            
            String query = getSQLCreate();

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, accounttype.getId());
            preparedStatement.setString(2, accounttype.getType());

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
