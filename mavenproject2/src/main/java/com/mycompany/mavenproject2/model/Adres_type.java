/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.model;

/**
 *
 * @author robertrook
 */
public class Adres_type {
    private long idAdresType;
    private String postAdres;
    private String factuurAdres;
    private String bezoekAdres;
    
    public Adres_type(){
    }

    public long getIdAdresType() {
        return idAdresType;
    }

    public void setIdAdresType(long idAdresType) {
        this.idAdresType = idAdresType;
    }

    public String getPostAdres() {
        return postAdres;
    }

    public void setPostAdres(String postAdres) {
        this.postAdres = postAdres;
    }

    public String getFactuurAdres() {
        return factuurAdres;
    }

    public void setFactuurAdres(String factuurAdres) {
        this.factuurAdres = factuurAdres;
    }

    public String getBezoekAdres() {
        return bezoekAdres;
    }

    public void setBezoekAdres(String bezoekAdres) {
        this.bezoekAdres = bezoekAdres;
    }
}
