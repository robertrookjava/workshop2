/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.model;

import com.mycompany.mavenproject2.database.dao.ArtikelDAO;
import com.mycompany.mavenproject2.pojo.Artikel;
import java.math.BigDecimal;
import java.util.List;
import com.mycompany.mavenproject2.modelinterface.ArtikelModelInterface;
import org.springframework.stereotype.Component;

/**
 *
 * @author robertrook
 */
@Component
public class ArtikelModel implements ArtikelModelInterface{
    
     @Override
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
    
     @Override
    public void deleteArtikel (int idArtikel){
        boolean exists = existsByIdArtikel (idArtikel);
        if (exists){
      
            ArtikelDAO artikelDao = new ArtikelDAO();
            Artikel artikel = new Artikel();
            artikel.setIdArtikel(idArtikel);
      
            artikelDao.delete(artikel);
        }
        
    }
    
     @Override
    public Artikel readByIdArtikel (int idArtikel){
        
        ArtikelDAO artikelDao = new ArtikelDAO();
        Artikel artikel = new Artikel();
        artikel.setIdArtikel(idArtikel);
        Artikel gevondenArtikel = artikelDao.read(artikel);
  
        return gevondenArtikel;
    }
    
     @Override
    public boolean existsByIdArtikel (int idArtikel){
       
        ArtikelDAO artikelDao = new ArtikelDAO();
        Artikel artikel = new Artikel();
        artikel.setIdArtikel(idArtikel);
        boolean exists = artikelDao.existsByIdArtikel(artikel);
  
        return exists;
   }
    
   
    
   
     @Override
    public void updateArtikel(int idArtikel, String naam, BigDecimal prijs, int voorraad){
       
        ArtikelDAO artikelDao = new ArtikelDAO();
        Artikel artikel = new Artikel();
        artikel.setIdArtikel(idArtikel);
        artikel.setNaam(naam);
        artikel.setPrijs(prijs);
        artikel.setVoorraad(voorraad);

        artikelDao.update(artikel);
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

        
        ArtikelDAO artikelDao = new ArtikelDAO();
        List<Artikel> artikelen = artikelDao.readAll();
       
        return artikelen;
   }

   
     @Override
    public List<Artikel> readByNameArtikel (String naam) {
        
        ArtikelDAO artikelDao = new ArtikelDAO();
        Artikel artikel = new Artikel();
        artikel.setNaam(naam);
        List<Artikel> artikelen = artikelDao.readByNaam(artikel);
        
        return artikelen;
       
    }
    
     @Override
    public boolean existsByNameArtikel (String naam) {
        
        ArtikelDAO artikelDao = new ArtikelDAO();
        Artikel artikel = new Artikel();
        artikel.setNaam(naam);
        boolean exists = artikelDao.existsByNaam(artikel);
        
        return exists;
       
    }
    
}
