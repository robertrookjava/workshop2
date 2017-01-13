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
@Embeddable
public class BestelArtikelPK implements Serializable {
    protected int idBestelling;
    protected int idArtikel;
    
    public BestelArtikelPK(){
        
    }
    
    public BestelArtikelPK (int idBestelling, int idArtikel) {
        this.idBestelling = idBestelling;
        this.idArtikel = idArtikel;
    }
    
    public void setIdBestelling (int idBestelling){
        this.idBestelling = idBestelling;
    }
    
    public void setIdArtikel (int idArtikel){
        this.idArtikel = idArtikel;
    }
    
    public int getIdBestelling (){
        return this.idBestelling;
    }
    
    public int getIdArtikel(){
        return this.idArtikel;
    }
    
}

