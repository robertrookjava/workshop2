/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.model;

import com.mycompany.mavenproject2.database.dao.BestellingDAO;
import com.mycompany.mavenproject2.pojo.Bestelling;
import java.util.Date;
import java.util.List;
import com.mycompany.mavenproject2.modelinterface.BestellingModelInterface;
import org.springframework.stereotype.Component;

/**
 *
 * @author robertrook
 */
@Component
public class BestellingModel implements BestellingModelInterface {
    
    @Override
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
    
    @Override
    public void deleteBestelling(int idBestelling){
        
        BestellingDAO bestellingDao = new BestellingDAO();
        Bestelling bestelling = new Bestelling();
        bestelling.setIdBestelling(idBestelling);
        
        bestellingDao.delete(bestelling);
    
    }
    
    @Override
    public Bestelling readByIdBestelling(int idBestelling){
        
        
        BestellingDAO bestellingDao = new BestellingDAO();
        Bestelling bestelling = new Bestelling();
        bestelling.setIdBestelling(idBestelling);
        Bestelling gevondenBestelling = bestellingDao.read(bestelling);

        return gevondenBestelling;
     
    }
    
    
    @Override
    public boolean existsByIdBestelling(int idBestelling){
        
        
        BestellingDAO bestellingDao = new BestellingDAO();
        Bestelling bestelling = new Bestelling();
        bestelling.setIdBestelling(idBestelling);
        boolean exists = bestellingDao.existsByIdBestelling(bestelling);

        return exists;
     
    }
    
    
    
    @Override
    public List<Bestelling> readAllBestelling(){
        
        BestellingDAO bestellingDao = new BestellingDAO();
        List<Bestelling> bestellingen = bestellingDao.readAll();
       
        return bestellingen;
 
    }
    
    @Override
    public List<Bestelling> readByIdKlantBestelling(int idKlant){
        
        
        BestellingDAO bestellingDao = new BestellingDAO();
        Bestelling bestelling = new Bestelling();
        bestelling.setIdKlant(idKlant);
        List<Bestelling> bestellingen = bestellingDao.readByIdKlant(bestelling);
        
        return bestellingen;
    }
    
    @Override
    public void updateBestelling(int idBestelling, int idKlant, int idAccount){
        
        BestellingDAO bestellingDao = new BestellingDAO();
        Bestelling bestelling = new Bestelling();
        
        bestelling.setIdBestelling(idBestelling);
        bestelling.setIdKlant(idKlant);
        bestelling.setDatum_Bestelling(new Date());
        bestelling.setIdAccount(idAccount);

        bestellingDao.update(bestelling);

    }
    
}
