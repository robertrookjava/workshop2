/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.database.daointerface;

import com.mycompany.mavenproject2.pojo.Bestelling;
import java.util.List;

/**
 *
 * @author robertrook
 */
public interface BestellingDAOInterface {
    
    int create(Bestelling bestelling);
    
    void delete(Bestelling bestelling);
    
    Bestelling read (Bestelling bestelling);
    
    List<Bestelling> readAll();
    
    boolean existsByIdBestelling (Bestelling bestelling);
    
    List<Bestelling> readByIdKlant(Bestelling bestelling);
    
    boolean existsByIdKlant(Bestelling bestelling);
    
    void update(Bestelling bestelling);
    
    
    
    
    
}
