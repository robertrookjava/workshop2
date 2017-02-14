/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.modelinterface;

import com.mycompany.mavenproject2.pojo.Bestelling;
import java.util.List;
import com.mycompany.mavenproject2.database.daointerface.BestellingDAOInterface;

/**
 *
 * @author robertrook
 */
public interface BestellingModelInterface {
    
    void setBestellingDAOInterface (BestellingDAOInterface bestellingDAOInterface);
    BestellingDAOInterface getBestellingDAOInterface();
    
    
    int createBestelling(int idKlant, int idAccount);
    
    void deleteBestelling(int idBestelling);
    
    Bestelling readByIdBestelling(int idBestelling);
    
    boolean existsByIdBestelling(int idBestelling);
    
    List<Bestelling> readAllBestelling();
    
    List<Bestelling> readByIdKlantBestelling(int idKlant);
    
    void updateBestelling(int idBestelling, int idKlant, int idAccount);
    
}
