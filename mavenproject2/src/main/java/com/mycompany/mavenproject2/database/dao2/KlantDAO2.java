/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.database.dao2;

import com.mycompany.mavenproject2.model.Bestelling;
import com.mycompany.mavenproject2.model.Klant;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author robertrook
 */
public class KlantDAO2 {
    
    public void create(Klant klant){
        
    }
    
     public void delete(Klant klant){
         
     }
     
      public Klant readByIdKLant (Klant klant){
          
          Klant gevondenKlant = new Klant();
          
          return gevondenKlant;
      }
      
       public Boolean existsByIdKLant (Klant klant){
           boolean exists = false;
           
           return exists;
       }
       
        public Set<Bestelling> readByIdKlant(Klant klant){
            Set<Bestelling> bestellingen = new HashSet<>();
            
            return bestellingen;
        }
        
         public boolean existsBestellingByIdKlant(Klant klant){
             boolean exists = false;
             
             return exists;
         }
         
         public Set<Klant> readAll(){
             Set<Klant> klanten = new HashSet<>();
             
             return klanten;
         }
         
         public Set<Klant> readByAchternaamKlant(Klant klant){
             Set<Klant> klanten = new HashSet<>();
             
             return klanten;
         }
         
         public boolean existsByAchternaamKlant(Klant klant){
             boolean exists = false;
             
             return exists;
         }
         
          public void update(Klant klant){
              
          }
       
         
    
}
