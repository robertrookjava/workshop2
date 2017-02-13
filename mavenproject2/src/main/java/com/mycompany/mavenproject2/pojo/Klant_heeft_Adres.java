/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.pojo;

/**
 *
 * @author robertrook
 */
public class Klant_heeft_Adres {
     private int idKlant;
    private int idAdres;
    private int idAdres_type;
    
    public Klant_heeft_Adres(){
    }

    public int getIdKlant() {
        return idKlant;
    }

    public void setIdKlant(int idKlant) {
        this.idKlant = idKlant;
    }

    public int getIdAdres() {
        return idAdres;
    }

    public void setIdAdres(int idAdres) {
        this.idAdres = idAdres;
    }
    
     public int getIdAdres_type() {
        return idAdres_type;
    }

    public void setIdAdres_type(int idAdres_type) {
        this.idAdres_type = idAdres_type;
    }
    
}
