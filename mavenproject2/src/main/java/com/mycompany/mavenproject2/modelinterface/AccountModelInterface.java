/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.modelinterface;
import com.mycompany.mavenproject2.database.daointerface.AccountDAOInterface;
import com.mycompany.mavenproject2.database.daointerface.AccounttypeDAOInterface;

/**
 *
 * @author robertrook
 */
public interface AccountModelInterface {
    
    void setAccountDAOInterface(AccountDAOInterface accountDAOInterface);
    
    AccountDAOInterface getAccountDAOInterface(); 
    
    void setAccounttypeDAOInterface (AccounttypeDAOInterface accounttypeDAOInterface);
    
    AccounttypeDAOInterface getAccounttypeDAOInterface();
    
    void maakAccount();
    
    
   
}
