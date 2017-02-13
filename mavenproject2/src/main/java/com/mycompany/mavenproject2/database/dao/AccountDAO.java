/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.database.dao;

import com.mycompany.mavenproject2.Util.EntityManagerUtil;
import com.mycompany.mavenproject2.model.Account;
import javax.persistence.EntityManager;
import com.mycompany.mavenproject2.database.daointerface.AccountDAOInterface;

/**
 *
 * @author robertrook
 */
public class AccountDAO implements AccountDAOInterface {
    
    @Override
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
     
    @Override
    public boolean bestaatAccount (Account account){
        boolean output = false;
        Account gevondenAccount = read (account);
        output = (gevondenAccount != null);
    
        return output;
    }
    
    @Override
    public Account read(Account account){
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
    
    @Override
    public boolean existsByIdAccount (Account account){
        
        Account gevondenAccount = read (account);
        boolean exists = (gevondenAccount != null);
        return exists;
        
    }
     
    
}
