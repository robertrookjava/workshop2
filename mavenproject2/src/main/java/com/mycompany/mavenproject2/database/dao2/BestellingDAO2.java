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
public class BestellingDAO2 {
    
    public int create(Bestelling bestelling)   { // geeft de idBestelling (auto increment) terug
        int idBestelling = 0;
        
        EntityManager entityManager = null;
        
        try{
            
            entityManager=EntityManagerUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(bestelling);
            entityManager.getTransaction().commit();
                       
        }
        catch (Exception e){
            e.printStackTrace();
        }        
        
        idBestelling = bestelling.getIdBestelling();
        return idBestelling;
    }
    
    public void delete(Bestelling bestelling){
        EntityManager entityManager = null;
        
        int idBestelling = bestelling.getIdBestelling();
 
        
        try {
            
            entityManager= EntityManagerUtil.getEntityManager();
            entityManager.getTransaction().begin();
            Bestelling gevondenBestelling = (Bestelling)entityManager.find(Bestelling.class, idBestelling);
            entityManager.remove(gevondenBestelling);
            entityManager.getTransaction().commit();
            
            
        }catch (Exception e){
            e.printStackTrace();
        }        
   
    }
    
    
    public Bestelling readByIdBestelling (Bestelling bestelling)  {
        Bestelling gevondenBestelling = new Bestelling();
        
        EntityManager entityManager;
        
        
        try{
            entityManager = EntityManagerUtil.getEntityManager();
            gevondenBestelling = (Bestelling)entityManager.find(Bestelling.class, bestelling.getIdBestelling());
           
            
        }catch(Exception e){
            e.printStackTrace();
        }                
        
        return gevondenBestelling;
    }
    
    public boolean existsByIdBestelling (Bestelling bestelling){
        boolean exists = false;
        
        Bestelling gevondenBestelling = readByIdBestelling (bestelling);
        exists = (gevondenBestelling != null);
        
        return exists;
    }
    
    public Set<Bestelling> readAll()   {
        Set<Bestelling> bestellingen = new HashSet<>();
        EntityManager entityManager;
        
        entityManager = EntityManagerUtil.getEntityManager();
       //public Collection<Professor> findAllProfessors() {
       // Query query = em.createQuery("SELECT e FROM Professor e");
       // return (Collection<Professor>) query.getResultList();
 
        Query query = entityManager.createQuery("select x From Bestelling x");
        bestellingen = (Set<Bestelling>) query.getResultList();
        
        return bestellingen;
    }
    
     public Set<Bestelling> readByIdKlant(Bestelling bestelling)  {
        Set<Bestelling> bestellingen = new HashSet<>();
        int id = bestelling.getIdKlant();
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
     
     public boolean existsByIdKlant(Bestelling bestelling)  {
          boolean exists = false;
          Set<Bestelling> bestellingen = readByIdKlant (bestelling);
          exists = !(bestellingen == null || bestellingen.isEmpty());
          
          
          return exists;
     }
     
      public void update(Bestelling bestelling){
          EntityManager entityManager = null;
        
        try {            
            entityManager= EntityManagerUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(bestelling);
            entityManager.getTransaction().commit();
            
        }catch (Exception e){
            e.printStackTrace();
        }        
          
      }
    
    
    
}
