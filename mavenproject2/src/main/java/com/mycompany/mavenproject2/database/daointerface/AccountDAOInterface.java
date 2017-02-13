/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.database.daointerface;
import com.mycompany.mavenproject2.pojo.Account;
/**
 *
 * @author robertrook
 */
public interface AccountDAOInterface {
    
    void create (Account account);
    
    boolean bestaatAccount (Account account);
    
    Account read(Account account);
    
    boolean existsByIdAccount (Account account);
    
    
    
}
