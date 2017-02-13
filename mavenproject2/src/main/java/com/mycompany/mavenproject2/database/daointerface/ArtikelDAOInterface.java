/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.database.daointerface;

import com.mycompany.mavenproject2.model.Artikel;
import java.util.List;

/**
 *
 * @author robertrook
 */
public interface ArtikelDAOInterface {
    
    void create(Artikel artikel);
    
    void delete(Artikel artikel);
    
    Artikel read (Artikel artikel);
    
    boolean existsByIdArtikel (Artikel artikel);
    
    boolean existsBestelArtikelByIdArtikel (Artikel artikel);
    
    boolean existsByNaam(Artikel artikel);
    
    List<Artikel> readAll();
    
    List<Artikel> readByNaam(Artikel artikel);
    
    void update(Artikel artikel);
    
    
}
