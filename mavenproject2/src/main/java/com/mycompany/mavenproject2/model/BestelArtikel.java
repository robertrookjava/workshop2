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
public class BestelArtikel {
    private int idBestelling;
    private int idArtikel;
    private int aantal; 
    
    public BestelArtikel(){
    }

    public int getIdBestelling() {
        return idBestelling;
    }

    public void setIdBestelling(int idBestelling) {
        this.idBestelling = idBestelling;
    }

    public int getIdArtikel() {
        return idArtikel;
    }

    public void setIdArtikel(int idArtikel) {
        this.idArtikel = idArtikel;
    }

    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }
}
