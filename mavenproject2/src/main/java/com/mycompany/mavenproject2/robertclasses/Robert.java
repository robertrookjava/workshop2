/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.robertclasses;
import com.mycompany.mavenproject2.database.daofactory.AccountDaoFactory;
import com.mycompany.mavenproject2.database.dao.AccounttypeDAO;
import com.mycompany.mavenproject2.model.Accounttype;
import com.mycompany.mavenproject2.database.dao.AccountDAO;
import com.mycompany.mavenproject2.database.daofactory.AccounttypeDaoFactory;
import com.mycompany.mavenproject2.model.Account;

import java.sql.*;
import java.util.*;
import java.util.Date;
import com.mycompany.mavenproject2.database.dao.AccountDAO;
import com.mycompany.mavenproject2.database.dao.AccounttypeDAO;
import com.mycompany.mavenproject2.database.Database;


/**
 *
 * @author robertrook
 */
public class Robert {
    
    
    // maak account om dat ik geen onderhoudsscherm accounts heb en je ander foreign key problemen krijgt
    private static void maakAccountTypeRecord(Database database){
        
        AccounttypeDaoFactory accounttypeDaoFactory = new AccounttypeDaoFactory ();
        AccounttypeDAO accounttypeDao = accounttypeDaoFactory.getAccounttypeDao(database);
        Accounttype accounttype = new Accounttype();
        accounttype.setId(1);
        accounttype.setTYpe("admin");
        
        accounttypeDao.create(accounttype);
        
        
        
    }
    
    
    private static void maakAccountRecord(Database database){
        AccountDaoFactory accountDaoFactory = new AccountDaoFactory ();
        AccountDAO accountDao = accountDaoFactory.getAccountDao(database);
        Account account = new Account();
        account.setIdAccount(1);
        account.setGebruikersnaam("Robert Rook");
        account.setWachtwoord("Geheim");
        account.setDatum_Aanmaak (new Date());
        account.setAccountype_id(1);
        
        accountDao.create(account);
        
        
        
    }
    
    // nog verder doen
    public static void maakAccount(Database database){
        maakAccountTypeRecord(database);
        maakAccountRecord(database);
    }
 
            
            
            
    
    
    
}
