/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;

/**
 *
 * @author robertrook
 */
@Entity
public class BestelArtikel implements Serializable{
    
    
    @EmbeddedId
    private BestelArtikelPK bestelArtikelPK;
    
 
    private int aantal; 
    
    public BestelArtikel(){
        bestelArtikelPK = new BestelArtikelPK();
    }

    public int getIdBestelling() {

        return bestelArtikelPK.idBestelling;
    }

    public void setIdBestelling(int idBestelling) {
        this.bestelArtikelPK.idBestelling = idBestelling;
    }

    public int getIdArtikel() {
        return bestelArtikelPK.idArtikel;
    }

    public void setIdArtikel(int idArtikel) {
        this.bestelArtikelPK.idArtikel = idArtikel;
    }

    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }
}


