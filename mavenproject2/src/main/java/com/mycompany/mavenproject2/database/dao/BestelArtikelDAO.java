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
import com.mycompany.mavenproject2.model.BestelArtikel;
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
public abstract class BestelArtikelDAO {
    
    protected abstract Database getDatabase();
    protected abstract String getSQLcreate();
    protected abstract String getSQLdelete();
    protected abstract String getSQLreadByIdBestellingIdArtikel();
    protected abstract String getSQLexistsByIdBestellingIdArtikel();
    protected abstract String getSQLreadAll();
    protected abstract String getSQLreadById();
    protected abstract String getSQLupdate();
    

    
    
    
    
    public void create(BestelArtikel bestelArtikel)   {
        
        
        Connection connection = null;
        PreparedStatement preparedStatement  = null;  
        ResultSet result = null;
        
        try {
            ConnectionManagerFactory connectionManagerFactory = new ConnectionManagerFactory();
            ConnectionManager connectionManager = connectionManagerFactory.getConnectionManager(getDatabase());
            connection = connectionManager.getConnection();
            // String query = "INSERT INTO Artikel (idArtikel, Naam, Prijs, Voorraad) VALUES(?, ?, ?, ?)";
            //String query = "INSERT INTO Artikel  VALUES (?, ?, ?, ?)";

            //String query = "INSERT INTO BESTELARTIKEL"
            //        + "(IDBESTELLING, IDARTIKEL, AANTAL) VALUES"
            //        + "(?,?,?)";
            String query = getSQLcreate();


            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, bestelArtikel.getIdBestelling());
            preparedStatement.setInt(2, bestelArtikel.getIdArtikel());
            preparedStatement.setInt(3, bestelArtikel.getAantal());

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
    
    public void delete(BestelArtikel bestelArtikel)   {
        
        
        Connection connection = null;
        PreparedStatement preparedStatement  = null;  
        ResultSet result = null;
        // Load the JDBC MySQL Driver
        
        try {
            ConnectionManagerFactory connectionManagerFactory = new ConnectionManagerFactory();
            ConnectionManager connectionManager = connectionManagerFactory.getConnectionManager(getDatabase());
            connection = connectionManager.getConnection();

            //String query = "DELETE FROM BestelArtikel WHERE idBestelling = ? and idArtikel = ?";
            String query = getSQLdelete();

            preparedStatement = connection.prepareStatement(query);


            preparedStatement.setInt(1, bestelArtikel.getIdBestelling());
            preparedStatement.setInt(2, bestelArtikel.getIdArtikel());
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
    
    public BestelArtikel readByIdBestellingIdArtikel (BestelArtikel bestelArtikel) {
        
        
        
        Connection connection = null;
        PreparedStatement preparedStatement  = null;  
        ResultSet result = null;
        BestelArtikel gevondenBestelArtikel = new BestelArtikel();
        try {
            ConnectionManagerFactory connectionManagerFactory = new ConnectionManagerFactory();
            ConnectionManager connectionManager = connectionManagerFactory.getConnectionManager(getDatabase());
            connection = connectionManager.getConnection();

            //String query = "SELECT * FROM BestelArtikel WHERE idBestelling = ? and idArtikel = ?";
            String query = getSQLreadByIdBestellingIdArtikel();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, bestelArtikel.getIdBestelling());
            preparedStatement.setInt(2, bestelArtikel.getIdArtikel());
            result = preparedStatement.executeQuery();

            if (result.next()){
                gevondenBestelArtikel.setIdBestelling(result.getInt("idBestelling"));
                gevondenBestelArtikel.setIdArtikel(result.getInt("idArtikel"));
                gevondenBestelArtikel.setAantal(result.getInt("aantal"));

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
        
        return gevondenBestelArtikel;
        
    }
    
    public boolean existsByIdBestellingIdArtikel (BestelArtikel bestelArtikel) {
        
        boolean exists = false;
        
        Connection connection = null;
        PreparedStatement preparedStatement  = null;  
        ResultSet result = null;
        BestelArtikel gevondenBestelArtikel = new BestelArtikel();
        try {
            ConnectionManagerFactory connectionManagerFactory = new ConnectionManagerFactory();
            ConnectionManager connectionManager = connectionManagerFactory.getConnectionManager(getDatabase());
            connection = connectionManager.getConnection();

            //String query = "SELECT * FROM BestelArtikel WHERE idBestelling = ? and idArtikel = ?";
            String query = getSQLexistsByIdBestellingIdArtikel();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, bestelArtikel.getIdBestelling());
            preparedStatement.setInt(2, bestelArtikel.getIdArtikel());
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
    
    public Set<BestelArtikel> readAll()   {
        
        
        
        Connection connection = null;
        PreparedStatement preparedStatement  = null;  
        ResultSet result = null;
        
        Set<BestelArtikel> bestelArtikelen = new HashSet<>();
      
        try {
            ConnectionManagerFactory connectionManagerFactory = new ConnectionManagerFactory();
            ConnectionManager connectionManager = connectionManagerFactory.getConnectionManager(getDatabase());
            connection = connectionManager.getConnection();

            //String query = "SELECT * FROM BestelArtikel";
            String query = getSQLreadAll();
            preparedStatement = connection.prepareStatement(query);
            result = preparedStatement.executeQuery(query);

            while(result.next()){
                BestelArtikel bestelArtikel = new BestelArtikel();
                bestelArtikel.setIdBestelling(result.getInt("idBestelling"));
                bestelArtikel.setIdArtikel(result.getInt("idArtikel"));
                bestelArtikel.setAantal(result.getInt("Aantal"));

                bestelArtikelen.add(bestelArtikel);
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
  
        return bestelArtikelen;
    }
    
     public Set<BestelArtikel> readByIdBestelling (BestelArtikel bestelArtikel)  {
         
       
        Connection connection = null;
        PreparedStatement preparedStatement  = null;  
        ResultSet result = null;
        
        Set<BestelArtikel> bestelArtikelen = new HashSet<>();
       
        try {
            ConnectionManagerFactory connectionManagerFactory = new ConnectionManagerFactory();
            ConnectionManager connectionManager = connectionManagerFactory.getConnectionManager(getDatabase());
            connection = connectionManager.getConnection();

            //String query = "SELECT * FROM BestelArtikel WHERE idBestelling = ?";
            String query = getSQLreadById();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, bestelArtikel.getIdBestelling());
            result = preparedStatement.executeQuery();

            while(result.next()){
                BestelArtikel bestelArtikelGevonden = new BestelArtikel();
                bestelArtikelGevonden.setIdBestelling(result.getInt("idBestelling"));
                bestelArtikelGevonden.setIdArtikel(result.getInt("idArtikel"));
                bestelArtikelGevonden.setAantal(result.getInt("Aantal"));

                bestelArtikelen.add(bestelArtikelGevonden);

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
      
        return bestelArtikelen;
            
            
        
        
    }
     
     
     public void update(BestelArtikel bestelArtikel)   {
         
         
        Connection connection = null;
        PreparedStatement preparedStatement  = null;  
        ResultSet result = null;
        
        
        try {
            ConnectionManagerFactory connectionManagerFactory = new ConnectionManagerFactory();
            ConnectionManager connectionManager = connectionManagerFactory.getConnectionManager(getDatabase());
            connection = connectionManager.getConnection();



            //String query = "UPDATE BestelArtikel SET aantal = ? "
            //       + "WHERE idBestelling = ? and idArtikel = ?";
            
            String query = getSQLupdate();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, bestelArtikel.getAantal());
            preparedStatement.setInt(2, bestelArtikel.getIdBestelling());
            preparedStatement.setInt(3, bestelArtikel.getIdArtikel());
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
