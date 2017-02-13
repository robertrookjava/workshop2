/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.modelinterface;

import com.mycompany.mavenproject2.pojo.Klant;
import java.util.List;

/**
 *
 * @author robertrook
 */
public interface KlantModelInterface {
    
    void createKlant(String voornaam, String achternaam, String tussenvoegsel, String telefoonnummer, String emailadres);
    
    void deleteKlant(int idKlant);
    
    Klant readByIDKlant(int idKlant);
    
    boolean existsByIDKlant(int idKlant);
    
    boolean existsBestellingByIdKlant (int idKlant);
    
    boolean existsBestelArtikelByIdArtikel (int idArtikel);
    
    void updateKlant(int idKlant, String voornaam, String achternaam, String tussenvoegsel, String telefoonnummer, String emailadres);
    
    List<Klant> readAllKlant();
    
    List<Klant> readByAchternaamKlant(String achternaam);
    
    boolean existsByAchternaamKlant(String achternaam);
    
}
