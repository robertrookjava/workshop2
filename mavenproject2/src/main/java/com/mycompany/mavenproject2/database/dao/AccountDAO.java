/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.database.dao;

import com.mycompany.mavenproject2.Util.EntityManagerUtil;
import com.mycompany.mavenproject2.model.Account;
import javax.persistence.EntityManager;

/**
 *
 * @author robertrook
 */
public class AccountDAO {
    
    public void create(Account account){
        EntityManager entityManager = null;
        
        try{
            
            entityManager=EntityManagerUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(account);
            entityManager.getTransaction().commit();
                       
        }
        catch (Exception e){
            e.printStackTrace();
        }        
        
    }
     
    public boolean bestaatAccount (Account account){
        boolean output = false;
        Account gevondenAccount = readByIdAccount (account);
        output = (gevondenAccount != null);
    
        return output;
    }
    
    public Account readByIdAccount (Account account){
        Account gevondenAccount = new Account();
        
        EntityManager entityManager;
        
        
        try{
            entityManager = EntityManagerUtil.getEntityManager();
            gevondenAccount = entityManager.find(Account.class, account.getIdAccount());
           
            
        }catch(Exception e){
            e.printStackTrace();
        }                
        return gevondenAccount;
        
        
    
    }
    
    public boolean existsByIdAccount (Account account){
        
        Account gevondenAccount = readByIdAccount (account);
        boolean exists = (gevondenAccount != null);
        return exists;
        
    }
     
    
}
