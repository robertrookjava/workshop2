/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.database.dao;

import com.mycompany.mavenproject2.Util.EntityManagerUtil;
import com.mycompany.mavenproject2.model.Bestelling;
import com.mycompany.mavenproject2.model.Klant;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import com.mycompany.mavenproject2.database.daointerface.BestellingDAOInterface;

/**
 *
 * @author robertrook
 */
public class BestellingDAO implements BestellingDAOInterface {
    
    @Override
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
    
    @Override
    public void delete(Bestelling bestelling){
        EntityManager entityManager = null;
        
        int idBestelling = bestelling.getIdBestelling();
 
        
        try {
            
            entityManager= EntityManagerUtil.getEntityManager();
            entityManager.getTransaction().begin();
            Bestelling gevondenBestelling = entityManager.find(Bestelling.class, idBestelling);
            entityManager.remove(gevondenBestelling);
            entityManager.getTransaction().commit();
            
            
        }catch (Exception e){
            e.printStackTrace();
        }        
   
    }
    
    
    @Override
    public Bestelling read (Bestelling bestelling)  {
        Bestelling gevondenBestelling = new Bestelling();
        
        EntityManager entityManager;
        
        
        try{
            entityManager = EntityManagerUtil.getEntityManager();
            gevondenBestelling = entityManager.find(Bestelling.class, bestelling.getIdBestelling());
           
            
        }catch(Exception e){
            e.printStackTrace();
        }                
        
        return gevondenBestelling;
    }
    
    @Override
    public boolean existsByIdBestelling (Bestelling bestelling){
        boolean exists = false;
        
        Bestelling gevondenBestelling = read (bestelling);
        exists = (gevondenBestelling != null);
        
        return exists;
    }
    
    @Override
    public List<Bestelling> readAll()   {
        List<Bestelling> bestellingen = new ArrayList<>();
        EntityManager entityManager;
        
        entityManager = EntityManagerUtil.getEntityManager();
       //public Collection<Professor> findAllProfessors() {
       // Query query = em.createQuery("SELECT e FROM Professor e");
       // return (Collection<Professor>) query.getResultList();
 
        TypedQuery<Bestelling> query  = entityManager.createQuery("select x From Bestelling x",Bestelling.class);
        bestellingen = (List<Bestelling>) query.getResultList();
        

        return bestellingen;
    }
    
    @Override
     public List<Bestelling> readByIdKlant(Bestelling bestelling)  {
        List<Bestelling> bestellingen = new ArrayList<>();
        int id = bestelling.getIdKlant();
        EntityManager entityManager;
        
        try{
            entityManager = EntityManagerUtil.getEntityManager();
            // String query = "SELECT * FROM Bestelling WHERE idKlant = ?";
            TypedQuery<Bestelling> query = entityManager.createQuery("SELECT b FROM Bestelling b WHERE b.idKlant = :param",Bestelling.class);
            query.setParameter("param", id);
            bestellingen = (List<Bestelling>) query.getResultList();
           // notFound = query.setMaxResults(1).getResultList().isEmpty();
           // exists = !notFound;
           
          
         
            
            
        }catch(Exception e){
            e.printStackTrace();
        }        
        
            
        return bestellingen;
     }
     
    @Override
     public boolean existsByIdKlant(Bestelling bestelling)  {
          boolean exists = false;
          List<Bestelling> bestellingen = readByIdKlant (bestelling);
          exists = !(bestellingen == null || bestellingen.isEmpty());
          
          
          return exists;
     }
     
    @Override
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
