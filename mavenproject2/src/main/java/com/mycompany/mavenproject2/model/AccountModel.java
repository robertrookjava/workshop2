/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.model;

import com.mycompany.mavenproject2.database.dao.AccountDAO;
import com.mycompany.mavenproject2.database.dao.AccounttypeDAO;
import com.mycompany.mavenproject2.pojo.Account;
import com.mycompany.mavenproject2.pojo.Accounttype;
import java.util.Date;
import com.mycompany.mavenproject2.modelinterface.AccountModelInterface;
import org.springframework.stereotype.Component;

/**
 *
 * @author robertrook
 */
@Component
public class AccountModel implements AccountModelInterface {
    
    private void maakAccountTypeRecord(){
        
        
        AccounttypeDAO accounttypeDao = new AccounttypeDAO();
        Accounttype accounttype = new Accounttype();
        accounttype.setId(1);
        accounttype.setTYpe("amin");
        
        accounttypeDao.create(accounttype);
        
        
        
        
      
    }
    
    private boolean bestaatAccount(int i){
        boolean output = false;
        
        
        AccountDAO accountDao = new  AccountDAO();
        Account account = new Account();
        account.setIdAccount(1);
      
        output = accountDao.bestaatAccount(account);

      
        
        return output;
            
        
    }
    
    
    
    
    private void maakAccountRecord(){
        
        AccountDAO accountDao = new  AccountDAO();
        Account account = new Account();
        account.setIdAccount(1);
        account.setGebruikersnaam("Robert Rook");
        account.setWachtwoord("Geheim");
        account.setDatum_Aanmaak (new Date());
        account.setAccountype_id(1);
        
        accountDao.create(account);
       
        
        
    }
    

    @Override
    public void maakAccount(){
        boolean bestaatAccount1 = bestaatAccount(1);
         
        if (!bestaatAccount1){
            maakAccountTypeRecord();
            maakAccountRecord();
        }
     }
    
}
