/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.database.daointerface;

import com.mycompany.mavenproject2.pojo.Bestelling;
import com.mycompany.mavenproject2.pojo.Klant;
import java.util.List;

/**
 *
 * @author robertrook
 */
public interface KlantDAOInterface {
    
    void create(Klant klant);
    
    void delete(Klant klant);
    
    Klant read (Klant klant);
    
    Boolean existsByIdKLant (Klant klant);
    
    public List<Bestelling> readByIdKlant(Klant klant);
    
    boolean existsBestellingByIdKlant(Klant klant);
    
    List<Klant> readAll();
    
    List<Klant> readByAchternaamKlant(Klant klant);
    
    boolean existsByAchternaamKlant(Klant klant);
    
    void update(Klant klant);
    
}
