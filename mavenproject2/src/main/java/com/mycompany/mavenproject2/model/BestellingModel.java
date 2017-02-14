/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.model;

import com.mycompany.mavenproject2.database.dao.BestellingDAO;
import com.mycompany.mavenproject2.database.daointerface.BestellingDAOInterface;
import com.mycompany.mavenproject2.pojo.Bestelling;
import java.util.Date;
import java.util.List;
import com.mycompany.mavenproject2.modelinterface.BestellingModelInterface;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author robertrook
 */
@Component
public class BestellingModel implements BestellingModelInterface {
    
    @Autowired
    private BestellingDAOInterface bestellingDAOInterface;
    
    @Override
    public void setBestellingDAOInterface(BestellingDAOInterface bestellingDAOInterface) {
       this.bestellingDAOInterface = bestellingDAOInterface;
    }

    @Override
    public BestellingDAOInterface getBestellingDAOInterface() {
        return this.bestellingDAOInterface;
    }
    
    @Override
    public int createBestelling(int idKlant, int idAccount){
       
        
        Bestelling bestelling = new Bestelling();
        bestelling.setIdBestelling(0);
        bestelling.setIdKlant(idKlant);
        bestelling.setDatum_Bestelling(new Date());
        bestelling.setIdAccount(idAccount);
        
        int idBestelling = bestellingDAOInterface.create(bestelling);
      
        return idBestelling;
    }
    
    @Override
    public void deleteBestelling(int idBestelling){
        
        
        Bestelling bestelling = new Bestelling();
        bestelling.setIdBestelling(idBestelling);
        
        bestellingDAOInterface.delete(bestelling);
    
    }
    
    @Override
    public Bestelling readByIdBestelling(int idBestelling){
        
        
        
        Bestelling bestelling = new Bestelling();
        bestelling.setIdBestelling(idBestelling);
        Bestelling gevondenBestelling = bestellingDAOInterface.read(bestelling);

        return gevondenBestelling;
     
    }
    
    
    @Override
    public boolean existsByIdBestelling(int idBestelling){
        
        
        
        Bestelling bestelling = new Bestelling();
        bestelling.setIdBestelling(idBestelling);
        boolean exists = bestellingDAOInterface.existsByIdBestelling(bestelling);

        return exists;
     
    }
    
    
    
    @Override
    public List<Bestelling> readAllBestelling(){
        
        
        List<Bestelling> bestellingen = bestellingDAOInterface.readAll();
       
        return bestellingen;
 
    }
    
    @Override
    public List<Bestelling> readByIdKlantBestelling(int idKlant){
        
        
        
        Bestelling bestelling = new Bestelling();
        bestelling.setIdKlant(idKlant);
        List<Bestelling> bestellingen = bestellingDAOInterface.readByIdKlant(bestelling);
        
        return bestellingen;
    }
    
    @Override
    public void updateBestelling(int idBestelling, int idKlant, int idAccount){
        
        
        Bestelling bestelling = new Bestelling();
        
        bestelling.setIdBestelling(idBestelling);
        bestelling.setIdKlant(idKlant);
        bestelling.setDatum_Bestelling(new Date());
        bestelling.setIdAccount(idAccount);

        bestellingDAOInterface.update(bestelling);

    }

    
    
}
