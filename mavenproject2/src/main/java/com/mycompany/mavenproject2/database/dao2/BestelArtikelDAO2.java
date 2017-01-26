/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.database.dao2;

import com.mycompany.mavenproject2.Util.EntityManagerUtil;
import com.mycompany.mavenproject2.model.BestelArtikel;
import com.mycompany.mavenproject2.model.BestelArtikelPK;
import com.mycompany.mavenproject2.model.Bestelling;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author robertrook
 */
public class BestelArtikelDAO2 {
    
    public void create(BestelArtikel bestelArtikel){
         
        EntityManager entityManager = null;
        
        try{
            
            entityManager=EntityManagerUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(bestelArtikel);
            entityManager.getTransaction().commit();
                       
        }
        catch (Exception e){
            e.printStackTrace();
        }        
         
         
         
     }
     
     
     // doen met BestelArtikelPK ->
    public void delete(BestelArtikel bestelArtikel){
        EntityManager entityManager = null;
        
        int idBestelling = bestelArtikel.getIdBestelling();
        int idArtikel = bestelArtikel.getIdArtikel();
 
        
        try {
            
            entityManager= EntityManagerUtil.getEntityManager();
            entityManager.getTransaction().begin();
            // voorbeeld ->
            //CarPK carPK = new CarPK();
            //carPK.setChassisSerialNumber("9BW DA05X6 1 T050136");
            //carPK.setEngineSerialNumber("ABC123");
            //Car car = em.find(Car.class, carPK);
            // voorbeeld <-
            BestelArtikelPK bestelArtikelPK = new BestelArtikelPK();
            bestelArtikelPK.setIdBestelling(idBestelling);
            bestelArtikelPK.setIdArtikel(idArtikel);
            BestelArtikel gevondenBestelArtikel = entityManager.find(BestelArtikel.class, bestelArtikelPK);
            entityManager.remove(gevondenBestelArtikel);
            entityManager.getTransaction().commit();
            
            
        }catch (Exception e){
            e.printStackTrace();
        }        
   
         
    }
     
    public BestelArtikel readByIdBestellingIdArtikel (BestelArtikel bestelArtikel) {
        EntityManager entityManager = null;
        
        BestelArtikel gevondenBestelArtikel = new BestelArtikel();
        int idBestelling = bestelArtikel.getIdBestelling();
        int idArtikel = bestelArtikel.getIdArtikel();
 
        
        try {
            
            entityManager= EntityManagerUtil.getEntityManager();
           
            // voorbeeld ->
            //CarPK carPK = new CarPK();
            //carPK.setChassisSerialNumber("9BW DA05X6 1 T050136");
            //carPK.setEngineSerialNumber("ABC123");
            //Car car = em.find(Car.class, carPK);
            // voorbeeld <-
            BestelArtikelPK bestelArtikelPK = new BestelArtikelPK();
            bestelArtikelPK.setIdBestelling(idBestelling);
            bestelArtikelPK.setIdArtikel(idArtikel);
            gevondenBestelArtikel = entityManager.find(BestelArtikel.class, bestelArtikelPK);
           
            
            
        }catch (Exception e){
            e.printStackTrace();
        }        
        return gevondenBestelArtikel;
    }
      
    public boolean existsByIdBestellingIdArtikel (BestelArtikel bestelArtikel) {
          
        boolean exists = false;
          
        BestelArtikel gevondenBestelArtikel = readByIdBestellingIdArtikel (bestelArtikel);
        exists = (gevondenBestelArtikel != null);
          
          return exists;
    }
      
      // doen met BestelArtikelPK <-
      
    public Set<BestelArtikel> readAll()   {
        Set<BestelArtikel> bestelArtikelen = new HashSet<>();
           
        EntityManager entityManager;
        
        entityManager = EntityManagerUtil.getEntityManager();
            //public Collection<Professor> findAllProfessors() {
            // Query query = em.createQuery("SELECT e FROM Professor e");
            // return (Collection<Professor>) query.getResultList();
 
        Query query = entityManager.createQuery("select x From BestelArtikel x");
        bestelArtikelen = (Set<BestelArtikel>) query.getResultList();
           
        return bestelArtikelen;
    }
       
    public Set<BestelArtikel> readByIdBestelling (BestelArtikel bestelArtikel)  {
        Set<BestelArtikel> bestelArtikelen = new HashSet<>();
        int idBestelling = bestelArtikel.getIdBestelling();
           
        EntityManager entityManager;
        
        entityManager = EntityManagerUtil.getEntityManager();
            //public Collection<Professor> findAllProfessors() {
            // Query query = em.createQuery("SELECT e FROM Professor e");
            // return (Collection<Professor>) query.getResultList();
 
        Query query = entityManager.createQuery("select x From BestelArtikel x where x.bestelArtikelPK.idBestelling = :param");
        query.setParameter("param", idBestelling);
        bestelArtikelen = (Set<BestelArtikel>) query.getResultList();
           
        return bestelArtikelen;
    }
       
    public void update(BestelArtikel bestelArtikel){
        EntityManager entityManager = null;
        
        try {            
            entityManager= EntityManagerUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(bestelArtikel);
            entityManager.getTransaction().commit();
            
        }catch (Exception e){
            e.printStackTrace();
        }        
    }
    
}
