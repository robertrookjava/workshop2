/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.database.dao2;

import com.mycompany.mavenproject2.model.Artikel;
import java.util.HashSet;
import java.util.Set;


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

import com.mycompany.mavenproject2.Util.EntityManagerUtil;

/**
 *
 * @author robertrook
 */
public class ArtikelDAO2 {
    
    public void create(Artikel artikel){
        EntityManager entityManager = null;
        
        try{
            
            entityManager= EntityManagerUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(artikel);
            entityManager.getTransaction().commit();
            
        }
        catch (Exception e){
            e.printStackTrace();
        }        
        
    }
    
    public void delete(Artikel artikel){
        EntityManager entityManager = null;
        
        int idArtikel = artikel.getIdArtikel();
 
        
        try {
            
            entityManager= EntityManagerUtil.getEntityManager();
            entityManager.getTransaction().begin();
            Artikel gevondenArtikel = (Artikel)entityManager.find(Artikel.class, idArtikel);
            entityManager.remove(gevondenArtikel);
            entityManager.getTransaction().commit();
            
        }catch (Exception e){
            e.printStackTrace();
        }        
        
    }
        
    
    
    public Artikel readByIdArtikel (Artikel artikel){
        Artikel gevondenArtikel = new Artikel();
        
        EntityManager entityManager;
        
        
        try{
            entityManager = EntityManagerUtil.getEntityManager();
            gevondenArtikel = (Artikel)entityManager.find(Artikel.class, artikel.getIdArtikel());
            
        }catch(Exception e){
            e.printStackTrace();
        }                
        return gevondenArtikel;
        
        
    
    }
    
    public boolean existsByIdArtikel (Artikel artikel){
        
        Artikel gevondenArtikel = readByIdArtikel (artikel);
        boolean exists = (gevondenArtikel != null);
        return exists;
        
    }
    
    public boolean existsBestelArtikelByIdArtikel (Artikel artikel){
         boolean exists = false;
         
         return exists;
    }
    
    public boolean existsByNaam(Artikel artikel){
        boolean exists = false;
         
        return exists;
        
        
        
    }
    
    public Set<Artikel> readAll(){
        Set<Artikel> artikelen = new HashSet<>();
        
        return artikelen;
    }
    
    public Set<Artikel> readByNaam(Artikel artikel){
        Set<Artikel> artikelen = new HashSet<>();
        
        return artikelen;
    }
     
    public void update(Artikel artikel){
          
      }
      
      
    
    
}
