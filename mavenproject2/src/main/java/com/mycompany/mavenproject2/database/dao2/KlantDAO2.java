/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.database.dao2;

import com.mycompany.mavenproject2.Util.EntityManagerUtil;
import com.mycompany.mavenproject2.model.Bestelling;
import com.mycompany.mavenproject2.model.Klant;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author robertrook
 */
public class KlantDAO2 {
    
    public void create(Klant klant){
        EntityManager entityManager = null;
        
        try{
            
            entityManager=EntityManagerUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(klant);
            entityManager.getTransaction().commit();
                       
        }
        catch (Exception e){
            e.printStackTrace();
        }        
        
    }
    
    public void delete(Klant klant){
        EntityManager entityManager = null;
        
        int idKlant = klant.getIdKlant();
 
        
        try {
            
            entityManager= EntityManagerUtil.getEntityManager();
            entityManager.getTransaction().begin();
            Klant gevondenKlant = (Klant)entityManager.find(Klant.class, idKlant);
            entityManager.remove(gevondenKlant);
            entityManager.getTransaction().commit();
            
            
        }catch (Exception e){
            e.printStackTrace();
        }        
         
    }
     
    public Klant readByIdKLant (Klant klant){
          
        Klant gevondenKlant = new Klant();
        
        EntityManager entityManager;
        
        
        try{
            entityManager = EntityManagerUtil.getEntityManager();
            gevondenKlant = (Klant)entityManager.find(Klant.class, klant.getIdKlant());
           
            
        }catch(Exception e){
            e.printStackTrace();
        }                
        return gevondenKlant;
    }
      
    public Boolean existsByIdKLant (Klant klant){
        boolean exists = false;
        
        
        Klant gevondenKlant = readByIdKLant (klant);
        exists = (gevondenKlant != null);
        return exists;
           
        
    }
       
    public Set<Bestelling> readByIdKlant(Klant klant){
        Set<Bestelling> bestellingen = new HashSet<>();
        int id = klant.getIdKlant();
        EntityManager entityManager;
        
        try{
            entityManager = EntityManagerUtil.getEntityManager();
            // String query = "SELECT * FROM Bestelling WHERE idKlant = ?";
            Query query = entityManager.createQuery("SELECT b FROM Bestelling b WHERE b.idKlant = :param");
            query.setParameter("param", id);
            bestellingen = (Set<Bestelling>) query.getResultList();
           // notFound = query.setMaxResults(1).getResultList().isEmpty();
           // exists = !notFound;
            
            
        }catch(Exception e){
            e.printStackTrace();
        }        
        
            
        return bestellingen;
    }
        
    public boolean existsBestellingByIdKlant(Klant klant){
        boolean exists = false;
        Set<Bestelling> bestellingen = readByIdKlant (klant);
        exists = !(bestellingen == null || bestellingen.isEmpty());
             
        return exists;
    }
         
    public Set<Klant> readAll(){
        Set<Klant> klanten = new HashSet<>();
        EntityManager entityManager;
        
        entityManager = EntityManagerUtil.getEntityManager();
       //public Collection<Professor> findAllProfessors() {
       // Query query = em.createQuery("SELECT e FROM Professor e");
       // return (Collection<Professor>) query.getResultList();
 
        Query query = entityManager.createQuery("select x From Klant x");
        klanten = (Set<Klant>) query.getResultList();
             
        return klanten;
    }
         
    public Set<Klant> readByAchternaamKlant(Klant klant){
        Set<Klant> klanten = new HashSet<>();
        
        EntityManager entityManager;
        
        entityManager = EntityManagerUtil.getEntityManager();
        Query query = entityManager.createQuery("select x from Klant x where x.achternaam= :naamParam");
        query.setParameter("naamParam",klant.getAchternaam());
               
        klanten = (Set<Klant>) query.getResultList();
        
        return klanten;
    }
         
    public boolean existsByAchternaamKlant(Klant klant){
       boolean exists = false;
       Set<Klant> klanten = readByAchternaamKlant (klant);
       exists = !(klanten == null || klanten.isEmpty());
             
       return exists;
    }
         
    public void update(Klant klant){
        EntityManager entityManager = null;
        
        try {            
            entityManager= EntityManagerUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(klant);
            entityManager.getTransaction().commit();
            
        }catch (Exception e){
            e.printStackTrace();
        }        
    }
       
         
    
}
