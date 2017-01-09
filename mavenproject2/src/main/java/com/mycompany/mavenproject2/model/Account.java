/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.model;

import java.util.Date;

/**
 *
 * @author robertrook
 */
public class Account {
    
    private int idAccount;
    private String gebruikersnaam;
    private String wachtwoord;
    private Date datum_aanmaak;
    private int accountype_id;
    
    
    public Account(){
        datum_aanmaak = new Date();
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

   
    public Date getDatum_Aanmaak() {
        return datum_aanmaak;
    }

    public void setDatum_Aanmaak (Date datum_aanmaak) {
        this.datum_aanmaak = datum_aanmaak;
    }
    
    public int getAccountype_id () {
        return accountype_id;
    }
    
    public void setAccountype_id (int accountype_id){
        this.accountype_id = accountype_id;
    }
    
    
}
