/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.model;

import com.mycompany.mavenproject2.database.dao.ArtikelDAO;
import com.mycompany.mavenproject2.database.dao.KlantDAO;
import com.mycompany.mavenproject2.pojo.Artikel;
import com.mycompany.mavenproject2.pojo.Klant;
import java.util.List;
import com.mycompany.mavenproject2.modelinterface.KlantModelInterface;
import org.springframework.stereotype.Component;

/**
 *
 * @author robertrook
 */
@Component
public class KlantModel implements KlantModelInterface {
    
    @Override
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
      
    @Override
    public void deleteKlant(int idKlant) {
        
        boolean exists = existsByIDKlant(idKlant);
        
        if (exists){
        
            KlantDAO klantDao = new KlantDAO();
            Klant klant = new Klant();
            klant.setIdKlant(idKlant);
            klantDao.delete(klant);
        }

    }
    
    
    @Override
    public Klant readByIDKlant(int idKlant){
        
        
        KlantDAO klantDao = new KlantDAO();
        Klant klant = new Klant();
        klant.setIdKlant(idKlant);
    
        Klant gevondenKlant = klantDao.read(klant);

        return gevondenKlant;
   
    }
    
    
    @Override
    public boolean existsByIDKlant(int idKlant){
        
        
        KlantDAO klantDao = new KlantDAO();
        Klant klant = new Klant();
        klant.setIdKlant(idKlant);
    
        boolean exists = klantDao.existsByIdKLant(klant);

        return exists;
   
    }
    
    @Override
    public boolean existsBestellingByIdKlant (int idKlant){
       
        KlantDAO klantDao = new KlantDAO();
        Klant klant = new Klant();
        klant.setIdKlant(idKlant);
        boolean exists = klantDao.existsBestellingByIdKlant(klant);
        return exists;
    }
    
    @Override
    public boolean existsBestelArtikelByIdArtikel (int idArtikel){
       
        ArtikelDAO artikelDao = new ArtikelDAO();
        List<Artikel> artikelen = artikelDao.readAll();
        Artikel artikel = new Artikel();
        artikel.setIdArtikel(idArtikel);
        boolean exists = artikelDao.existsBestelArtikelByIdArtikel(artikel);
        return exists;
    }
    
    @Override
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
    
    @Override
    public List<Klant> readAllKlant() {
        
        KlantDAO klantDao = new KlantDAO();
        List<Klant> klanten = klantDao.readAll();
       
        return klanten;


    }
    
    @Override
    public List<Klant> readByAchternaamKlant(String achternaam){
        
        
        KlantDAO klantDao = new KlantDAO();
        Klant klant = new Klant();
        klant.setAchternaam(achternaam);
        List<Klant> klanten = klantDao.readByAchternaamKlant(klant);
        
        return klanten;
     
    }
    
    @Override
    public boolean existsByAchternaamKlant(String achternaam){
        
        
        KlantDAO klantDao = new KlantDAO();
        Klant klant = new Klant();
        klant.setAchternaam(achternaam);
        boolean exists = klantDao.existsByAchternaamKlant(klant);
        
        return exists;
     
    }
    
    
    
}
