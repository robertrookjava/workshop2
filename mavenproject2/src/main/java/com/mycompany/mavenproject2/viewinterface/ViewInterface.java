/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.viewinterface;

import java.math.BigDecimal;

/**
 *
 * @author robertrook
 */
public interface ViewInterface {
    
    public int getUserInputIdArtikel ();
     
    public int getUserInputAantal ();
     
    public String getUserInputNaam ();
     
    public BigDecimal getUserInputPrijs ();
     
    public int getUserInputVoorraad();
     
    public int getUserInputIdklant ();
     
    public String getUserInputVoornaam ();
     
    public String getUserInputAchternaam ();
     
    public String getUserInputTussenvoegsel ();
     
    public String getUserInputTelefoonnummer ();
     
    public String getUserInputEmailadres ();
    
    public int getUserInputIdBestelling();
    
    public void askUserInputDatabase (String question);
    
    public void askUserInputIdArtikel (String question);
    
    public void askUserInputAantal (String question);
    
    public void askUserInputNaam (String question);
    
    public void askUserInputPrijs (String question);
    
    public void askUserInputVoorraad (String question);
    
    public void askUserInputIdKlant (String question);
    
    public void askUserInputVoornaam (String question);
    
    public void askUserInputAchternaam (String question);
    
    public void askUserInputTussenvoegsel (String question);
    
    public void askUserInputTelefoonnummer (String question);
    
    public void askUserInputEmailadres (String question);
    
    public void askUserInputIdBestelling (String question);
    
    public String getUserInput ();
    
    public int getUserInputInt ();
    
    public BigDecimal getUserInputBigDecimal ();
    
    public void askUserInput ();
    
    public void askUserInput (String question);
    
    public void askUserInputInt (String question);
    
    public void askUserInputBigDecimal (String question);
    
    public void askUserInputEmail (String question);
    
    public void printOutput (String output);
    
    public void startScreen();
    
    public void endScreen();
    
    public void menuIntro();
    
    public void menuExtra();
    
    public void menuArtikel();
    
    public void menuKlant();
    
    public void menuBestelling ();
    
    public void menuScreen();
    
    public void menuDB();
    
    public void menuA1();
    
    public void menuA2();
    
    public void menuA3();
    
    public void menuA4();
    
    public void menuA5();
    
    public void menuA6();
    
    public void menuK1();
    
    public void menuK2();
    
    public void menuK3();
    
    public void menuK4();
    
    public void menuK5();
    
    public void menuK6();
    
    public void menuB1();
    
    public void menuB2();
    
    public void menuB3();
    
    public void menuB4();
    
    
    
    
}
