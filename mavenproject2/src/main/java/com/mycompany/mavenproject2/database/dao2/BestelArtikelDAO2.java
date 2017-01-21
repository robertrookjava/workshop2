/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.database.dao2;

import com.mycompany.mavenproject2.model.BestelArtikel;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author robertrook
 */
public class BestelArtikelDAO2 {
    
     public void create(BestelArtikel bestelArtikel){
         
     }
     
     public void delete(BestelArtikel bestelArtikel){
         
     }
     
      public BestelArtikel readByIdBestellingIdArtikel (BestelArtikel bestelArtikel) {
          BestelArtikel gevondenBestelArtikel = new BestelArtikel();
          
           return gevondenBestelArtikel;
      }
      
      public boolean existsByIdBestellingIdArtikel (BestelArtikel bestelArtikel) {
          
          boolean exists = false;
          
          return exists;
      }
      
       public Set<BestelArtikel> readAll()   {
           Set<BestelArtikel> bestelArtikelen = new HashSet<>();
           
           return bestelArtikelen;
       }
       
       public Set<BestelArtikel> readByIdBestelling (BestelArtikel bestelArtikel)  {
           Set<BestelArtikel> bestelArtikelen = new HashSet<>();
           
           return bestelArtikelen;
       }
       
        public void update(BestelArtikel bestelArtikel){
            
        }
    
}
