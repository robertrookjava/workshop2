/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.database.dao;

import com.mycompany.mavenproject2.Util.EntityManagerUtil;
import com.mycompany.mavenproject2.pojo.Accounttype;
import javax.persistence.EntityManager;
import com.mycompany.mavenproject2.database.daointerface.AccounttypeDAOInterface;
import org.springframework.stereotype.Component;

/**
 *
 * @author robertrook
 */
@Component
public class AccounttypeDAO implements AccounttypeDAOInterface {
    
    @Override
    public void create(Accounttype accounttype)   {
        EntityManager entityManager = null;
        
        try{
            
            entityManager=EntityManagerUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(accounttype);
            entityManager.getTransaction().commit();
                       
        }
        catch (Exception e){
            e.printStackTrace();
        }        
        
        
    }
    
}
