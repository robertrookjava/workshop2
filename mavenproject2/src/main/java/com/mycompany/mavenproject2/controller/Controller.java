/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.controller;
import com.mycompany.mavenproject2.model.Model;
import com.mycompany.mavenproject2.pojo.Klant;
import com.mycompany.mavenproject2.pojo.BestelArtikel;
import com.mycompany.mavenproject2.pojo.Bestelling;
import com.mycompany.mavenproject2.pojo.Artikel;
import com.mycompany.mavenproject2.view.View;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;


/**
 *
 * @author robertrook
 */
public class Controller {
    
     
    private Model model;
    private View view;
    private boolean exit = false;
   
    
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }
    
    private void verwerkInput (String userInput){
        switch (userInput) {
            case "menu":  verwerkInput_menu();
                     break;
            case "ma":  verwerkInput_ma();
                     break;
            //case "db":  verwerkInput_db();
            //         break;         
            case "a1":  verwerkInput_a1();
                     break;
            case "a2":  verwerkInput_a2();
                     break;
            case "a3":  verwerkInput_a3();
                     break;
            case "a4":  verwerkInput_a4();
                     break;
            case "a5":  verwerkInput_a5();
                     break;
            case "a6":  verwerkInput_a6();
                     break;
            
            case "k1":  verwerkInput_k1();
                     break;
            case "k2":  verwerkInput_k2();
                     break;
            case "k3":  verwerkInput_k3();
                     break;
            case "k4":  verwerkInput_k4();
                     break;
            case "k5":  verwerkInput_k5();
                     break;
            case "k6":  verwerkInput_k6();
                     break;
            case "b1":  verwerkInput_b1();
                     break;
            case "b2":  verwerkInput_b2();
                     break;
            case "b3":  verwerkInput_b3();
                     break;
            case "b4":  verwerkInput_b4();
                     break;
        
            
            
            default: verwerkInput_menu();
                     break;
        }         
                     
        
    }
    
    private void verwerkInput_menu(){
        view.menuScreen();
    }
    
    private void verwerkInput_ma(){
        model.maakAccount();
        System.out.println("Account aangemaakt");
    }
    
    private void printArtikel (Artikel artikel){
        view.printOutput("--------------------------");
        view.printOutput("idArtikel = " +artikel.getIdArtikel());
        view.printOutput("Naam = " +artikel.getNaam());
        view.printOutput("Prijs = " +artikel.getPrijs());
        view.printOutput("Voorraad = " +artikel.getVoorraad());
        view.printOutput("--------------------------");
    }
    
    private void printArtikelen (List<Artikel> artikelen){
        for (Artikel artikel : artikelen){
            printArtikel (artikel);
        }
    }
    
    private void printKlant (Klant klant){
        view.printOutput("--------------------------");
        view.printOutput("idKlant = " +klant.getIdKlant());
        view.printOutput("Voornaam = " +klant.getVoornaam());
        view.printOutput("Achternaam = " +klant.getAchternaam());
        view.printOutput("Tussenvoegsel = " +klant.getTussenvoegsel());
        view.printOutput("Telefoonnummer = " +klant.getTelefoonnummer());
        view.printOutput("Emailadres = " +klant.getEmailadres());
        view.printOutput("--------------------------");
    }
    
    private void printKlanten (List<Klant> klanten){
        for (Klant klant : klanten){
            printKlant (klant);
        }
    }
    
    
    
   // private void verwerkInput_db(){
   //     System.out.println("verwerk db");
   //     view.menuDB();
   //     String database = view.getUserInputDatabase(); 
   //     model.setDatabase(stringToDatabase.toDatabase(database));
   // }
    
    
    
    private void verwerkInput_a1(){
        System.out.println("verwerk a1");
        view.menuA1();
        int idArtikel = view.getUserInputIdArtikel();
        boolean exists = model.existsByIdArtikel(idArtikel);
        while (!exists){
            view.printOutput("Dit idArtikel bestaat niet");
            view.menuA1();
            idArtikel = view.getUserInputIdArtikel();
            exists = model.existsByIdArtikel(idArtikel);
        }
        Artikel artikel = model.readByIdArtikel(idArtikel);
        printArtikel(artikel);
    }
    
    private void verwerkInput_a2(){
        System.out.println("verwerk a2");
        view.menuA2();
        String naam = view.getUserInputNaam();
        boolean exists = model.existsByNameArtikel(naam);
        while (!exists){
            view.printOutput("Deze naam van het artikel bestaat niet");
            view.menuA2();
            naam = view.getUserInputNaam();
            exists = model.existsByNameArtikel(naam);
        }
        List<Artikel> artikelen = model.readByNameArtikel(naam);
        printArtikelen (artikelen);
    }
    
    private void verwerkInput_a3(){
        System.out.println("verwerk a3");
        List<Artikel> artikelen = model.readAllArtikel();
        printArtikelen (artikelen);
    }
    
    private void verwerkInput_a4(){
        System.out.println("verwerk a4");
        view.menuA4();
        String naam = view.getUserInputNaam();
        BigDecimal prijs = view.getUserInputPrijs();
        int voorraad = view.getUserInputVoorraad();
        model.createArtikel(naam, prijs, voorraad);
        
    }
    
    private void verwerkInput_a5(){
        System.out.println("verwerk a5");
        view.menuA5();
        int idArtikel = view.getUserInputIdArtikel();
        boolean exists = model.existsByIdArtikel(idArtikel);
        String naam = view.getUserInputNaam();
        BigDecimal prijs = view.getUserInputPrijs();
        int voorraad = view.getUserInputVoorraad();
        model.updateArtikel(idArtikel, naam, prijs, voorraad);
        if (exists) {
            view.printOutput("Artikel is gewijzigd.");
        }
        else {
           view.printOutput("idArtikel bestaat niet.");
        }
    }
    
    private void verwerkInput_a6(){
        System.out.println("verwerk a6");
        view.menuA6();
        int idArtikel = view.getUserInputIdArtikel();
        boolean exists = model.existsByIdArtikel(idArtikel);
        while (!exists){
            view.printOutput("Dit idArtikel bestaat niet");
            view.menuA6();
            idArtikel = view.getUserInputIdArtikel();
            exists = model.existsByIdArtikel(idArtikel);
        }
        idArtikel = view.getUserInputIdArtikel();
        exists = model.existsBestelArtikelByIdArtikel(idArtikel);
        while (exists){
            view.printOutput("Dit artikel wordt in bestellingen gebruikt");
            view.menuA6();
            idArtikel = view.getUserInputIdArtikel();
            exists = model.existsBestelArtikelByIdArtikel(idArtikel);
        }
        
        model.deleteArtikel(idArtikel);
        view.printOutput("Artikel is verwijderd.");
        
    }
    
    private void verwerkInput_k1(){
        System.out.println("verwerk k1");
        view.menuK1();
        int idKlant = view.getUserInputIdklant();
        boolean exists = model.existsByIDKlant(idKlant);
        while (!exists){
            view.printOutput("Dit idKlant bestaat niet");
            view.menuK1();
            idKlant = view.getUserInputIdklant();
            exists = model.existsByIDKlant(idKlant);
        }
        Klant klant = model.readByIDKlant(idKlant);
        printKlant (klant);
    }
    
    private void verwerkInput_k2(){
        System.out.println("verwerk k2");
        view.menuK2();
        String achternaam = view.getUserInputAchternaam();
        boolean exists = model.existsByAchternaamKlant(achternaam);
        while (!exists){
            view.printOutput("Deze achternaam bestaat niet");
            view.menuK2();
            achternaam = view.getUserInputAchternaam();
            exists = model.existsByAchternaamKlant(achternaam);
        }
        List<Klant> klanten = model.readByAchternaamKlant(achternaam);
        printKlanten (klanten);
        
    }
    
    private void verwerkInput_k3(){
        System.out.println("verwerk k3");
        List<Klant> klanten = model.readAllKlant();
        printKlanten (klanten);
    }
    
    private void verwerkInput_k4(){
        System.out.println("verwerk k4");
        view.menuK4();
        String voornaam = view.getUserInputVoornaam();
        String achternaam = view.getUserInputAchternaam();
        String tussenvoegsel = view.getUserInputTussenvoegsel();
        String telefoonnummer = view.getUserInputTelefoonnummer();
        String emailadres = view.getUserInputEmailadres();
        model.createKlant(voornaam, achternaam, tussenvoegsel, telefoonnummer, emailadres);
        
        
    }
    
    private void verwerkInput_k5(){
        System.out.println("verwerk k5");
        view.menuK5();
        int idKlant = view.getUserInputIdklant();
        boolean exists = model.existsByIDKlant(idKlant);
        String voornaam = view.getUserInputVoornaam();
        String achternaam = view.getUserInputAchternaam();
        String tussenvoegsel = view.getUserInputTussenvoegsel();
        String telefoonnummer = view.getUserInputTelefoonnummer();
        String emailadres = view.getUserInputEmailadres();
        model.updateKlant(idKlant, voornaam, achternaam, tussenvoegsel, telefoonnummer, emailadres);
        if (exists) {
            view.printOutput("Klant is gewijzigd.");
        }
        else {
           view.printOutput("idKlant bestaat niet.");
        }
    }
    
    private void verwerkInput_k6(){
        System.out.println("verwerk k6");
        view.menuK6();
        int idKlant = view.getUserInputIdklant();
        boolean exists = model.existsByIDKlant(idKlant);
        while (!exists){
            view.printOutput("Deze idKlant bestaat niet");
            view.menuK6();
            idKlant = view.getUserInputIdklant();
            exists = model.existsByIDKlant(idKlant);
        }
        
        
        idKlant = view.getUserInputIdklant();
        exists = model.existsBestellingByIdKlant(idKlant);
        while (exists){
            view.printOutput("De klant met dit idKlant heeft nog bestellingen");
            view.menuK6();
            idKlant = view.getUserInputIdklant();
            exists = model.existsBestellingByIdKlant(idKlant);
        }
      
        model.deleteKlant(idKlant);
        view.printOutput("Klant is verwijderd");
    }
    
    private void verwerkInput_b1(){
        System.out.println("verwerk b1");
        view.menuB1();
        int idKlant = view.getUserInputIdklant();
        boolean exists = model.existsByIDKlant(idKlant);
        while (!exists){
            view.printOutput("Deze idKlant bestaat niet");
            view.menuK6();
            idKlant = view.getUserInputIdklant();
            exists = model.existsByIDKlant(idKlant);
        }
        
        int idBestelling = model.createBestelling(idKlant,1);
        view.printOutput("De bestelling met idBestelling "+ idBestelling+ " voor klant "+idKlant+" is aangemaakt");
        
    }
    
   /* private void verwerkInput_b2(){
        System.out.println("verwerk b2");
        view.menuB2();
        int idBestelling = view.getUserInputIdBestelling();
        boolean exists = model.existsByIdBestelling(idBestelling);
        
        while (!exists){
            view.printOutput("Deze idBestelling bestaat niet");
            view.menuB2();
            idBestelling = view.getUserInputIdBestelling();
            exists = model.existsByIdBestelling(idBestelling);
        }
        
       // voer nu alle artikelen in met het aantal in een loop tot er een stop teken gegeven wordt
        view.printOutput("Voer nu alle idArtikel in. Om te stoppen geef idArtike 0");
        
        view.menuA1();
        int idArtikel = view.getUserInputIdArtikel();
        while (idArtikel != 0){
            exists = model.existsByIdArtikel(idArtikel);
            while (!exists){
                view.printOutput("Dit idArtikel bestaat niet");
                view.menuA1();
                idArtikel = view.getUserInputIdArtikel();
                exists = model.existsByIdArtikel(idArtikel);
            }
            
            
        }
        
        // nu aantal vragen
        
        
    }
    
    */
    
    private void verwerkInput_b2(){
        boolean existsIdArtikel;
        boolean existsIdBestelling;
        boolean genoegVoorraad;
        System.out.println("verwerk b2");
        view.menuB2();
        view.menuA1();
        view.askUserInputAantal("Welk aantal wilt u bestellen?");
        int idBestelling = view.getUserInputIdBestelling();
        int idArtikel = view.getUserInputIdArtikel();
        int aantal = view.getUserInputAantal();
        // check uitvoeren of idBestelling en idArtikel ook bestaat en of er genoeg voorraad is van het artikel
        existsIdArtikel = model.existsByIdArtikel(idArtikel);
        existsIdBestelling = model.existsByIdBestelling(idBestelling);
        while (!( existsIdArtikel && existsIdBestelling&& (aantal>0))){
            view.printOutput("Het idArtikel of idBestelling bestaat niet of het bestelde aantal klopt niet ");
            view.menuB2();
            view.menuA1();
            view.askUserInputAantal("Welk aantal wilt u bestellen?");
            idBestelling = view.getUserInputIdBestelling();
            idArtikel = view.getUserInputIdArtikel();
            aantal = view.getUserInputAantal();
        }
        // check of er genoeg vooraad is van het artikel
        Artikel artikel = model.readByIdArtikel(idArtikel);
        int voorraad = artikel.getVoorraad();
        if (voorraad >= aantal){
            // verwerken in bestelartikel d.w.z. een bestelartikel record aanmaken
            model.createBestelArtikel(idBestelling, idArtikel, aantal);
            
            // pas de voorraad van het artikel aan
            model.updateVoorraadArtikel(idArtikel, voorraad-aantal);
            
        }
        else {
            view.printOutput("Er is niet genoeg voorraad van dit artikel voor het bestelde aantal");
        }
        
    }
    private void verwerkInput_b3(){
        System.out.println("verwerk b3");
        view.menuB3();
        view.menuA1();
        int idBestelling = view.getUserInputIdBestelling();
        int idArtikel = view.getUserInputIdArtikel();
        boolean exists = model.existsByIdBestellingIdArtikel(idBestelling, idArtikel);
        BestelArtikel bestelArtikel = model.readByIdBestellingIdArtikel(idBestelling, idArtikel);
        int aantal = bestelArtikel.getAantal();
        if (exists){
            model.deleteBestelArtikel(idBestelling, idArtikel);
            
            model.verhoogVoorraadArtikel(idArtikel, aantal);
        }
        else {
            view.printOutput("De gevraagde combinatie van bestelling en artikel bestaat niet.");
        }
        
    }
    
    private void verwerkInput_b4(){
        System.out.println("verwerk b4");
        view.menuB4();
        int idKlant = view.getUserInputIdklant();
        boolean exists = model.existsByIDKlant(idKlant);
        while (!exists){
            view.printOutput("Dit idKlant bestaat niet");
            view.menuK1();
            idKlant = view.getUserInputIdklant();
            exists = model.existsByIDKlant(idKlant);
        }
        // kijken of de klant bestellingen heeft
        exists = model.existsBestellingByIdKlant(idKlant);
        if (!exists){
            view.printOutput("Deze klant heeft geen bestellingen");
            return;
        }
        
        
        // nu alle bestelling van deze klant laten zien
        
        List <Bestelling> bestellingen = model.readByIdKlantBestelling(idKlant);
        // nu voor elke bestelling alle bijbehorende bestelartikel record weergeven
        
        for (Bestelling bestelling: bestellingen){
            view.printOutput("idKlant ="+ bestelling.getIdKlant() );
            view.printOutput("idbestelling ="+ bestelling.getIdBestelling() );
            
            List<BestelArtikel> bestelArtikelen = model.readByIdBestellingBestelArtikel(bestelling.getIdBestelling());
            // druk nu alle informatie af van de bijbehorende records van bestelartikel 
            for (BestelArtikel x: bestelArtikelen){
                view.printOutput("");
                view.printOutput("-------------------------------");
                view.printOutput("idBestelling = "+x.getIdBestelling());
                view.printOutput("idArtikel = "+x.getIdArtikel());
                view.printOutput("aantal = " + x.getAantal());
                view.printOutput("-------------------------------");
            }
        }
        
    }
    
    
    
    
   
    
    
    
    public void run(){
        String userInput="";
        // eerste even vragen welke database je wil gebruiken
        //verwerkInput_db();
        
        view.startScreen();
        view.menuScreen();
        while (!(userInput.equalsIgnoreCase("exit"))){
            view.askUserInput("Welke menu optie?");
            userInput = view.getUserInput();
            verwerkInput(userInput);
        }
        view.endScreen();
    }
    
    
    
    
}
