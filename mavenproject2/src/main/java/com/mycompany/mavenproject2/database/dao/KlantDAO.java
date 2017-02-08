/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.database.dao;

import com.mycompany.mavenproject2.Util.EntityManagerUtil;
import com.mycompany.mavenproject2.model.Bestelling;
import com.mycompany.mavenproject2.model.Klant;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author robertrook
 */
public class KlantDAO {
    
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
            Klant gevondenKlant = entityManager.find(Klant.class, idKlant);
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
            gevondenKlant = entityManager.find(Klant.class, klant.getIdKlant());
           
            
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
       
    public List<Bestelling> readByIdKlant(Klant klant){
        List<Bestelling> bestellingen = new ArrayList<>();
        int id = klant.getIdKlant();
        EntityManager entityManager;
        
        try{
            entityManager = EntityManagerUtil.getEntityManager();
            // String query = "SELECT * FROM Bestelling WHERE idKlant = ?";
           // Query query = entityManager.createQuery("SELECT b FROM Bestelling b WHERE b.idKlant = :param");
            //query.setParameter("param", id);
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
        
    public boolean existsBestellingByIdKlant(Klant klant){
        boolean exists = false;
        List<Bestelling> bestellingen = readByIdKlant (klant);
        exists = !(bestellingen == null || bestellingen.isEmpty());
             
        return exists;
    }
         
    public List<Klant> readAll(){
        List<Klant> klanten = new ArrayList<>();
        EntityManager entityManager;
        
        entityManager = EntityManagerUtil.getEntityManager();
       //public Collection<Professor> findAllProfessors() {
       // Query query = em.createQuery("SELECT e FROM Professor e");
       // return (Collection<Professor>) query.getResultList();
 
        TypedQuery<Klant> query = entityManager.createQuery("select x From Klant x",Klant.class);
        klanten = (List<Klant>) query.getResultList();
               
        
             
        return klanten;
    }
         
    public List<Klant> readByAchternaamKlant(Klant klant){
        List<Klant> klanten = new ArrayList<>();
        
        EntityManager entityManager;
        
        entityManager = EntityManagerUtil.getEntityManager();
        TypedQuery<Klant>  query = entityManager.createQuery("select x from Klant x where x.achternaam= :naamParam",Klant.class);
        query.setParameter("naamParam",klant.getAchternaam());
               
        klanten = (List<Klant>) query.getResultList();

        
        return klanten;
    }
         
    public boolean existsByAchternaamKlant(Klant klant){
       boolean exists = false;
       List<Klant> klanten = readByAchternaamKlant (klant);
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
