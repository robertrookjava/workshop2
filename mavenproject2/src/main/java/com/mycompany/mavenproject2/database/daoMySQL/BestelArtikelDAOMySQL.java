/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.database.daoMySQL;
import com.mycompany.mavenproject2.database.dao.BestelArtikelDAO;
import com.mycompany.mavenproject2.database.Database;

/**
 *
 * @author robertrook
 */
public class BestelArtikelDAOMySQL extends BestelArtikelDAO {
    
    protected Database database = Database.MySQL;
    protected String SQLcreate = "INSERT INTO BESTELARTIKEL"
                    + "(IDBESTELLING, IDARTIKEL, AANTAL) VALUES"
                    + "(?,?,?)";
    protected String SQLdelete = "DELETE FROM BestelArtikel WHERE idBestelling = ? and idArtikel = ?";
    protected String SQLreadByIdBestellingIdArtikel = "SELECT * FROM BestelArtikel WHERE idBestelling = ? and idArtikel = ?";
    protected String SQLexistsByIdBestellingIdArtikel = "SELECT * FROM BestelArtikel WHERE idBestelling = ? and idArtikel = ?";
    protected String SQLreadAll = "SELECT * FROM BestelArtikel";
    protected String SQLreadById = "SELECT * FROM BestelArtikel WHERE idBestelling = ?";
    protected String SQLupdate = "UPDATE BestelArtikel SET aantal = ? "
                   + "WHERE idBestelling = ? and idArtikel = ?";
    
    @Override
    public Database getDatabase(){
        return this.database;
    }
    
    @Override
    public String getSQLcreate(){
        return this.SQLcreate;
    }
    @Override
    public String getSQLdelete(){
        return this.SQLdelete;
    }
    @Override
    public String getSQLreadByIdBestellingIdArtikel(){
        return this.SQLreadByIdBestellingIdArtikel;
    }
    
    @Override
    public String getSQLexistsByIdBestellingIdArtikel(){
        return this.SQLexistsByIdBestellingIdArtikel;
    }
   
   
    @Override
    public String getSQLreadAll(){
        return this.SQLreadAll;
    }
    @Override
    public String getSQLreadById(){
        return this.SQLreadById;
    }
    
    @Override
    public String getSQLupdate(){
        return this.SQLupdate;
    }
    
}
