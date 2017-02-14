/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.model;

import com.mycompany.mavenproject2.database.dao.AccountDAO;
import com.mycompany.mavenproject2.database.dao.AccounttypeDAO;
import com.mycompany.mavenproject2.database.daointerface.AccountDAOInterface;
import com.mycompany.mavenproject2.pojo.Account;
import com.mycompany.mavenproject2.pojo.Accounttype;
import java.util.Date;
import com.mycompany.mavenproject2.modelinterface.AccountModelInterface;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import com.mycompany.mavenproject2.database.daointerface.AccounttypeDAOInterface;


/**
 *
 * @author robertrook
 */
@Component
public class AccountModel implements AccountModelInterface {
    
    
    
    @Autowired
    private AccountDAOInterface accountDAOInterface;
    
    @Autowired
    private AccounttypeDAOInterface accounttypeDaoInterface;
    
    
    
    
    
    
@Override
    public void setAccountDAOInterface(AccountDAOInterface accountDAOInterface) {
        this.accountDAOInterface = accountDAOInterface;
    }

    @Override
    public AccountDAOInterface getAccountDAOInterface() {
        return this.accountDAOInterface;
    }  
    
    @Override
    public void setAccounttypeDAOInterface(AccounttypeDAOInterface accounttypeDAOInterface) {
        this.accounttypeDaoInterface=accounttypeDAOInterface;
    }

    @Override
    public AccounttypeDAOInterface getAccounttypeDAOInterface() {
       return this.accounttypeDaoInterface;
    }
    
    
    
    private void maakAccountTypeRecord(){
        
        
        
        Accounttype accounttype = new Accounttype();
        accounttype.setId(1);
        accounttype.setTYpe("amin");
        
        accounttypeDaoInterface.create(accounttype);
        
        
        
        
      
    }
    
    private boolean bestaatAccount(int i){
        boolean output = false;
        
        
        
        Account account = new Account();
        account.setIdAccount(1);
      
        output = accountDAOInterface.bestaatAccount(account);

      
        
        return output;
            
        
    }
    
    
    
    
    private void maakAccountRecord(){
        
        
        Account account = new Account();
        account.setIdAccount(1);
        account.setGebruikersnaam("Robert Rook");
        account.setWachtwoord("Geheim");
        account.setDatum_Aanmaak (new Date());
        account.setAccountype_id(1);
        
        accountDAOInterface.create(account);
       
        
        
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
