/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.model;

import com.mycompany.mavenproject2.database.dao2.BestellingDAO2;
import com.mycompany.mavenproject2.database.dao2.BestelArtikelDAO2;
import com.mycompany.mavenproject2.database.dao2.ArtikelDAO2;
import com.mycompany.mavenproject2.database.dao2.KlantDAO2;
import com.mycompany.mavenproject2.database.dao2.AccountDAO2;
import com.mycompany.mavenproject2.database.dao2.AccounttypeDAO2;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import com.mycompany.mavenproject2.database.Database;

/**
 *
 * @author robertrook
 */
public class Model2 {
    
    // artikel acties =>
    
    public void createArtikel(String naam, BigDecimal prijs, int voorraad){ 
       
        ArtikelDAO2 artikelDao = new ArtikelDAO2();
       
        Artikel artikel = new Artikel();
        artikel.setIdArtikel(0);
        artikel.setNaam(naam);
        artikel.setPrijs(prijs);
        artikel.setVoorraad(voorraad);
        
        artikelDao.create(artikel);
    }
    
    public void deleteArtikel (int idArtikel){
      
        ArtikelDAO2 artikelDao = new ArtikelDAO2();
        Artikel artikel = new Artikel();
        artikel.setIdArtikel(idArtikel);
      
        artikelDao.delete(artikel);
        
    }
    
    public Artikel readByIdArtikel (int idArtikel){
        
        ArtikelDAO2 artikelDao = new ArtikelDAO2();
        Artikel artikel = new Artikel();
        artikel.setIdArtikel(idArtikel);
        Artikel gevondenArtikel = artikelDao.readByIdArtikel(artikel);
  
        return gevondenArtikel;
    }
    
    public boolean existsByIdArtikel (int idArtikel){
       
        ArtikelDAO2 artikelDao = new ArtikelDAO2();
        Artikel artikel = new Artikel();
        artikel.setIdArtikel(idArtikel);
        boolean exists = artikelDao.existsByIdArtikel(artikel);
  
        return exists;
   }
    
   
    
   
    public void updateArtikel(int idArtikel, String naam, BigDecimal prijs, int voorraad){
       
        ArtikelDAO2 artikelDao = new ArtikelDAO2();
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

        
        ArtikelDAO2 artikelDao = new ArtikelDAO2();
        Set<Artikel> artikelen = artikelDao.readAll();
       
        return artikelen;
   }

   
    public Set <Artikel> readByNameArtikel (String naam) {
        
        ArtikelDAO2 artikelDao = new ArtikelDAO2();
        Artikel artikel = new Artikel();
        artikel.setNaam(naam);
        Set<Artikel> artikelen = artikelDao.readByNaam(artikel);
        
        return artikelen;
       
    }
    
    public boolean existsByNameArtikel (String naam) {
        
        ArtikelDAO2 artikelDao = new ArtikelDAO2();
        Artikel artikel = new Artikel();
        artikel.setNaam(naam);
        boolean exists = artikelDao.existsByNaam(artikel);
        
        return exists;
       
   }
   

   
    // artikel acties <=
    
    
}
