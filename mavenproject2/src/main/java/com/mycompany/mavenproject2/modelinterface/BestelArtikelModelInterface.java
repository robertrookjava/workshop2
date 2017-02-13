/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.modelinterface;

import com.mycompany.mavenproject2.pojo.BestelArtikel;
import java.util.List;

/**
 *
 * @author robertrook
 */
public interface BestelArtikelModelInterface {
    
    void createBestelArtikel(int idBestelling, int idArtikel, int aantal);
    
    void deleteBestelArtikel(int idBestelling, int idArtikel);
    
    BestelArtikel readByIdBestellingIdArtikel(int idBestelling, int idArtikel);
    
    boolean existsByIdBestellingIdArtikel(int idBestelling, int idArtikel);
    
    List<BestelArtikel> readAllBestelArtikel();
    
    List<BestelArtikel> readByIdBestellingBestelArtikel(int idBestelling);
    
    void updateBestelArtikel(int idBestelling, int idArtikel, int aantal);
    
}
