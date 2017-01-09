/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.mycompany.mavenproject2.robertclasses;

import com.mycompany.mavenproject2.database.dao.ArtikelDAO;
import com.mycompany.mavenproject2.model.Artikel;
import com.mycompany.mavenproject2.database.dao.KlantDAO;
import com.mycompany.mavenproject2.model.Klant;
import com.mycompany.mavenproject2.database.dao.BestellingDAO;
import com.mycompany.mavenproject2.model.Bestelling;
import com.mycompany.mavenproject2.database.dao.BestelArtikelDAO;
import com.mycompany.mavenproject2.model.BestelArtikel;

import java.util.*;


import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Set;

/**
 *
 * @author robertrook
 */
public class Test {
    
    public static void testDatabaseConnection(){
       try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Gelukkig");
       }
       catch (Exception ex){
            System.out.println("Helaas pindakaas");
            System.out.println(ex);
       }
        

    }
    
    public static void test(){
         //testDatabaseConnection();
         
         //testArtikelCreate();
         //testArtikelDelete();
         //testReadByArtikelID();
         //testUpdateArtikel();
         //testReadByNameArtikel();
         //testReadAllArtikel();
         
         //testCreateKlant();
         //testDeleteKlant();
         //testReadByIDKlant();
         //testUpdateKlant();
         //testReadAllKlant();
         //testReadByAchternaamKlant();
         
         // Crud.maakAccount();
         
         //testCreateBestelling();
         //testDeleteBestelling();
         //testReadByIdBestelling();
         //testReadAllBestelling();
         //testReadByIdKlantBestelling();
         //testUpdateBestelling();
         
         //testCreateBestelArtikel();
         //testDeleteBestelArtikel();
         //testReadByIdBestellingIdArtikel();
         //testReadAllBestelArtikel();
         //testReadByIdBestellingBestelArtikel();
         //testUpdateBestelArtikel();
         
         
         if (CheckFormat.isEmailAdres("hallo@hfhf.nl")){
             System.out.println("ja");
         }
         else {
              System.out.println("nee");
         }
         
         
  
         
         
    }
}
     
     // test ArtikelDAO
     
     
    
    
    
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 
          

    
    
    
    // test KlantDAO
    
     
    
    
    
    
   
    
    
    
    
    
    
    
    
    
    
    
     
     
     
     
    

