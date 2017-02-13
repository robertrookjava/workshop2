/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.database.daointerface;

import com.mycompany.mavenproject2.pojo.BestelArtikel;
import java.util.List;

/**
 *
 * @author robertrook
 */
public interface BestelArtikelDAOInterface {
    void create(BestelArtikel bestelArtikel);
    
    void delete(BestelArtikel bestelArtikel);
    
    BestelArtikel read (BestelArtikel bestelArtikel);
    
    boolean existsByIdBestellingIdArtikel (BestelArtikel bestelArtikel);
    
    List<BestelArtikel> readAll();
    
    List<BestelArtikel> readByIdBestelling (BestelArtikel bestelArtikel);
    
    void update(BestelArtikel bestelArtikel);
    
    
}
