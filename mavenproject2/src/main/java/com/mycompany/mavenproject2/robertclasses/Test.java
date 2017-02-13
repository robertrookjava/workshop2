/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.mycompany.mavenproject2.robertclasses;



import com.mycompany.mavenproject2.pojo.Artikel;
import com.mycompany.mavenproject2.pojo.Klant;
import com.mycompany.mavenproject2.pojo.Bestelling;
import com.mycompany.mavenproject2.pojo.Account;
import com.mycompany.mavenproject2.pojo.Accounttype;
import com.mycompany.mavenproject2.pojo.BestelArtikel;
import com.mycompany.mavenproject2.model.Model;

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
         //testMaakAccount();
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
         
         
         //if (CheckFormat.isEmailAdres("hallo@hfhf.nl")){
         //    System.out.println("ja");
         //}
         //else {
         //     System.out.println("nee");
         //}
         
         
  
         
         
    }
    
    
     // test ArtikelDAO
    
    
    
    
    
    
    
    
    

    public static void testMaakAccount(){
       
        
        Model model = new Model();
        model.maakAccount();
     }
     
     
    public static void testCreateBestelling(){
        //BestellingDAO bestellingDao = new BestellingDAO();
        //Bestelling bestelling = new Bestelling();
        //bestelling.setIdBestelling(0);
        //bestelling.setIdKlant(6);
        //bestelling.setDatum_Bestelling(new Date());
        //bestelling.setIdAccount(1);
      
        //bestellingDao.create(bestelling);
        
        Model model = new Model();
        int idBestelling = model.createBestelling(5, 1);
        System.out.println("Robert1: idBestelling = "+idBestelling);
        
 
    }
    
    public static void testDeleteBestelling(){
       // BestellingDAO bestellingDao = new BestellingDAO();
       //Bestelling bestelling = new Bestelling();
       //bestelling.setIdBestelling(9);
        
        //bestellingDao.delete(bestelling);
        Model model = new Model();
        model.deleteBestelling(3);
    }
    
    public static void testReadByIdBestelling(){
        
        //BestellingDAO bestellingDao = new BestellingDAO();
        //Bestelling bestelling = new Bestelling();
        //bestelling.setIdBestelling(4);
        
        
        //Bestelling gevondenBestelling = bestellingDao.readByIdBestelling(bestelling);
        //System.out.println(gevondenBestelling.getIdKlant());
        //System.out.println(gevondenBestelling.getDatum_Bestelling());
        //System.out.println(gevondenBestelling.getIdAccount());
        Model model = new Model();
        Bestelling gevondenBestelling = model.readByIdBestelling(4);
        System.out.println(gevondenBestelling.getIdKlant());
        System.out.println(gevondenBestelling.getDatum_Bestelling());
        System.out.println(gevondenBestelling.getIdAccount());
     
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
        Model model = new Model();
        List<Bestelling> bestellingen = model.readAllBestelling();
        
       
        for (Bestelling x:bestellingen){         
            System.out.println(x.getIdBestelling());
            System.out.println(x.getIdKlant());
            System.out.println(x.getDatum_Bestelling());
            System.out.println(x.getIdAccount());
            System.out.println();

        }
        
    }
    
    public static void testReadByIdKlantBestelling(){
        
        //BestellingDAO bestellingDao = new BestellingDAO();
        //Bestelling bestelling = new Bestelling();
        //bestelling.setIdKlant(5);
      
        
        //Set<Bestelling> bestellingen = bestellingDao.readByIdKlant(bestelling);
        //for (Bestelling x:bestellingen){
            //System.out.println("In de loop");
            //System.out.println(x.getIdBestelling());
            //System.out.println(x.getIdKlant());
            //System.out.println(x.getDatum_Bestelling());
            //System.out.println(x.getIdAccount());
            //System.out.println();

        //}
        Model model = new Model();
        List<Bestelling> bestellingen = model.readByIdKlantBestelling(2);
        for (Bestelling x:bestellingen){
            System.out.println("In de loop");
            System.out.println(x.getIdBestelling());
            System.out.println(x.getIdKlant());
            System.out.println(x.getDatum_Bestelling());
            System.out.println(x.getIdAccount());
            System.out.println();

        }
       
    }
    
    public static void testUpdateBestelling(){
        //BestellingDAO bestellingDao = new BestellingDAO();
        //Bestelling bestelling = new Bestelling();
        
        //bestelling.setIdBestelling(5);
        //bestelling.setIdKlant(4);
        //bestelling.setDatum_Bestelling(new Date());
        //bestelling.setIdAccount(1);

        //bestellingDao.update(bestelling);
        Model model = new Model();
        model.updateBestelling(4, 6, 1);
    }
    
    public static void testCreateBestelArtikel(){
        //BestelArtikelDAO bestelArtikelDoa = new BestelArtikelDAO();
        //BestelArtikel bestelArtikel = new BestelArtikel();
        //bestelArtikel.setIdBestelling(5);
        //bestelArtikel.setIdArtikel(5);
        //bestelArtikel.setAantal(5);
        
     
        //bestelArtikelDoa.create(bestelArtikel);
        Model model = new Model();
        model.createBestelArtikel(1, 15, 40);
    }
    
    public static void testDeleteBestelArtikel(){
        //BestelArtikelDAO bestelArtikelDoa = new BestelArtikelDAO();
        //BestelArtikel bestelArtikel = new BestelArtikel();
        //bestelArtikel.setIdBestelling(5);
        //bestelArtikel.setIdArtikel(5);
        
     
        //bestelArtikelDoa.delete(bestelArtikel);
        Model model = new Model();
        model.deleteBestelArtikel(1, 15);
    }
    
    public static void testReadByIdBestellingIdArtikel(){
        //BestelArtikelDAO bestelArtikelDoa = new BestelArtikelDAO();
        //BestelArtikel bestelArtikel = new BestelArtikel();
        //bestelArtikel.setIdBestelling(5);
        //bestelArtikel.setIdArtikel(5);
        
        //BestelArtikel gevondenBestelArtikel=bestelArtikelDoa.readByIdBestellingIdArtikel(bestelArtikel);
        //System.out.println(gevondenBestelArtikel.getIdBestelling());
        //System.out.println(gevondenBestelArtikel.getIdArtikel());
        //System.out.println(gevondenBestelArtikel.getAantal());
        Model model = new Model();
        BestelArtikel gevondenBestelArtikel= model.readByIdBestellingIdArtikel(4, 12);
        System.out.println(gevondenBestelArtikel.getIdBestelling());
        System.out.println(gevondenBestelArtikel.getIdArtikel());
        System.out.println(gevondenBestelArtikel.getAantal());
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
        Model model = new Model();
        List<BestelArtikel> bestelArtikelen = model.readAllBestelArtikel();

        for (BestelArtikel x:bestelArtikelen){         
            System.out.println(x.getIdBestelling());
            System.out.println(x.getIdArtikel());
            System.out.println(x.getAantal());
            System.out.println();

        }
      
   
    }
    
    public static void testReadByIdBestellingBestelArtikel(){
        //BestelArtikelDAO bestelArtikelDao = new BestelArtikelDAO();
        //BestelArtikel bestelArtikel = new BestelArtikel();
        //bestelArtikel.setIdBestelling(5);
      
        //Set<BestelArtikel> bestelArtikelen = bestelArtikelDao.readByIdBestelling(bestelArtikel);
       
        //for (BestelArtikel x:bestelArtikelen){         
            //System.out.println(x.getIdBestelling());
           // System.out.println(x.getIdArtikel());
            //System.out.println(x.getAantal());
            //System.out.println();

        //}
        Model model = new Model();
        
        List<BestelArtikel> bestelArtikelen = model.readByIdBestellingBestelArtikel(1);
       
        for (BestelArtikel x:bestelArtikelen){         
            System.out.println(x.getIdBestelling());
            System.out.println(x.getIdArtikel());
            System.out.println(x.getAantal());
            System.out.println();

        }
    }
    
    public static void testUpdateBestelArtikel(){
        //BestelArtikelDAO bestelArtikelDoa = new BestelArtikelDAO();
        //BestelArtikel bestelArtikel = new BestelArtikel();
        //bestelArtikel.setIdBestelling(2);
        //bestelArtikel.setIdArtikel(2);
        //bestelArtikel.setAantal(5);
        
      
        //bestelArtikelDoa.update(bestelArtikel);
        Model model = new Model();
        model.updateBestelArtikel(4, 12, 40);
  
    }
        
     
    public static void testArtikelCreate(){
       
        //EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
     
        //EntityManager entitymanager = entityManagerFactory.createEntityManager();
       
        //ArtikelDAO artikelDao = new ArtikelDAO();
        //entitymanager.getTransaction().begin();
       
        //Artikel artikel = new Artikel();
    
        //artikel.setIdArtikel(0);
        
        //artikel.setNaam("naam7");
      
        //artikel.setPrijs(new BigDecimal("77.77"));
       
        //artikel.setVoorraad(77);
         //System.out.println("Robert9");
        
        //entitymanager.persist(artikel);
        //System.out.println("Robert10");
        //entitymanager.getTransaction( ).commit( );
        //System.out.println("Robert11");

        //entitymanager.close( );
        //System.out.println("Robert12");
        //entityManagerFactory.close( );
        //System.out.println("Robert13");
        
        Model model = new Model();
        model.createArtikel("naam5", new BigDecimal (66.66), 77);
        
        
       
        //artikelDao.create(artikel);
 
    }
    
    
      
    public static void testArtikelDelete(){
        //ArtikelDAO artikelDao = new ArtikelDAO();
        //Artikel artikel = new Artikel();
        //artikel.setIdArtikel(7);
      
        //artikelDao.delete(artikel);
         Model model = new Model();
         model.deleteArtikel(14);
     
    }
    
    
    public static void testReadByArtikelID(){
        
        //ArtikelDAO artikelDao = new ArtikelDAO();
        //Artikel artikel = new Artikel();
        
        //artikel.setIdArtikel(4);
        
        
        
        //Artikel gevondenArtikel = artikelDao.readByIdArtikel(artikel);
        //System.out.println(gevondenArtikel.getNaam());
        //System.out.println(gevondenArtikel.getPrijs());
        //System.out.println(gevondenArtikel.getVoorraad());
        Model model = new Model();
        Artikel gevondenArtikel = model.readByIdArtikel(12);
        System.out.println(gevondenArtikel.getNaam());
        System.out.println(gevondenArtikel.getPrijs());
        System.out.println(gevondenArtikel.getVoorraad());
  
    }
    
    public static void testUpdateArtikel() {
        
        //ArtikelDAO artikelDao = new ArtikelDAO();
        //Artikel artikel = new Artikel();
        //artikel.setIdArtikel(4);
        //artikel.setNaam("nieuwe naam444");
        //artikel.setPrijs(new BigDecimal("56.78"));
        //artikel.setVoorraad(444);

        //artikelDao.update(artikel);
         Model model = new Model();
         model.updateArtikel(12, "nieuwe naam12", (new BigDecimal("12.12")), 12);
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
         Model model = new Model();
         
        List<Artikel> artikelen = model.readAllArtikel();
       
        for (Artikel x:artikelen){         
            System.out.println(x.getIdArtikel());
            System.out.println(x.getNaam());
            System.out.println(x.getPrijs());
            System.out.println(x.getVoorraad());
            System.out.println();

        }
    }
 
          
    
    
    public static void testReadByNameArtikel(){
        
        //ArtikelDAO artikelDao = new ArtikelDAO();
        //Artikel artikel = new Artikel();
        //artikel.setNaam("naam5");
      
        //Set<Artikel> artikelen = artikelDao.readByNaam(artikel);
        //for (Artikel x:artikelen){
        //    System.out.println("In de loop");
        //    System.out.println(x.getIdArtikel());
        //    System.out.println(x.getNaam());
        //    System.out.println(x.getPrijs());
        //    System.out.println(x.getVoorraad());
         //   System.out.println();

        //}
         Model model = new Model();
         List<Artikel> artikelen = model.readByNameArtikel("naam5");
         for (Artikel x:artikelen){
            System.out.println("In de loop");
            System.out.println(x.getIdArtikel());
            System.out.println(x.getNaam());
            System.out.println(x.getPrijs());
            System.out.println(x.getVoorraad());
            System.out.println();

        }
   
    }
    
    // test KlantDAO
    
     public static void testCreateKlant(){
        
       //KlantDAO klantDao = new KlantDAO();
        //Klant klant = new Klant();
       
        
        //klant.setIdKlant(0);
        //klant.setVoornaam("voornaam6");
        //klant.setAchternaam("achternaam6");
        //klant.setTussenvoegsel("tussenvoegse6");
        //klant.setTelefoonnummer("telefoonnummer6");
        //klant.setEmailadres("emailadres6");

        //klantDao.create(klant);
         Model model = new Model();
         model.createKlant("voornaam11", "achternaam11", "tussenvoegsel11", "telefoonnummer11", "emailadres11");
    }
      
    public static void testDeleteKlant() {
        //KlantDAO klantDao = new KlantDAO();
        //Klant klant = new Klant();
        //klant.setIdKlant(7);
       
        //klantDao.delete(klant);
        Model model = new Model();
        model.deleteKlant(4);

    }
    
    
    public static void testReadByIDKlant(){
        
        //KlantDAO klantDao = new KlantDAO();
        //Klant klant = new Klant();
        
        //klant.setIdKlant(5);
        
        
    
        //Klant gevondenKlant = klantDao.readByIdKLant(klant);

        //System.out.println(gevondenKlant.getVoornaam());
        //System.out.println(gevondenKlant.getAchternaam());
        //System.out.println(gevondenKlant.getTussenvoegsel());
        //System.out.println(gevondenKlant.getTelefoonnummer());
        //System.out.println(gevondenKlant.getEmailadres());
        Model model = new Model();
        Klant gevondenKlant = model.readByIDKlant(20);

        System.out.println(gevondenKlant.getVoornaam());
        System.out.println(gevondenKlant.getAchternaam());
        System.out.println(gevondenKlant.getTussenvoegsel());
        System.out.println(gevondenKlant.getTelefoonnummer());
        System.out.println(gevondenKlant.getEmailadres());

   
    }
    
    public static void testUpdateKlant() {
        
        //KlantDAO klantDao = new KlantDAO();
        //Klant klant = new Klant();
        //klant.setIdKlant(5);
        //klant.setVoornaam("voornaam55");
        //klant.setAchternaam("achternaam55");
        //klant.setTussenvoegsel("tussenvoegse55");
        //klant.setTelefoonnummer("telefoonnummer55");
        //klant.setEmailadres("emailadres55");
        
    
        //klantDao.update(klant);
         Model model = new Model();
         model.updateKlant(5, "voornaam55", "achternaam55", "tussenvoegse55", "telefoonnummer55", "emailadres55");
 
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
         Model model = new Model();
         
        List<Klant> klanten = model.readAllKlant();
       
        for (Klant x:klanten) {         
            System.out.println(x.getIdKlant());
            System.out.println(x.getVoornaam());
            System.out.println(x.getAchternaam());
            System.out.println(x.getTussenvoegsel());
            System.out.println(x.getTelefoonnummer());
            System.out.println(x.getEmailadres());    
            System.out.println();
        }

    }
    
    public static void testReadByAchternaamKlant(){
        
        //KlantDAO klantDao = new KlantDAO();
        //Klant klant = new Klant();
        //klant.setAchternaam("achternaam4");
   

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
        Model model = new Model();
         
        List<Klant> klanten = model.readByAchternaamKlant("achternaam20");
        for (Klant x:klanten) {         
            System.out.println(x.getIdKlant());
            System.out.println(x.getVoornaam());
            System.out.println(x.getAchternaam());
            System.out.println(x.getTussenvoegsel());
            System.out.println(x.getTelefoonnummer());
            System.out.println(x.getEmailadres());    
            System.out.println();

        }
     
    }
    
    
}
     
     
    
    
    
    
    
    
     
     
     
     
    

