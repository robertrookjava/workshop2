/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.model;

import java.util.Date;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author robertrook
 */
@Entity
@Table(name="bestelling")
public class Bestelling implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idBestelling;
    private int idKlant;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datum_bestelling;
    private int idAccount;
    
    public Bestelling(){
        // datum_bestelling = new Date();
    }

    public int getIdBestelling() {
        return idBestelling;
    }

    public void setIdBestelling(int idBestelling) {
        this.idBestelling = idBestelling;
    }

    public int getIdKlant() {
        return idKlant;
    }

    public void setIdKlant (int idKlant) {
        this.idKlant = idKlant;
    }

    public Date getDatum_Bestelling() {
        return datum_bestelling;
    }

    public void setDatum_Bestelling(Date datum_bestelling) {
        this.datum_bestelling = datum_bestelling;
    }

    public int getIdAccount() {
        return idAccount;
    }
    

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }
    
}
