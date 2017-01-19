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

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
         
         testArtikelCreate();
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
         
         
         //if (CheckFormat.isEmailAdres("hallo@hfhf.nl")){
         //    System.out.println("ja");
         //}
         //else {
         //     System.out.println("nee");
         //}
         
         
  
         
         
    }
    
    
     // test ArtikelDAO
     
     
    public static void testCreateBestelling(){
        //BestellingDAO bestellingDao = new BestellingDAO();
        Bestelling bestelling = new Bestelling();
        bestelling.setIdBestelling(0);
        bestelling.setIdKlant(6);
        bestelling.setDatum_Bestelling(new Date());
        bestelling.setIdAccount(1);
        
     
        //bestellingDao.create(bestelling);
 
    }
    
    public static void testDeleteBestelling(){
       // BestellingDAO bestellingDao = new BestellingDAO();
        Bestelling bestelling = new Bestelling();
        bestelling.setIdBestelling(9);
        
        //bestellingDao.delete(bestelling);
    
    }
    
    public static void testReadByIdBestelling(){
        
        //BestellingDAO bestellingDao = new BestellingDAO();
        Bestelling bestelling = new Bestelling();
        bestelling.setIdBestelling(4);
        
        
        //Bestelling gevondenBestelling = bestellingDao.readByIdBestelling(bestelling);
        //System.out.println(gevondenBestelling.getIdKlant());
        //System.out.println(gevondenBestelling.getDatum_Bestelling());
        //System.out.println(gevondenBestelling.getIdAccount());
       
        
     
    }
    
    public static void testReadAllBestelling(){
        //BestellingDAO bestellingDao = new BestellingDAO();
     
        
        //Set<Bestelling> bestellingen = bestellingDao.readAll();
       
        //for (Bestelling x:bestellingen){         
            //System.out.println(x.getIdBestelling());
            //System.out.println(x.getIdKlant());
            //System.out.println(x.getDatum_Bestelling());
            //System.out.println(x.getIdAccount());
            //System.out.println();

        //}
        
        
    }
    
    public static void testReadByIdKlantBestelling(){
        
        //BestellingDAO bestellingDao = new BestellingDAO();
        Bestelling bestelling = new Bestelling();
        bestelling.setIdKlant(5);
      
        
        //Set<Bestelling> bestellingen = bestellingDao.readByIdKlant(bestelling);
        //for (Bestelling x:bestellingen){
            //System.out.println("In de loop");
            //System.out.println(x.getIdBestelling());
            //System.out.println(x.getIdKlant());
            //System.out.println(x.getDatum_Bestelling());
            //System.out.println(x.getIdAccount());
            //System.out.println();

        //}
       
       
    }
    
    public static void testUpdateBestelling(){
        //BestellingDAO bestellingDao = new BestellingDAO();
        Bestelling bestelling = new Bestelling();
        
        bestelling.setIdBestelling(5);
        bestelling.setIdKlant(4);
        bestelling.setDatum_Bestelling(new Date());
        bestelling.setIdAccount(1);

        //bestellingDao.update(bestelling);

    }
    
    public static void testCreateBestelArtikel(){
        //BestelArtikelDAO bestelArtikelDoa = new BestelArtikelDAO();
        BestelArtikel bestelArtikel = new BestelArtikel();
        bestelArtikel.setIdBestelling(5);
        bestelArtikel.setIdArtikel(5);
        bestelArtikel.setAantal(5);
        
     
        //bestelArtikelDoa.create(bestelArtikel);

    }
    
    public static void testDeleteBestelArtikel(){
        //BestelArtikelDAO bestelArtikelDoa = new BestelArtikelDAO();
        BestelArtikel bestelArtikel = new BestelArtikel();
        bestelArtikel.setIdBestelling(5);
        bestelArtikel.setIdArtikel(5);
        
     
        //bestelArtikelDoa.delete(bestelArtikel);
  
    }
    
    public static void testReadByIdBestellingIdArtikel(){
        //BestelArtikelDAO bestelArtikelDoa = new BestelArtikelDAO();
        BestelArtikel bestelArtikel = new BestelArtikel();
        bestelArtikel.setIdBestelling(5);
        bestelArtikel.setIdArtikel(5);
        
        //BestelArtikel gevondenBestelArtikel=bestelArtikelDoa.readByIdBestellingIdArtikel(bestelArtikel);
        //System.out.println(gevondenBestelArtikel.getIdBestelling());
        //System.out.println(gevondenBestelArtikel.getIdArtikel());
        //System.out.println(gevondenBestelArtikel.getAantal());
  
    }
    
    public static void testReadAllBestelArtikel(){
        //BestelArtikelDAO bestelArtikelDao = new BestelArtikelDAO();
     

    //Set<BestelArtikel> bestelArtikelen = bestelArtikelDao.readAll();

        //for (BestelArtikel x:bestelArtikelen){         
            //System.out.println(x.getIdBestelling());
            //System.out.println(x.getIdArtikel());
            //System.out.println(x.getAantal());
            //System.out.println();

        //}
      
   
    }
    
    public static void testReadByIdBestellingBestelArtikel(){
        //BestelArtikelDAO bestelArtikelDao = new BestelArtikelDAO();
        BestelArtikel bestelArtikel = new BestelArtikel();
        bestelArtikel.setIdBestelling(5);
      
        //Set<BestelArtikel> bestelArtikelen = bestelArtikelDao.readByIdBestelling(bestelArtikel);
       
        //for (BestelArtikel x:bestelArtikelen){         
            //System.out.println(x.getIdBestelling());
           // System.out.println(x.getIdArtikel());
            //System.out.println(x.getAantal());
            //System.out.println();

        //}
   
    }
    
    public static void testUpdateBestelArtikel(){
        //BestelArtikelDAO bestelArtikelDoa = new BestelArtikelDAO();
        BestelArtikel bestelArtikel = new BestelArtikel();
        bestelArtikel.setIdBestelling(2);
        bestelArtikel.setIdArtikel(2);
        bestelArtikel.setAantal(5);
        
      
        //bestelArtikelDoa.update(bestelArtikel);
      
  
    }
        
     
    public static void testArtikelCreate(){
        
       EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.mycompany_mavenproject2_jar_1.0-SNAPSHOTPU");
       EntityManager entitymanager = entityManagerFactory.createEntityManager();
       
        //ArtikelDAO artikelDao = new ArtikelDAO();
        entitymanager.getTransaction().begin();
        Artikel artikel = new Artikel();
        artikel.setIdArtikel(0);
        artikel.setNaam("naam7");
        artikel.setPrijs(new BigDecimal("77.77"));
        artikel.setVoorraad(77);
        
        entitymanager.persist(artikel);
        entitymanager.getTransaction( ).commit( );

        entitymanager.close( );
        entityManagerFactory.close( );
        
       
        //artikelDao.create(artikel);
 
    }
      
    public static void testArtikelDelete(){
        //ArtikelDAO artikelDao = new ArtikelDAO();
        Artikel artikel = new Artikel();
        artikel.setIdArtikel(7);
      
        //artikelDao.delete(artikel);
     
    }
    
    
    public static void testReadByArtikelID(){
        
        //ArtikelDAO artikelDao = new ArtikelDAO();
        Artikel artikel = new Artikel();
        
        artikel.setIdArtikel(4);
        
        
        
        //Artikel gevondenArtikel = artikelDao.readByIdArtikel(artikel);
        //System.out.println(gevondenArtikel.getNaam());
        //System.out.println(gevondenArtikel.getPrijs());
        //System.out.println(gevondenArtikel.getVoorraad());
        
  
    }
    
    public static void testUpdateArtikel() {
        
        //ArtikelDAO artikelDao = new ArtikelDAO();
        Artikel artikel = new Artikel();
        artikel.setIdArtikel(4);
        artikel.setNaam("nieuwe naam444");
        artikel.setPrijs(new BigDecimal("56.78"));
        artikel.setVoorraad(444);

        //artikelDao.update(artikel);

    }
    
    public static void testReadAllArtikel (){
        //ArtikelDAO artikelDao = new ArtikelDAO();
     
       
        //Set<Artikel> artikelen = artikelDao.readAll();
       
        //for (Artikel x:artikelen){         
        //    System.out.println(x.getIdArtikel());
        //    System.out.println(x.getNaam());
        //    System.out.println(x.getPrijs());
        //    System.out.println(x.getVoorraad());
        //    System.out.println();

        }
 
          
    
    
    public static void testReadByNameArtikel(){
        
        //ArtikelDAO artikelDao = new ArtikelDAO();
        Artikel artikel = new Artikel();
        artikel.setNaam("naam5");
      
        //Set<Artikel> artikelen = artikelDao.readByNaam(artikel);
        //for (Artikel x:artikelen){
        //    System.out.println("In de loop");
        //    System.out.println(x.getIdArtikel());
        //    System.out.println(x.getNaam());
        //    System.out.println(x.getPrijs());
        //    System.out.println(x.getVoorraad());
         //   System.out.println();

        //}
     
   
    }
    
    // test KlantDAO
    
     public static void testCreateKlant(){
        
       //KlantDAO klantDao = new KlantDAO();
        Klant klant = new Klant();
       
        
        klant.setIdKlant(0);
        klant.setVoornaam("voornaam6");
        klant.setAchternaam("achternaam6");
        klant.setTussenvoegsel("tussenvoegse6");
        klant.setTelefoonnummer("telefoonnummer6");
        klant.setEmailadres("emailadres6");

        //klantDao.create(klant);

    }
      
    public static void testDeleteKlant() {
        //KlantDAO klantDao = new KlantDAO();
        Klant klant = new Klant();
        klant.setIdKlant(7);
       
        //klantDao.delete(klant);

    }
    
    
    public static void testReadByIDKlant(){
        
        //KlantDAO klantDao = new KlantDAO();
        Klant klant = new Klant();
        
        klant.setIdKlant(5);
        
        
    
        //Klant gevondenKlant = klantDao.readByIdKLant(klant);

        //System.out.println(gevondenKlant.getVoornaam());
        //System.out.println(gevondenKlant.getAchternaam());
        //System.out.println(gevondenKlant.getTussenvoegsel());
        //System.out.println(gevondenKlant.getTelefoonnummer());
        //System.out.println(gevondenKlant.getEmailadres());


   
    }
    
    public static void testUpdateKlant() {
        
        //KlantDAO klantDao = new KlantDAO();
        Klant klant = new Klant();
        klant.setIdKlant(5);
        klant.setVoornaam("voornaam55");
        klant.setAchternaam("achternaam55");
        klant.setTussenvoegsel("tussenvoegse55");
        klant.setTelefoonnummer("telefoonnummer55");
        klant.setEmailadres("emailadres55");
        
    
        //klantDao.update(klant);
 
    }
    
    public static void testReadAllKlant() {
        //KlantDAO klantDao = new KlantDAO();
     
       
        //Set<Klant> klanten = klantDao.readAll();
       
        //for (Klant x:klanten) {         
            //System.out.println(x.getIdKlant());
            //System.out.println(x.getVoornaam());
            //System.out.println(x.getAchternaam());
            //System.out.println(x.getTussenvoegsel());
           //System.out.println(x.getTelefoonnummer());
           // System.out.println(x.getEmailadres());    
            //System.out.println();
        //}


    }
    
    public static void testReadByAchternaamKlant(){
        
        //KlantDAO klantDao = new KlantDAO();
        Klant klant = new Klant();
        klant.setAchternaam("achternaam4");
   

        //Set<Klant> klanten = klantDao.readByAchternaamKlant(klant);
        //for (Klant x:klanten) {         
            //System.out.println(x.getIdKlant());
            //System.out.println(x.getVoornaam());
           // System.out.println(x.getAchternaam());
            //System.out.println(x.getTussenvoegsel());
           // System.out.println(x.getTelefoonnummer());
           // System.out.println(x.getEmailadres());    
           // System.out.println();

        //}

     
    }
    
    
}
     
     // test ArtikelDAO
     
     
    
    
    
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 
          

    
    
    
    // test KlantDAO
    
     
    
    
    
    
   
    
    
    
    
    
    
    
    
    
    
    
     
     
     
     
    

