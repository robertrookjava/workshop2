/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.model;

import com.mycompany.mavenproject2.database.dao.BestelArtikelDAO;
import com.mycompany.mavenproject2.pojo.BestelArtikel;
import java.util.List;
import com.mycompany.mavenproject2.modelinterface.BestelArtikelModelInterface;
import org.springframework.stereotype.Component;

/**
 *
 * @author robertrook
 */
@Component
public class BestelArtikelModel implements BestelArtikelModelInterface {
    
    @Override
    public void createBestelArtikel(int idBestelling, int idArtikel, int aantal){
       
        BestelArtikelDAO bestelArtikelDao = new BestelArtikelDAO();
        BestelArtikel bestelArtikel = new BestelArtikel();
        bestelArtikel.setIdBestelling(idBestelling);
        bestelArtikel.setIdArtikel(idArtikel);
        bestelArtikel.setAantal(aantal);
      
        bestelArtikelDao.create(bestelArtikel);

    }
    
    @Override
    public void deleteBestelArtikel(int idBestelling, int idArtikel){
       
        BestelArtikelDAO bestelArtikelDao = new BestelArtikelDAO();

        BestelArtikel bestelArtikel = new BestelArtikel();
        bestelArtikel.setIdBestelling(idBestelling);
        bestelArtikel.setIdArtikel(idArtikel);
        
     
        bestelArtikelDao.delete(bestelArtikel);
  
    }
    
    @Override
    public BestelArtikel readByIdBestellingIdArtikel(int idBestelling, int idArtikel){
        
        BestelArtikelDAO bestelArtikelDao = new BestelArtikelDAO();

        BestelArtikel bestelArtikel = new BestelArtikel();
        bestelArtikel.setIdBestelling(idBestelling);
        bestelArtikel.setIdArtikel(idArtikel);
        
        BestelArtikel gevondenBestelArtikel=bestelArtikelDao.read(bestelArtikel);
        
        return gevondenBestelArtikel;
  
    }
    
    @Override
    public boolean existsByIdBestellingIdArtikel(int idBestelling, int idArtikel){
        
        BestelArtikelDAO bestelArtikelDao = new BestelArtikelDAO();

        BestelArtikel bestelArtikel = new BestelArtikel();
        bestelArtikel.setIdBestelling(idBestelling);
        bestelArtikel.setIdArtikel(idArtikel);
        
        boolean exists=bestelArtikelDao.existsByIdBestellingIdArtikel(bestelArtikel);
        
        return exists;
  
    }
    
    @Override
    public List<BestelArtikel> readAllBestelArtikel(){
       
        BestelArtikelDAO bestelArtikelDao = new BestelArtikelDAO();

        List<BestelArtikel> bestelArtikelen = bestelArtikelDao.readAll();

        return bestelArtikelen;
    }
    
    @Override
    public List<BestelArtikel> readByIdBestellingBestelArtikel(int idBestelling){
        
        BestelArtikelDAO bestelArtikelDao = new BestelArtikelDAO();

        BestelArtikel bestelArtikel = new BestelArtikel();
        bestelArtikel.setIdBestelling(idBestelling);
      
        List<BestelArtikel> bestelArtikelen = bestelArtikelDao.readByIdBestelling(bestelArtikel);
       
        return bestelArtikelen;
   
    }
    
    @Override
    public void updateBestelArtikel(int idBestelling, int idArtikel, int aantal){
      
        BestelArtikelDAO bestelArtikelDao = new BestelArtikelDAO();

        BestelArtikel bestelArtikel = new BestelArtikel();
        bestelArtikel.setIdBestelling(idBestelling);
        bestelArtikel.setIdArtikel(idArtikel);
        bestelArtikel.setAantal(aantal);
   
        bestelArtikelDao.update(bestelArtikel);
      
  
    }
    
}
