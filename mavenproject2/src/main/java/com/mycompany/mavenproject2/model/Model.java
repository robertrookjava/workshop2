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
import com.mycompany.mavenproject2.database.daofactory.KlantDaoFactory;
import com.mycompany.mavenproject2.database.daofactory.ArtikelDaoFactory;
import com.mycompany.mavenproject2.database.daofactory.AccountDaoFactory;
import com.mycompany.mavenproject2.database.daofactory.AccounttypeDaoFactory;
import com.mycompany.mavenproject2.database.daofactory.BestelArtikelDaofactory;
import com.mycompany.mavenproject2.database.daofactory.BestellingDaoFactory;
import com.mycompany.mavenproject2.database.dao.AccountDAO;
import com.mycompany.mavenproject2.database.dao.AccounttypeDAO;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import com.mycompany.mavenproject2.database.Database;

/**
 *
 * @author robertrook
 */
public class Model {
    
    // aanmaken van 1 accound  zonder onderhoudsscherm 
    
    private Database database;
    
    public void setDatabase (Database database){
        this.database = database;
        
    }
    
    public Database getDatabase (){
        return this.database;
    }
    
    private void maakAccountTypeRecord(){
        
        AccounttypeDaoFactory accounttypeDaoFactory = new AccounttypeDaoFactory ();
        AccounttypeDAO accounttypeDao = accounttypeDaoFactory.getAccounttypeDao(getDatabase());
        Accounttype accounttype = new Accounttype();
        accounttype.setId(1);
        accounttype.setTYpe("amin");
        
        accounttypeDao.create(accounttype);
        
      
    }
    
    private boolean bestaatAccount(int i){
        boolean output = false;
        
        AccountDaoFactory accountDaoFactory = new AccountDaoFactory ();
        AccountDAO accountDao = accountDaoFactory.getAccountDao(getDatabase());
        Account account = new Account();
        account.setIdAccount(1);
      
        output = accountDao.bestaatAccount(account);

      
        
        return output;
            
        
    }
    
    
    
    
    private void maakAccountRecord(){
        AccountDaoFactory accountDaoFactory = new AccountDaoFactory ();
        AccountDAO accountDao = accountDaoFactory.getAccountDao(getDatabase());
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
    
    // artikel acties
    
    public void createArtikel(String naam, BigDecimal prijs, int voorraad){ 
        ArtikelDaoFactory  artikelDaoFactory = new ArtikelDaoFactory ();
        ArtikelDAO artikelDao = artikelDaoFactory.getArtikelDao(getDatabase());
       
        Artikel artikel = new Artikel();
        artikel.setIdArtikel(0);
        artikel.setNaam(naam);
        artikel.setPrijs(prijs);
        artikel.setVoorraad(voorraad);
        
        artikelDao.create(artikel);
    }
    
    public void deleteArtikel (int idArtikel){
        ArtikelDaoFactory  artikelDaoFactory = new ArtikelDaoFactory ();
        ArtikelDAO artikelDao = artikelDaoFactory.getArtikelDao(getDatabase());
        Artikel artikel = new Artikel();
        artikel.setIdArtikel(idArtikel);
      
        artikelDao.delete(artikel);
        
    }
    
    public Artikel readByIdArtikel (int idArtikel){
        ArtikelDaoFactory  artikelDaoFactory = new ArtikelDaoFactory ();
        ArtikelDAO artikelDao = artikelDaoFactory.getArtikelDao(getDatabase());
        Artikel artikel = new Artikel();
        artikel.setIdArtikel(idArtikel);
        Artikel gevondenArtikel = artikelDao.readByIdArtikel(artikel);
  
        return gevondenArtikel;
    }
    
    public boolean existsByIdArtikel (int idArtikel){
        ArtikelDaoFactory  artikelDaoFactory = new ArtikelDaoFactory ();
        ArtikelDAO artikelDao = artikelDaoFactory.getArtikelDao(getDatabase());
        Artikel artikel = new Artikel();
        artikel.setIdArtikel(idArtikel);
        boolean exists = artikelDao.existsByIdArtikel(artikel);
  
        return exists;
   }
    
   
    
   
    public void updateArtikel(int idArtikel, String naam, BigDecimal prijs, int voorraad){
        ArtikelDaoFactory  artikelDaoFactory = new ArtikelDaoFactory ();
        ArtikelDAO artikelDao = artikelDaoFactory.getArtikelDao(getDatabase());
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
   
   
    
    public Set<Artikel> readAllArtikel () {

        ArtikelDaoFactory  artikelDaoFactory = new ArtikelDaoFactory ();
        ArtikelDAO artikelDao = artikelDaoFactory.getArtikelDao(getDatabase());
        Set<Artikel> artikelen = artikelDao.readAll();
       
        return artikelen;
   }

   
    public Set <Artikel> readByNameArtikel (String naam) {
        ArtikelDaoFactory  artikelDaoFactory = new ArtikelDaoFactory ();
        ArtikelDAO artikelDao = artikelDaoFactory.getArtikelDao(getDatabase());
        Artikel artikel = new Artikel();
        artikel.setNaam(naam);
        Set<Artikel> artikelen = artikelDao.readByNaam(artikel);
        
        return artikelen;
       
    }
    
    public boolean existsByNameArtikel (String naam) {
        ArtikelDaoFactory  artikelDaoFactory = new ArtikelDaoFactory ();
        ArtikelDAO artikelDao = artikelDaoFactory.getArtikelDao(getDatabase());
        Artikel artikel = new Artikel();
        artikel.setNaam(naam);
        boolean exists = artikelDao.existsByNaam(artikel);
        
        return exists;
       
   }
   

   
    
    // klant acties 
    
     public void createKlant(String voornaam, String achternaam, String tussenvoegsel, String telefoonnummer, String emailadres){
        KlantDaoFactory  klantDaoFactory = new KlantDaoFactory ();
        KlantDAO klantDao = klantDaoFactory.getKlantDao(getDatabase());
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
        KlantDaoFactory  klantDaoFactory = new KlantDaoFactory ();
        KlantDAO klantDao = klantDaoFactory.getKlantDao(getDatabase());
        Klant klant = new Klant();
        klant.setIdKlant(idKlant);
       
        klantDao.delete(klant);

    }
    
    
    public Klant readByIDKlant(int idKlant){
        
        KlantDaoFactory  klantDaoFactory = new KlantDaoFactory ();
        KlantDAO klantDao = klantDaoFactory.getKlantDao(getDatabase());
        Klant klant = new Klant();
        klant.setIdKlant(idKlant);
    
        Klant gevondenKlant = klantDao.readByIdKLant(klant);

        return gevondenKlant;
   
    }
    
    
    public boolean existsByIDKlant(int idKlant){
        
        KlantDaoFactory  klantDaoFactory = new KlantDaoFactory ();
        KlantDAO klantDao = klantDaoFactory.getKlantDao(getDatabase());
        Klant klant = new Klant();
        klant.setIdKlant(idKlant);
    
        boolean exists = klantDao.existsByIdKLant(klant);

        return exists;
   
    }
    
    public boolean existsBestellingByIdKlant (int idKlant){
        KlantDaoFactory  klantDaoFactory = new KlantDaoFactory ();
        KlantDAO klantDao = klantDaoFactory.getKlantDao(getDatabase());
        Klant klant = new Klant();
        klant.setIdKlant(idKlant);
        boolean exists = klantDao.existsBestellingByIdKlant(klant);
        return exists;
    }
    
    public boolean existsBestelArtikelByIdArtikel (int idArtikel){
        ArtikelDaoFactory  artikelDaoFactory = new ArtikelDaoFactory ();
        ArtikelDAO artikelDao = artikelDaoFactory.getArtikelDao(getDatabase());
        Set<Artikel> artikelen = artikelDao.readAll();
        Artikel artikel = new Artikel();
        artikel.setIdArtikel(idArtikel);
        boolean exists = artikelDao.existsBestelArtikelByIdArtikel(artikel);
        return exists;
    }
    
    public void updateKlant(int idKlant, String voornaam, String achternaam, String tussenvoegsel, String telefoonnummer, String emailadres) {
        
        KlantDaoFactory  klantDaoFactory = new KlantDaoFactory ();
        KlantDAO klantDao = klantDaoFactory.getKlantDao(getDatabase());
        Klant klant = new Klant();
        klant.setIdKlant(idKlant);
        klant.setVoornaam(voornaam);
        klant.setAchternaam(achternaam);
        klant.setTussenvoegsel(tussenvoegsel);
        klant.setTelefoonnummer(telefoonnummer);
        klant.setEmailadres(emailadres);
   
        klantDao.update(klant);
 
    }
    
    public Set<Klant> readAllKlant() {
        KlantDaoFactory  klantDaoFactory = new KlantDaoFactory ();
        KlantDAO klantDao = klantDaoFactory.getKlantDao(getDatabase());
        Set<Klant> klanten = klantDao.readAll();
       
        return klanten;


    }
    
    public Set<Klant> readByAchternaamKlant(String achternaam){
        
        KlantDaoFactory  klantDaoFactory = new KlantDaoFactory ();
        KlantDAO klantDao = klantDaoFactory.getKlantDao(getDatabase());
        Klant klant = new Klant();
        klant.setAchternaam(achternaam);
        Set<Klant> klanten = klantDao.readByAchternaamKlant(klant);
        
        return klanten;
     
    }
    
    public boolean existsByAchternaamKlant(String achternaam){
        
        KlantDaoFactory  klantDaoFactory = new KlantDaoFactory ();
        KlantDAO klantDao = klantDaoFactory.getKlantDao(getDatabase());
        Klant klant = new Klant();
        klant.setAchternaam(achternaam);
        boolean exists = klantDao.existsByAchternaamKlant(klant);
        
        return exists;
     
    }
    
    
    
    // bestelling acties
    
    
    
    public int createBestelling(int idKlant, int idAccount){
        BestellingDaoFactory  bestellingDaoFactory = new BestellingDaoFactory ();
        BestellingDAO bestellingDao = bestellingDaoFactory.getBestellingDao(getDatabase());
        Bestelling bestelling = new Bestelling();
        bestelling.setIdBestelling(0);
        bestelling.setIdKlant(idKlant);
        bestelling.setDatum_Bestelling(new Date());
        bestelling.setIdAccount(idAccount);
        
        int idBestelling = bestellingDao.create(bestelling);
      
        return idBestelling;
    }
    
    public void deleteBestelling(int idBestelling){
        BestellingDaoFactory  bestellingDaoFactory = new BestellingDaoFactory ();
        BestellingDAO bestellingDao = bestellingDaoFactory.getBestellingDao(getDatabase());
        Bestelling bestelling = new Bestelling();
        bestelling.setIdBestelling(idBestelling);
        
        bestellingDao.delete(bestelling);
    
    }
    
    public Bestelling readByIdBestelling(int idBestelling){
        
        BestellingDaoFactory  bestellingDaoFactory = new BestellingDaoFactory ();
        BestellingDAO bestellingDao = bestellingDaoFactory.getBestellingDao(getDatabase());
        Bestelling bestelling = new Bestelling();
        bestelling.setIdBestelling(idBestelling);
        Bestelling gevondenBestelling = bestellingDao.readByIdBestelling(bestelling);

        return gevondenBestelling;
     
    }
    
    
    public boolean existsByIdBestelling(int idBestelling){
        
        BestellingDaoFactory  bestellingDaoFactory = new BestellingDaoFactory ();
        BestellingDAO bestellingDao = bestellingDaoFactory.getBestellingDao(getDatabase());
        Bestelling bestelling = new Bestelling();
        bestelling.setIdBestelling(idBestelling);
        boolean exists = bestellingDao.existsByIdBestelling(bestelling);

        return exists;
     
    }
    
    
    
    public Set<Bestelling> readAllBestelling(){
        BestellingDaoFactory  bestellingDaoFactory = new BestellingDaoFactory ();
        BestellingDAO bestellingDao = bestellingDaoFactory.getBestellingDao(getDatabase());
        Set<Bestelling> bestellingen = bestellingDao.readAll();
       
        return bestellingen;
 
    }
    
    public Set<Bestelling> readByIdKlantBestelling(int idKlant){
        
        BestellingDaoFactory  bestellingDaoFactory = new BestellingDaoFactory ();
        BestellingDAO bestellingDao = bestellingDaoFactory.getBestellingDao(getDatabase());
        Bestelling bestelling = new Bestelling();
        bestelling.setIdKlant(idKlant);
        Set<Bestelling> bestellingen = bestellingDao.readByIdKlant(bestelling);
        
        return bestellingen;
    }
    
    public void updateBestelling(int idBestelling, int idKlant, int idAccount){
        BestellingDaoFactory  bestellingDaoFactory = new BestellingDaoFactory ();
        BestellingDAO bestellingDao = bestellingDaoFactory.getBestellingDao(getDatabase());
        Bestelling bestelling = new Bestelling();
        
        bestelling.setIdBestelling(idBestelling);
        bestelling.setIdKlant(idKlant);
        bestelling.setDatum_Bestelling(new Date());
        bestelling.setIdAccount(idAccount);

        bestellingDao.update(bestelling);

    }
    
    public void createBestelArtikel(int idBestelling, int idArtikel, int aantal){
        BestelArtikelDaofactory bestelArtikelDaoFactory = new BestelArtikelDaofactory ();
        BestelArtikelDAO bestelArtikelDao = bestelArtikelDaoFactory.getBestelArtikelDao(getDatabase());
        BestelArtikel bestelArtikel = new BestelArtikel();
        bestelArtikel.setIdBestelling(idBestelling);
        bestelArtikel.setIdArtikel(idArtikel);
        bestelArtikel.setAantal(aantal);
      
        bestelArtikelDao.create(bestelArtikel);

    }
    
    public void deleteBestelArtikel(int idBestelling, int idArtikel){
        BestelArtikelDaofactory bestelArtikelDaoFactory = new BestelArtikelDaofactory ();
        BestelArtikelDAO bestelArtikelDao = bestelArtikelDaoFactory.getBestelArtikelDao(getDatabase());

        BestelArtikel bestelArtikel = new BestelArtikel();
        bestelArtikel.setIdBestelling(idBestelling);
        bestelArtikel.setIdArtikel(idArtikel);
        
     
        bestelArtikelDao.delete(bestelArtikel);
  
    }
    
    public BestelArtikel readByIdBestellingIdArtikel(int idBestelling, int idArtikel){
        BestelArtikelDaofactory bestelArtikelDaoFactory = new BestelArtikelDaofactory ();
        BestelArtikelDAO bestelArtikelDao = bestelArtikelDaoFactory.getBestelArtikelDao(getDatabase());

        BestelArtikel bestelArtikel = new BestelArtikel();
        bestelArtikel.setIdBestelling(idBestelling);
        bestelArtikel.setIdArtikel(idArtikel);
        
        BestelArtikel gevondenBestelArtikel=bestelArtikelDao.readByIdBestellingIdArtikel(bestelArtikel);
        
        return gevondenBestelArtikel;
  
    }
    
    public boolean existsByIdBestellingIdArtikel(int idBestelling, int idArtikel){
        BestelArtikelDaofactory bestelArtikelDaoFactory = new BestelArtikelDaofactory ();
        BestelArtikelDAO bestelArtikelDao = bestelArtikelDaoFactory.getBestelArtikelDao(getDatabase());

        BestelArtikel bestelArtikel = new BestelArtikel();
        bestelArtikel.setIdBestelling(idBestelling);
        bestelArtikel.setIdArtikel(idArtikel);
        
        boolean exists=bestelArtikelDao.existsByIdBestellingIdArtikel(bestelArtikel);
        
        return exists;
  
    }
    
    public Set<BestelArtikel> readAllBestelArtikel(){
        BestelArtikelDaofactory bestelArtikelDaoFactory = new BestelArtikelDaofactory ();
        BestelArtikelDAO bestelArtikelDao = bestelArtikelDaoFactory.getBestelArtikelDao(getDatabase());

        Set<BestelArtikel> bestelArtikelen = bestelArtikelDao.readAll();

        return bestelArtikelen;
    }
    
    public Set<BestelArtikel> readByIdBestellingBestelArtikel(int idBestelling){
        BestelArtikelDaofactory bestelArtikelDaoFactory = new BestelArtikelDaofactory ();
        BestelArtikelDAO bestelArtikelDao = bestelArtikelDaoFactory.getBestelArtikelDao(getDatabase());

        BestelArtikel bestelArtikel = new BestelArtikel();
        bestelArtikel.setIdBestelling(idBestelling);
      
        Set<BestelArtikel> bestelArtikelen = bestelArtikelDao.readByIdBestelling(bestelArtikel);
       
        return bestelArtikelen;
   
    }
    
    public void updateBestelArtikel(int idBestelling, int idArtikel, int aantal){
        BestelArtikelDaofactory bestelArtikelDaoFactory = new BestelArtikelDaofactory ();
        BestelArtikelDAO bestelArtikelDao = bestelArtikelDaoFactory.getBestelArtikelDao(getDatabase());

        BestelArtikel bestelArtikel = new BestelArtikel();
        bestelArtikel.setIdBestelling(idBestelling);
        bestelArtikel.setIdArtikel(idArtikel);
        bestelArtikel.setAantal(aantal);
   
        bestelArtikelDao.update(bestelArtikel);
      
  
    }
    
    
    
    
 
    
    
    
}
