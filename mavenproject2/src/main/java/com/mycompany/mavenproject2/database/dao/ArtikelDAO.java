/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.database.dao;

import com.mycompany.mavenproject2.pojo.Artikel;
import com.mycompany.mavenproject2.pojo.BestelArtikel;
import com.mycompany.mavenproject2.pojo.BestelArtikelPK;


import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.mycompany.mavenproject2.Util.EntityManagerUtil;
import javax.persistence.TemporalType;
import com.mycompany.mavenproject2.database.daointerface.ArtikelDAOInterface;
import org.springframework.stereotype.Component;

/**
 *
 * @author robertrook
 */
@Component
public class ArtikelDAO implements ArtikelDAOInterface {
    
    @Override
    public void create(Artikel artikel){
        EntityManager entityManager = null;
        
        try{
            
            entityManager=EntityManagerUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(artikel);
            entityManager.getTransaction().commit();
                       
        }
        catch (Exception e){
            e.printStackTrace();
        }        
        
    }
    
    @Override
    public void delete(Artikel artikel){
        EntityManager entityManager = null;
        
        int idArtikel = artikel.getIdArtikel();
 
        
        try {
            
            entityManager= EntityManagerUtil.getEntityManager();
            entityManager.getTransaction().begin();
            Artikel gevondenArtikel = entityManager.find(Artikel.class, idArtikel);
            entityManager.remove(gevondenArtikel);
            entityManager.getTransaction().commit();
            
            
        }catch (Exception e){
            e.printStackTrace();
        }        
        
    }
        
    
    
    @Override
    public Artikel read (Artikel artikel){
        Artikel gevondenArtikel = new Artikel();
        
        EntityManager entityManager;
        
        
        try{
            entityManager = EntityManagerUtil.getEntityManager();
            gevondenArtikel = entityManager.find(Artikel.class, artikel.getIdArtikel());
           
            
        }catch(Exception e){
            e.printStackTrace();
        }                
        return gevondenArtikel;
        
        
    
    }
    
    @Override
    public boolean existsByIdArtikel (Artikel artikel){
        
        Artikel gevondenArtikel = read (artikel);
        boolean exists = (gevondenArtikel != null);
        return exists;
        
    }
    
    
    // even vragen of uitzoeken
    @Override
    public boolean existsBestelArtikelByIdArtikel (Artikel artikel){
         boolean exists = false;
         EntityManager entityManager;
         
         boolean notFound = false;
         int id = artikel.getIdArtikel();
                 
         
        try{
            entityManager = EntityManagerUtil.getEntityManager();
            
            Query query = entityManager.createQuery("SELECT b FROM BestelArtikel b WHERE b.bestelArtikelPK.idArtikel = :param");
            query.setParameter("param", id);
            notFound = query.setMaxResults(1).getResultList().isEmpty();
            exists = !notFound;
            
            
        }catch(Exception e){
            e.printStackTrace();
        }                        
         
         return exists;
    }
    
    
    
    @Override
    public boolean existsByNaam(Artikel artikel){
        boolean exists = false;
        EntityManager entityManager;
        
   //     EntityManager em;
   // Query q = em.createQuery ("SELECT x FROM Magazine x WHERE x.title = :titleParam and x.price > :priceParam");
   // q.setParameter ("titleParam", "JDJ").setParameter ("priceParam", 5.0);
   // List<Magazine> results = (List<Magazine>) q.getResultList ();
    
    
        entityManager = EntityManagerUtil.getEntityManager();
            
        Query query = entityManager.createQuery("select x from Artikel x where x.naam= :naamParam");
        query.setParameter("naamParam",artikel.getNaam());
        boolean notFound = query.setMaxResults(1).getResultList().isEmpty();
        exists = !notFound;
        
 
        return exists;
      
        
    }
    
    @Override
    public List<Artikel> readAll(){
        List<Artikel> artikelen = new ArrayList<>();
        EntityManager entityManager;
        
        entityManager = EntityManagerUtil.getEntityManager();
       //public Collection<Professor> findAllProfessors() {
       // Query query = em.createQuery("SELECT e FROM Professor e");
       // return (Collection<Professor>) query.getResultList();
       
        //TypedQuery<Artikel> query = entityManager.createQuery("select x from Artikel x where x.naam= :naamParam",Artikel.class);
        //query.setParameter("naamParam",artikel.getNaam());
 
        TypedQuery<Artikel> query = entityManager.createQuery("select x From Artikel x",Artikel.class);
        artikelen = (List<Artikel>) query.getResultList();
        
        
        return artikelen;
    }
    
    @Override
    public List<Artikel> readByNaam(Artikel artikel){
        List<Artikel> artikelen = new ArrayList<>();
        
        EntityManager entityManager;
        
        entityManager = EntityManagerUtil.getEntityManager();
            
        //Query query = entityManager.createQuery("select x from Artikel x where x.naam= :naamParam");
        TypedQuery<Artikel> query = entityManager.createQuery("select x from Artikel x where x.naam= :naamParam",Artikel.class);
        query.setParameter("naamParam",artikel.getNaam());
        
        artikelen =  query.getResultList();
        
        
        
        
        
        
        
        return artikelen;
    }
     
    @Override
    public void update(Artikel artikel){
        EntityManager entityManager = null;
        
        try {            
            entityManager= EntityManagerUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(artikel);
            entityManager.getTransaction().commit();
            
        }catch (Exception e){
            e.printStackTrace();
        }        
          
    }
      
      
    
    
}
