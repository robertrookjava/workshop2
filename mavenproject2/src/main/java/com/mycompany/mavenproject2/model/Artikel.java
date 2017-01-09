/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.model;

import java.math.BigDecimal;

/**
 *
 * @author robertrook
 */
public class Artikel {
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
