/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.model;

import com.mycompany.mavenproject2.database.dao.ArtikelDAO;
import com.mycompany.mavenproject2.database.daointerface.ArtikelDAOInterface;
import com.mycompany.mavenproject2.pojo.Artikel;
import java.math.BigDecimal;
import java.util.List;
import com.mycompany.mavenproject2.modelinterface.ArtikelModelInterface;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author robertrook
 */
@Component
public class ArtikelModel implements ArtikelModelInterface{
    
    @Autowired
    private ArtikelDAOInterface artikelDAOInterface;
    
    @Override
    public void setArtikelDAOInterface(ArtikelDAOInterface artikelDAOInterface) {
        this.artikelDAOInterface = artikelDAOInterface;
    }

    @Override
    public ArtikelDAOInterface getArtikelDAOInterface() {
       return this.artikelDAOInterface;
    }
    
     @Override
     public void createArtikel(String naam, BigDecimal prijs, int voorraad){ 
       
        
       
        Artikel artikel = new Artikel();
        artikel.setIdArtikel(0);
        artikel.setNaam(naam);
        artikel.setPrijs(prijs);
        artikel.setVoorraad(voorraad);
        
        artikelDAOInterface.create(artikel);
        //System.out.println("Robert1 "+artikel.getIdArtikel());
    }
    
     @Override
    public void deleteArtikel (int idArtikel){
        boolean exists = existsByIdArtikel (idArtikel);
        if (exists){
      
            
            Artikel artikel = new Artikel();
            artikel.setIdArtikel(idArtikel);
      
            artikelDAOInterface.delete(artikel);
        }
        
    }
    
     @Override
    public Artikel readByIdArtikel (int idArtikel){
        
        
        Artikel artikel = new Artikel();
        artikel.setIdArtikel(idArtikel);
        Artikel gevondenArtikel = artikelDAOInterface.read(artikel);
  
        return gevondenArtikel;
    }
    
     @Override
    public boolean existsByIdArtikel (int idArtikel){
       
        
        Artikel artikel = new Artikel();
        artikel.setIdArtikel(idArtikel);
        boolean exists = artikelDAOInterface.existsByIdArtikel(artikel);
  
        return exists;
   }
    
   
    
   
     @Override
    public void updateArtikel(int idArtikel, String naam, BigDecimal prijs, int voorraad){
       
        
        Artikel artikel = new Artikel();
        artikel.setIdArtikel(idArtikel);
        artikel.setNaam(naam);
        artikel.setPrijs(prijs);
        artikel.setVoorraad(voorraad);

        artikelDAOInterface.update(artikel);
    }
    
     @Override
   public void updateVoorraadArtikel (int idArtikel, int voorraad){
       boolean exists = existsByIdArtikel(idArtikel);
       if (exists) {
           Artikel artikel = readByIdArtikel (idArtikel);
           updateArtikel(idArtikel,artikel.getNaam(),artikel.getPrijs(),voorraad );
          }
       
   }
   
     @Override
   public void verlaagVoorraadArtikel (int idArtikel, int aantal){
       boolean exists = existsByIdArtikel(idArtikel);
       if (exists) {
           Artikel artikel = readByIdArtikel (idArtikel);
           updateArtikel(idArtikel,artikel.getNaam(),artikel.getPrijs(),artikel.getVoorraad()-aantal );
          }
       
   }
   
     @Override
   public void verhoogVoorraadArtikel (int idArtikel, int aantal){
       boolean exists = existsByIdArtikel(idArtikel);
       if (exists) {
           Artikel artikel = readByIdArtikel (idArtikel);
           updateArtikel(idArtikel,artikel.getNaam(),artikel.getPrijs(),artikel.getVoorraad()+aantal );
          }
       
   }
   
   
    
     @Override
    public List<Artikel> readAllArtikel () {

        
        
        List<Artikel> artikelen = artikelDAOInterface.readAll();
       
        return artikelen;
   }

   
     @Override
    public List<Artikel> readByNameArtikel (String naam) {
        
        
        Artikel artikel = new Artikel();
        artikel.setNaam(naam);
        List<Artikel> artikelen = artikelDAOInterface.readByNaam(artikel);
        
        return artikelen;
       
    }
    
     @Override
    public boolean existsByNameArtikel (String naam) {
        
        
        Artikel artikel = new Artikel();
        artikel.setNaam(naam);
        boolean exists = artikelDAOInterface.existsByNaam(artikel);
        
        return exists;
       
    }

    
    
}
