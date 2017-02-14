/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.modelinterface;

import com.mycompany.mavenproject2.pojo.Artikel;
import java.math.BigDecimal;
import java.util.List;
import com.mycompany.mavenproject2.database.daointerface.ArtikelDAOInterface;

/**
 *
 * @author robertrook
 */
public interface ArtikelModelInterface {
    
    void setArtikelDAOInterface (ArtikelDAOInterface artikelDAOInterface);
    
    ArtikelDAOInterface getArtikelDAOInterface();
    
    
    void createArtikel(String naam, BigDecimal prijs, int voorraad);
    
    void deleteArtikel (int idArtikel);
    
    Artikel readByIdArtikel (int idArtikel);
    
    boolean existsByIdArtikel (int idArtikel);
    
    void updateArtikel(int idArtikel, String naam, BigDecimal prijs, int voorraad);
    
    void updateVoorraadArtikel (int idArtikel, int voorraad);
    
    void verlaagVoorraadArtikel (int idArtikel, int aantal);
    
    void verhoogVoorraadArtikel (int idArtikel, int aantal);
    
     List<Artikel> readAllArtikel ();
     
     List<Artikel> readByNameArtikel (String naam);
     
     boolean existsByNameArtikel (String naam);
    
}
