/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.pojo;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import java.math.BigDecimal;
import javax.persistence.GenerationType;

/**
 *
 * @author robertrook
 */
@Entity 
@Table(name="artikel")
public class Artikel implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idArtikel;
    
   
    private String naam;
    
    
    private BigDecimal prijs;
    private int voorraad;
    
    public Artikel(){
    }

    
    public int getIdArtikel() {
        return idArtikel;
    }

    public void setIdArtikel(int idArtikel) {
        this.idArtikel = idArtikel;
    }
   

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }


    public BigDecimal getPrijs() {
        return prijs;
    }

    public void setPrijs(BigDecimal prijs) {
        this.prijs = prijs;
    }

    public int getVoorraad() {
        return voorraad;
    }

    public void setVoorraad(int voorraad) {
        this.voorraad = voorraad;
    }
}
