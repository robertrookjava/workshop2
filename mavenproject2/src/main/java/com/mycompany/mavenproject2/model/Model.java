/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.model;

import com.mycompany.mavenproject2.database.dao.BestellingDAO;
import com.mycompany.mavenproject2.database.dao.BestelArtikelDAO;
import com.mycompany.mavenproject2.database.dao.ArtikelDAO;
import com.mycompany.mavenproject2.database.dao.KlantDAO;
import com.mycompany.mavenproject2.database.dao.AccountDAO;
import com.mycompany.mavenproject2.database.dao.AccounttypeDAO;
import com.mycompany.mavenproject2.pojo.Account;
import com.mycompany.mavenproject2.pojo.Accounttype;
import com.mycompany.mavenproject2.pojo.Artikel;
import com.mycompany.mavenproject2.pojo.BestelArtikel;
import com.mycompany.mavenproject2.pojo.Bestelling;
import com.mycompany.mavenproject2.pojo.Klant;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author robertrook
 */
public class Model {
    
    
    private void maakAccountTypeRecord(){
        
        
        AccounttypeDAO accounttypeDao = new AccounttypeDAO();
        Accounttype accounttype = new Accounttype();
        accounttype.setId(1);
        accounttype.setTYpe("amin");
        
        accounttypeDao.create(accounttype);
        
        
        
        
      
    }
    
    private boolean bestaatAccount(int i){
        boolean output = false;
        
        
        AccountDAO accountDao = new  AccountDAO();
        Account account = new Account();
        account.setIdAccount(1);
      
        output = accountDao.bestaatAccount(account);

      
        
        return output;
            
        
    }
    
    
    
    
    private void maakAccountRecord(){
        
        AccountDAO accountDao = new  AccountDAO();
        Account account = new Account();
        account.setIdAccount(1);
        account.setGebruikersnaam("Robert Rook");
        account.setWachtwoord("Geheim");
        account.setDatum_Aanmaak (new Date());
        account.setAccountype_id(1);
        
        accountDao.create(account);
       
        
        
    }
    

    public void maakAccount(){
        boolean bestaatAccount1 = bestaatAccount(1);
         
        if (!bestaatAccount1){
            maakAccountTypeRecord();
            maakAccountRecord();
        }
     }
    
    
    
    public void createArtikel(String naam, BigDecimal prijs, int voorraad){ 
       
        ArtikelDAO artikelDao = new ArtikelDAO();
       
        Artikel artikel = new Artikel();
        artikel.setIdArtikel(0);
        artikel.setNaam(naam);
        artikel.setPrijs(prijs);
        artikel.setVoorraad(voorraad);
        
        artikelDao.create(artikel);
        //System.out.println("Robert1 "+artikel.getIdArtikel());
    }
    
    public void deleteArtikel (int idArtikel){
        boolean exists = existsByIdArtikel (idArtikel);
        if (exists){
      
            ArtikelDAO artikelDao = new ArtikelDAO();
            Artikel artikel = new Artikel();
            artikel.setIdArtikel(idArtikel);
      
            artikelDao.delete(artikel);
        }
        
    }
    
    public Artikel readByIdArtikel (int idArtikel){
        
        ArtikelDAO artikelDao = new ArtikelDAO();
        Artikel artikel = new Artikel();
        artikel.setIdArtikel(idArtikel);
        Artikel gevondenArtikel = artikelDao.read(artikel);
  
        return gevondenArtikel;
    }
    
    public boolean existsByIdArtikel (int idArtikel){
       
        ArtikelDAO artikelDao = new ArtikelDAO();
        Artikel artikel = new Artikel();
        artikel.setIdArtikel(idArtikel);
        boolean exists = artikelDao.existsByIdArtikel(artikel);
  
        return exists;
   }
    
   
    
   
    public void updateArtikel(int idArtikel, String naam, BigDecimal prijs, int voorraad){
       
        ArtikelDAO artikelDao = new ArtikelDAO();
        Artikel artikel = new Artikel();
        artikel.setIdArtikel(idArtikel);
        artikel.setNaam(naam);
        artikel.setPrijs(prijs);
        artikel.setVoorraad(voorraad);

        artikelDao.update(artikel);
    }
    
   public void updateVoorraadArtikel (int idArtikel, int voorraad){
       boolean exists = existsByIdArtikel(idArtikel);
       if (exists) {
           Artikel artikel = readByIdArtikel (idArtikel);
           updateArtikel(idArtikel,artikel.getNaam(),artikel.getPrijs(),voorraad );
          }
       
   }
   
   public void verlaagVoorraadArtikel (int idArtikel, int aantal){
       boolean exists = existsByIdArtikel(idArtikel);
       if (exists) {
           Artikel artikel = readByIdArtikel (idArtikel);
           updateArtikel(idArtikel,artikel.getNaam(),artikel.getPrijs(),artikel.getVoorraad()-aantal );
          }
       
   }
   
   public void verhoogVoorraadArtikel (int idArtikel, int aantal){
       boolean exists = existsByIdArtikel(idArtikel);
       if (exists) {
           Artikel artikel = readByIdArtikel (idArtikel);
           updateArtikel(idArtikel,artikel.getNaam(),artikel.getPrijs(),artikel.getVoorraad()+aantal );
          }
       
   }
   
   
    
    public List<Artikel> readAllArtikel () {

        
        ArtikelDAO artikelDao = new ArtikelDAO();
        List<Artikel> artikelen = artikelDao.readAll();
       
        return artikelen;
   }

   
    public List<Artikel> readByNameArtikel (String naam) {
        
        ArtikelDAO artikelDao = new ArtikelDAO();
        Artikel artikel = new Artikel();
        artikel.setNaam(naam);
        List<Artikel> artikelen = artikelDao.readByNaam(artikel);
        
        return artikelen;
       
    }
    
    public boolean existsByNameArtikel (String naam) {
        
        ArtikelDAO artikelDao = new ArtikelDAO();
        Artikel artikel = new Artikel();
        artikel.setNaam(naam);
        boolean exists = artikelDao.existsByNaam(artikel);
        
        return exists;
       
    }
    
    // klant acties 
    
     public void createKlant(String voornaam, String achternaam, String tussenvoegsel, String telefoonnummer, String emailadres){
        
        KlantDAO klantDao = new KlantDAO();
        Klant klant = new Klant();
       
        
        klant.setIdKlant(0);
        klant.setVoornaam(voornaam);
        klant.setAchternaam(achternaam);
        klant.setTussenvoegsel(tussenvoegsel);
        klant.setTelefoonnummer(telefoonnummer);
        klant.setEmailadres(emailadres);

        klantDao.create(klant);

    }
      
    public void deleteKlant(int idKlant) {
        
        boolean exists = existsByIDKlant(idKlant);
        
        if (exists){
        
            KlantDAO klantDao = new KlantDAO();
            Klant klant = new Klant();
            klant.setIdKlant(idKlant);
            klantDao.delete(klant);
        }

    }
    
    
    public Klant readByIDKlant(int idKlant){
        
        
        KlantDAO klantDao = new KlantDAO();
        Klant klant = new Klant();
        klant.setIdKlant(idKlant);
    
        Klant gevondenKlant = klantDao.read(klant);

        return gevondenKlant;
   
    }
    
    
    public boolean existsByIDKlant(int idKlant){
        
        
        KlantDAO klantDao = new KlantDAO();
        Klant klant = new Klant();
        klant.setIdKlant(idKlant);
    
        boolean exists = klantDao.existsByIdKLant(klant);

        return exists;
   
    }
    
    public boolean existsBestellingByIdKlant (int idKlant){
       
        KlantDAO klantDao = new KlantDAO();
        Klant klant = new Klant();
        klant.setIdKlant(idKlant);
        boolean exists = klantDao.existsBestellingByIdKlant(klant);
        return exists;
    }
    
    public boolean existsBestelArtikelByIdArtikel (int idArtikel){
       
        ArtikelDAO artikelDao = new ArtikelDAO();
        List<Artikel> artikelen = artikelDao.readAll();
        Artikel artikel = new Artikel();
        artikel.setIdArtikel(idArtikel);
        boolean exists = artikelDao.existsBestelArtikelByIdArtikel(artikel);
        return exists;
    }
    
    public void updateKlant(int idKlant, String voornaam, String achternaam, String tussenvoegsel, String telefoonnummer, String emailadres) {
        
        
        KlantDAO klantDao = new KlantDAO();
        Klant klant = new Klant();
        klant.setIdKlant(idKlant);
        klant.setVoornaam(voornaam);
        klant.setAchternaam(achternaam);
        klant.setTussenvoegsel(tussenvoegsel);
        klant.setTelefoonnummer(telefoonnummer);
        klant.setEmailadres(emailadres);
   
        klantDao.update(klant);
 
    }
    
    public List<Klant> readAllKlant() {
        
        KlantDAO klantDao = new KlantDAO();
        List<Klant> klanten = klantDao.readAll();
       
        return klanten;


    }
    
    public List<Klant> readByAchternaamKlant(String achternaam){
        
        
        KlantDAO klantDao = new KlantDAO();
        Klant klant = new Klant();
        klant.setAchternaam(achternaam);
        List<Klant> klanten = klantDao.readByAchternaamKlant(klant);
        
        return klanten;
     
    }
    
    public boolean existsByAchternaamKlant(String achternaam){
        
        
        KlantDAO klantDao = new KlantDAO();
        Klant klant = new Klant();
        klant.setAchternaam(achternaam);
        boolean exists = klantDao.existsByAchternaamKlant(klant);
        
        return exists;
     
    }
    
    
    
    // bestelling acties
    
    
    
    public int createBestelling(int idKlant, int idAccount){
       
        BestellingDAO bestellingDao = new BestellingDAO();
        Bestelling bestelling = new Bestelling();
        bestelling.setIdBestelling(0);
        bestelling.setIdKlant(idKlant);
        bestelling.setDatum_Bestelling(new Date());
        bestelling.setIdAccount(idAccount);
        
        int idBestelling = bestellingDao.create(bestelling);
      
        return idBestelling;
    }
    
    public void deleteBestelling(int idBestelling){
        
        BestellingDAO bestellingDao = new BestellingDAO();
        Bestelling bestelling = new Bestelling();
        bestelling.setIdBestelling(idBestelling);
        
        bestellingDao.delete(bestelling);
    
    }
    
    public Bestelling readByIdBestelling(int idBestelling){
        
        
        BestellingDAO bestellingDao = new BestellingDAO();
        Bestelling bestelling = new Bestelling();
        bestelling.setIdBestelling(idBestelling);
        Bestelling gevondenBestelling = bestellingDao.read(bestelling);

        return gevondenBestelling;
     
    }
    
    
    public boolean existsByIdBestelling(int idBestelling){
        
        
        BestellingDAO bestellingDao = new BestellingDAO();
        Bestelling bestelling = new Bestelling();
        bestelling.setIdBestelling(idBestelling);
        boolean exists = bestellingDao.existsByIdBestelling(bestelling);

        return exists;
     
    }
    
    
    
    public List<Bestelling> readAllBestelling(){
        
        BestellingDAO bestellingDao = new BestellingDAO();
        List<Bestelling> bestellingen = bestellingDao.readAll();
       
        return bestellingen;
 
    }
    
    public List<Bestelling> readByIdKlantBestelling(int idKlant){
        
        
        BestellingDAO bestellingDao = new BestellingDAO();
        Bestelling bestelling = new Bestelling();
        bestelling.setIdKlant(idKlant);
        List<Bestelling> bestellingen = bestellingDao.readByIdKlant(bestelling);
        
        return bestellingen;
    }
    
    public void updateBestelling(int idBestelling, int idKlant, int idAccount){
        
        BestellingDAO bestellingDao = new BestellingDAO();
        Bestelling bestelling = new Bestelling();
        
        bestelling.setIdBestelling(idBestelling);
        bestelling.setIdKlant(idKlant);
        bestelling.setDatum_Bestelling(new Date());
        bestelling.setIdAccount(idAccount);

        bestellingDao.update(bestelling);

    }
    
    public void createBestelArtikel(int idBestelling, int idArtikel, int aantal){
       
        BestelArtikelDAO bestelArtikelDao = new BestelArtikelDAO();
        BestelArtikel bestelArtikel = new BestelArtikel();
        bestelArtikel.setIdBestelling(idBestelling);
        bestelArtikel.setIdArtikel(idArtikel);
        bestelArtikel.setAantal(aantal);
      
        bestelArtikelDao.create(bestelArtikel);

    }
    
    public void deleteBestelArtikel(int idBestelling, int idArtikel){
       
        BestelArtikelDAO bestelArtikelDao = new BestelArtikelDAO();

        BestelArtikel bestelArtikel = new BestelArtikel();
        bestelArtikel.setIdBestelling(idBestelling);
        bestelArtikel.setIdArtikel(idArtikel);
        
     
        bestelArtikelDao.delete(bestelArtikel);
  
    }
    
    public BestelArtikel readByIdBestellingIdArtikel(int idBestelling, int idArtikel){
        
        BestelArtikelDAO bestelArtikelDao = new BestelArtikelDAO();

        BestelArtikel bestelArtikel = new BestelArtikel();
        bestelArtikel.setIdBestelling(idBestelling);
        bestelArtikel.setIdArtikel(idArtikel);
        
        BestelArtikel gevondenBestelArtikel=bestelArtikelDao.read(bestelArtikel);
        
        return gevondenBestelArtikel;
  
    }
    
    public boolean existsByIdBestellingIdArtikel(int idBestelling, int idArtikel){
        
        BestelArtikelDAO bestelArtikelDao = new BestelArtikelDAO();

        BestelArtikel bestelArtikel = new BestelArtikel();
        bestelArtikel.setIdBestelling(idBestelling);
        bestelArtikel.setIdArtikel(idArtikel);
        
        boolean exists=bestelArtikelDao.existsByIdBestellingIdArtikel(bestelArtikel);
        
        return exists;
  
    }
    
    public List<BestelArtikel> readAllBestelArtikel(){
       
        BestelArtikelDAO bestelArtikelDao = new BestelArtikelDAO();

        List<BestelArtikel> bestelArtikelen = bestelArtikelDao.readAll();

        return bestelArtikelen;
    }
    
    public List<BestelArtikel> readByIdBestellingBestelArtikel(int idBestelling){
        
        BestelArtikelDAO bestelArtikelDao = new BestelArtikelDAO();

        BestelArtikel bestelArtikel = new BestelArtikel();
        bestelArtikel.setIdBestelling(idBestelling);
      
        List<BestelArtikel> bestelArtikelen = bestelArtikelDao.readByIdBestelling(bestelArtikel);
       
        return bestelArtikelen;
   
    }
    
    public void updateBestelArtikel(int idBestelling, int idArtikel, int aantal){
      
        BestelArtikelDAO bestelArtikelDao = new BestelArtikelDAO();

        BestelArtikel bestelArtikel = new BestelArtikel();
        bestelArtikel.setIdBestelling(idBestelling);
        bestelArtikel.setIdArtikel(idArtikel);
        bestelArtikel.setAantal(aantal);
   
        bestelArtikelDao.update(bestelArtikel);
      
  
    }
    
    

   
    
    
    
    
}
