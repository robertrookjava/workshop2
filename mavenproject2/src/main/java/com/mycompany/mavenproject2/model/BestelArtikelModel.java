/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.model;

import com.mycompany.mavenproject2.database.dao.BestelArtikelDAO;
import com.mycompany.mavenproject2.database.daointerface.BestelArtikelDAOInterface;
import com.mycompany.mavenproject2.pojo.BestelArtikel;
import java.util.List;
import com.mycompany.mavenproject2.modelinterface.BestelArtikelModelInterface;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author robertrook
 */
@Component
public class BestelArtikelModel implements BestelArtikelModelInterface {
    
    @Autowired
    private BestelArtikelDAOInterface bestelArtikelDAOInterface;
    
     @Override
    public void setBestelArtikelDAOInterface(BestelArtikelDAOInterface bestelArtikelDAOInterface) {
        this.bestelArtikelDAOInterface = bestelArtikelDAOInterface;
    }

    @Override
    public BestelArtikelDAOInterface getBestelArtikelDAOInterface() {
        return this.bestelArtikelDAOInterface;
    }
    
    
    @Override
    public void createBestelArtikel(int idBestelling, int idArtikel, int aantal){
       
       
        BestelArtikel bestelArtikel = new BestelArtikel();
        bestelArtikel.setIdBestelling(idBestelling);
        bestelArtikel.setIdArtikel(idArtikel);
        bestelArtikel.setAantal(aantal);
      
        bestelArtikelDAOInterface.create(bestelArtikel);

    }
    
    @Override
    public void deleteBestelArtikel(int idBestelling, int idArtikel){
       
        BestelArtikelDAO bestelArtikelDao = new BestelArtikelDAO();

        BestelArtikel bestelArtikel = new BestelArtikel();
        bestelArtikel.setIdBestelling(idBestelling);
        bestelArtikel.setIdArtikel(idArtikel);
        
     
        bestelArtikelDAOInterface.delete(bestelArtikel);
  
    }
    
    @Override
    public BestelArtikel readByIdBestellingIdArtikel(int idBestelling, int idArtikel){
        
        

        BestelArtikel bestelArtikel = new BestelArtikel();
        bestelArtikel.setIdBestelling(idBestelling);
        bestelArtikel.setIdArtikel(idArtikel);
        
        BestelArtikel gevondenBestelArtikel=bestelArtikelDAOInterface.read(bestelArtikel);
        
        return gevondenBestelArtikel;
  
    }
    
    @Override
    public boolean existsByIdBestellingIdArtikel(int idBestelling, int idArtikel){
        
        

        BestelArtikel bestelArtikel = new BestelArtikel();
        bestelArtikel.setIdBestelling(idBestelling);
        bestelArtikel.setIdArtikel(idArtikel);
        
        boolean exists=bestelArtikelDAOInterface.existsByIdBestellingIdArtikel(bestelArtikel);
        
        return exists;
  
    }
    
    @Override
    public List<BestelArtikel> readAllBestelArtikel(){
       
        

        List<BestelArtikel> bestelArtikelen = bestelArtikelDAOInterface.readAll();

        return bestelArtikelen;
    }
    
    @Override
    public List<BestelArtikel> readByIdBestellingBestelArtikel(int idBestelling){
        
        

        BestelArtikel bestelArtikel = new BestelArtikel();
        bestelArtikel.setIdBestelling(idBestelling);
      
        List<BestelArtikel> bestelArtikelen = bestelArtikelDAOInterface.readByIdBestelling(bestelArtikel);
       
        return bestelArtikelen;
   
    }
    
    @Override
    public void updateBestelArtikel(int idBestelling, int idArtikel, int aantal){
      
        

        BestelArtikel bestelArtikel = new BestelArtikel();
        bestelArtikel.setIdBestelling(idBestelling);
        bestelArtikel.setIdArtikel(idArtikel);
        bestelArtikel.setAantal(aantal);
   
        bestelArtikelDAOInterface.update(bestelArtikel);
      
  
    }

   
}
