/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.model;

import com.mycompany.mavenproject2.database.dao.ArtikelDAO;
import com.mycompany.mavenproject2.database.dao.KlantDAO;
import com.mycompany.mavenproject2.database.daointerface.KlantDAOInterface;
import com.mycompany.mavenproject2.database.daointerface.ArtikelDAOInterface;
import com.mycompany.mavenproject2.pojo.Artikel;
import com.mycompany.mavenproject2.pojo.Klant;
import java.util.List;
import com.mycompany.mavenproject2.modelinterface.KlantModelInterface;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author robertrook
 */
@Component
public class KlantModel implements KlantModelInterface {
    
    @Autowired
    private KlantDAOInterface klantDAOInterface;
    
    private ArtikelDAOInterface artikelDAOInterface;
    
    @Override
    public void setKlantDAOInterface(KlantDAOInterface klantDAOInterface) {
        this.klantDAOInterface=klantDAOInterface;
    }

    @Override
    public KlantDAOInterface getKlantDAOInterface() {
        return this.klantDAOInterface;
    }
    
    @Override
    public void createKlant(String voornaam, String achternaam, String tussenvoegsel, String telefoonnummer, String emailadres){
        
    
        Klant klant = new Klant();
       
        
        klant.setIdKlant(0);
        klant.setVoornaam(voornaam);
        klant.setAchternaam(achternaam);
        klant.setTussenvoegsel(tussenvoegsel);
        klant.setTelefoonnummer(telefoonnummer);
        klant.setEmailadres(emailadres);

        klantDAOInterface.create(klant);

    }
      
    @Override
    public void deleteKlant(int idKlant) {
        
        boolean exists = existsByIDKlant(idKlant);
        
        if (exists){
        
            
            Klant klant = new Klant();
            klant.setIdKlant(idKlant);
            klantDAOInterface.delete(klant);
        }

    }
    
    
    @Override
    public Klant readByIDKlant(int idKlant){
        
        
        
        Klant klant = new Klant();
        klant.setIdKlant(idKlant);
    
        Klant gevondenKlant = klantDAOInterface.read(klant);

        return gevondenKlant;
   
    }
    
    
    @Override
    public boolean existsByIDKlant(int idKlant){
        
        
    
        Klant klant = new Klant();
        klant.setIdKlant(idKlant);
    
        boolean exists = klantDAOInterface.existsByIdKLant(klant);

        return exists;
   
    }
    
    @Override
    public boolean existsBestellingByIdKlant (int idKlant){
       
        
        Klant klant = new Klant();
        klant.setIdKlant(idKlant);
        boolean exists = klantDAOInterface.existsBestellingByIdKlant(klant);
        return exists;
    }
    
    @Override
    public boolean existsBestelArtikelByIdArtikel (int idArtikel){
       
      
        List<Artikel> artikelen = artikelDAOInterface.readAll();
        Artikel artikel = new Artikel();
        artikel.setIdArtikel(idArtikel);
        boolean exists = artikelDAOInterface.existsBestelArtikelByIdArtikel(artikel);
        return exists;
    }
    
    @Override
    public void updateKlant(int idKlant, String voornaam, String achternaam, String tussenvoegsel, String telefoonnummer, String emailadres) {
        
        
    
        Klant klant = new Klant();
        klant.setIdKlant(idKlant);
        klant.setVoornaam(voornaam);
        klant.setAchternaam(achternaam);
        klant.setTussenvoegsel(tussenvoegsel);
        klant.setTelefoonnummer(telefoonnummer);
        klant.setEmailadres(emailadres);
   
        klantDAOInterface.update(klant);
 
    }
    
    @Override
    public List<Klant> readAllKlant() {
        
        
        List<Klant> klanten = klantDAOInterface.readAll();
       
        return klanten;


    }
    
    @Override
    public List<Klant> readByAchternaamKlant(String achternaam){
        
        
        KlantDAO klantDao = new KlantDAO();
        Klant klant = new Klant();
        klant.setAchternaam(achternaam);
        List<Klant> klanten = klantDAOInterface.readByAchternaamKlant(klant);
        
        return klanten;
     
    }
    
    @Override
    public boolean existsByAchternaamKlant(String achternaam){
        
        
        KlantDAO klantDao = new KlantDAO();
        Klant klant = new Klant();
        klant.setAchternaam(achternaam);
        boolean exists = klantDAOInterface.existsByAchternaamKlant(klant);
        
        return exists;
     
    }

    
    
    
}
