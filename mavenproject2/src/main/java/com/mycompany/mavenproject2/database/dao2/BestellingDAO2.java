/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.database.dao2;

import com.mycompany.mavenproject2.model.Bestelling;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author robertrook
 */
public class BestellingDAO2 {
    
    public int create(Bestelling bestelling)   { // geeft de idBestelling (auto increment) terug
        int idBestelling = 0;
        
        return idBestelling;
    }
    
    public void delete(Bestelling bestelling){
   
    }
    
    
    public Bestelling readByIdBestelling (Bestelling bestelling)  {
        Bestelling gevondenBestelling = new Bestelling();
        
        return gevondenBestelling;
    }
    
    public boolean existsByIdBestelling (Bestelling bestelling){
        boolean exists = false;
        
        return exists;
    }
    
    public Set<Bestelling> readAll()   {
        Set<Bestelling> bestellingen = new HashSet<>();
        
        return bestellingen;
    }
    
     public Set<Bestelling> readByIdKlant(Bestelling bestelling)  {
         Set<Bestelling> bestellingen = new HashSet<>();
         
         return bestellingen;
     }
     
     public boolean existsByIdKlant(Bestelling bestelling)  {
          boolean exists = false;
          
          return exists;
     }
     
      public void update(Bestelling bestelling){
          
      }
    
    
    
}
