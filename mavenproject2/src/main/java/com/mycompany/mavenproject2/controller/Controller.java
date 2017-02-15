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
import com.mycompany.mavenproject2.modelinterface.*;
import com.mycompany.mavenproject2.viewinterface.ViewInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;



/**
 *
 * @author robertrook
 */
@Component
public class Controller {
    
    @Autowired
    private AccountModelInterface accountModelInterface;
    
    @Autowired
    private ArtikelModelInterface artikelModelInterface;
    
    @Autowired
    private BestelArtikelModelInterface bestelArtikelModelInterface;
    
    
    @Autowired
    private BestellingModelInterface bestellingModelInterface;
    
    
    
    @Autowired
    private KlantModelInterface klantModelInterface;
    
    @Autowired
    private ViewInterface viewInterface;
    
    
    public void setAccountModelInterface (AccountModelInterface accountModelInterface){
        this.accountModelInterface=accountModelInterface;
    }
    
    public AccountModelInterface getAccountModelInterface (){
        return this.accountModelInterface;
    }
    
    public void setArtikelModelInterface (ArtikelModelInterface artikelModelInterface){
        this.artikelModelInterface=artikelModelInterface;
    }
    
    public ArtikelModelInterface getArtikelModelInterfac (){
        return this.artikelModelInterface;
    }
    
    public void setBestelArtikelModelInterface (BestelArtikelModelInterface bestelArtikelModelInterface){
        this.bestelArtikelModelInterface=bestelArtikelModelInterface;
    }
    
    public BestelArtikelModelInterface getBestelArtikelModelInterface (){
        return this.bestelArtikelModelInterface;
    }
    
    public void BestellingModelInterface (BestellingModelInterface bestellingModelInterface){
        this.bestellingModelInterface=bestellingModelInterface;
    }
    
    public BestellingModelInterface getBestellingModelInterface (){
        return this.bestellingModelInterface;
    }
    
    public void setKlantModelInterface (KlantModelInterface klantModelInterface){
        this.klantModelInterface=klantModelInterface;
    }
    
    public KlantModelInterface getKlantModelInterface (){
        return this.klantModelInterface;
    }
    
    public void setViewInterface (ViewInterface viewInterface){
        this.viewInterface = viewInterface;
    }
    
    public ViewInterface getViewInterface(){
        return this.viewInterface;
    }
    
    
            
            
    
    //private View view = new View();
    private boolean exit = false;
   
    
    public Controller() {
        
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
        viewInterface.menuScreen();
    }
    
    private void verwerkInput_ma(){
        accountModelInterface.maakAccount();
        System.out.println("Account aangemaakt");
    }
    
    private void printArtikel (Artikel artikel){
        viewInterface.printOutput("--------------------------");
        viewInterface.printOutput("idArtikel = " +artikel.getIdArtikel());
        viewInterface.printOutput("Naam = " +artikel.getNaam());
        viewInterface.printOutput("Prijs = " +artikel.getPrijs());
        viewInterface.printOutput("Voorraad = " +artikel.getVoorraad());
        viewInterface.printOutput("--------------------------");
    }
    
    private void printArtikelen (List<Artikel> artikelen){
        for (Artikel artikel : artikelen){
            printArtikel (artikel);
        }
    }
    
    private void printKlant (Klant klant){
        viewInterface.printOutput("--------------------------");
        viewInterface.printOutput("idKlant = " +klant.getIdKlant());
        viewInterface.printOutput("Voornaam = " +klant.getVoornaam());
        viewInterface.printOutput("Achternaam = " +klant.getAchternaam());
        viewInterface.printOutput("Tussenvoegsel = " +klant.getTussenvoegsel());
        viewInterface.printOutput("Telefoonnummer = " +klant.getTelefoonnummer());
        viewInterface.printOutput("Emailadres = " +klant.getEmailadres());
        viewInterface.printOutput("--------------------------");
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
        viewInterface.menuA1();
        int idArtikel = viewInterface.getUserInputIdArtikel();
        boolean exists = artikelModelInterface.existsByIdArtikel(idArtikel);
        while (!exists){
            viewInterface.printOutput("Dit idArtikel bestaat niet");
            viewInterface.menuA1();
            idArtikel = viewInterface.getUserInputIdArtikel();
            exists = artikelModelInterface.existsByIdArtikel(idArtikel);
        }
        Artikel artikel = artikelModelInterface.readByIdArtikel(idArtikel);
        printArtikel(artikel);
    }
    
    private void verwerkInput_a2(){
        System.out.println("verwerk a2");
        viewInterface.menuA2();
        String naam = viewInterface.getUserInputNaam();
        boolean exists = artikelModelInterface.existsByNameArtikel(naam);
        while (!exists){
            viewInterface.printOutput("Deze naam van het artikel bestaat niet");
            viewInterface.menuA2();
            naam = viewInterface.getUserInputNaam();
            exists = artikelModelInterface.existsByNameArtikel(naam);
        }
        List<Artikel> artikelen = artikelModelInterface.readByNameArtikel(naam);
        printArtikelen (artikelen);
    }
    
    private void verwerkInput_a3(){
        System.out.println("verwerk a3");
        List<Artikel> artikelen = artikelModelInterface.readAllArtikel();
        printArtikelen (artikelen);
    }
    
    private void verwerkInput_a4(){
        System.out.println("verwerk a4");
        viewInterface.menuA4();
        String naam = viewInterface.getUserInputNaam();
        BigDecimal prijs = viewInterface.getUserInputPrijs();
        int voorraad = viewInterface.getUserInputVoorraad();
        artikelModelInterface.createArtikel(naam, prijs, voorraad);
        
    }
    
    private void verwerkInput_a5(){
        System.out.println("verwerk a5");
        viewInterface.menuA5();
        int idArtikel = viewInterface.getUserInputIdArtikel();
        boolean exists = artikelModelInterface.existsByIdArtikel(idArtikel);
        String naam = viewInterface.getUserInputNaam();
        BigDecimal prijs = viewInterface.getUserInputPrijs();
        int voorraad = viewInterface.getUserInputVoorraad();
        artikelModelInterface.updateArtikel(idArtikel, naam, prijs, voorraad);
        if (exists) {
            viewInterface.printOutput("Artikel is gewijzigd.");
        }
        else {
           viewInterface.printOutput("idArtikel bestaat niet.");
        }
    }
    
    private void verwerkInput_a6(){
        System.out.println("verwerk a6");
        viewInterface.menuA6();
        int idArtikel = viewInterface.getUserInputIdArtikel();
        boolean exists = artikelModelInterface.existsByIdArtikel(idArtikel);
        while (!exists){
            viewInterface.printOutput("Dit idArtikel bestaat niet");
            viewInterface.menuA6();
            idArtikel = viewInterface.getUserInputIdArtikel();
            exists = artikelModelInterface.existsByIdArtikel(idArtikel);
        }
        idArtikel = viewInterface.getUserInputIdArtikel();
        exists = klantModelInterface.existsBestelArtikelByIdArtikel(idArtikel);
        while (exists){
            viewInterface.printOutput("Dit artikel wordt in bestellingen gebruikt");
            viewInterface.menuA6();
            idArtikel = viewInterface.getUserInputIdArtikel();
            exists = klantModelInterface.existsBestelArtikelByIdArtikel(idArtikel);
        }
        
        artikelModelInterface.deleteArtikel(idArtikel);
        viewInterface.printOutput("Artikel is verwijderd.");
        
    }
    
    private void verwerkInput_k1(){
        System.out.println("verwerk k1");
        viewInterface.menuK1();
        int idKlant = viewInterface.getUserInputIdklant();
        boolean exists = klantModelInterface.existsByIDKlant(idKlant);
        while (!exists){
            viewInterface.printOutput("Dit idKlant bestaat niet");
            viewInterface.menuK1();
            idKlant = viewInterface.getUserInputIdklant();
            exists = klantModelInterface.existsByIDKlant(idKlant);
        }
        Klant klant = klantModelInterface.readByIDKlant(idKlant);
        printKlant (klant);
    }
    
    private void verwerkInput_k2(){
        System.out.println("verwerk k2");
        viewInterface.menuK2();
        String achternaam = viewInterface.getUserInputAchternaam();
        boolean exists = klantModelInterface.existsByAchternaamKlant(achternaam);
        while (!exists){
            viewInterface.printOutput("Deze achternaam bestaat niet");
            viewInterface.menuK2();
            achternaam = viewInterface.getUserInputAchternaam();
            exists = klantModelInterface.existsByAchternaamKlant(achternaam);
        }
        List<Klant> klanten = klantModelInterface.readByAchternaamKlant(achternaam);
        printKlanten (klanten);
        
    }
    
    private void verwerkInput_k3(){
        System.out.println("verwerk k3");
        List<Klant> klanten = klantModelInterface.readAllKlant();
        printKlanten (klanten);
    }
    
    private void verwerkInput_k4(){
        System.out.println("verwerk k4");
        viewInterface.menuK4();
        String voornaam = viewInterface.getUserInputVoornaam();
        String achternaam = viewInterface.getUserInputAchternaam();
        String tussenvoegsel = viewInterface.getUserInputTussenvoegsel();
        String telefoonnummer = viewInterface.getUserInputTelefoonnummer();
        String emailadres = viewInterface.getUserInputEmailadres();
        klantModelInterface.createKlant(voornaam, achternaam, tussenvoegsel, telefoonnummer, emailadres);
        
        
    }
    
    private void verwerkInput_k5(){
        System.out.println("verwerk k5");
        viewInterface.menuK5();
        int idKlant = viewInterface.getUserInputIdklant();
        boolean exists = klantModelInterface.existsByIDKlant(idKlant);
        String voornaam = viewInterface.getUserInputVoornaam();
        String achternaam = viewInterface.getUserInputAchternaam();
        String tussenvoegsel = viewInterface.getUserInputTussenvoegsel();
        String telefoonnummer = viewInterface.getUserInputTelefoonnummer();
        String emailadres = viewInterface.getUserInputEmailadres();
        klantModelInterface.updateKlant(idKlant, voornaam, achternaam, tussenvoegsel, telefoonnummer, emailadres);
        if (exists) {
            viewInterface.printOutput("Klant is gewijzigd.");
        }
        else {
           viewInterface.printOutput("idKlant bestaat niet.");
        }
    }
    
    private void verwerkInput_k6(){
        System.out.println("verwerk k6");
        viewInterface.menuK6();
        int idKlant = viewInterface.getUserInputIdklant();
        boolean exists = klantModelInterface.existsByIDKlant(idKlant);
        while (!exists){
            viewInterface.printOutput("Deze idKlant bestaat niet");
            viewInterface.menuK6();
            idKlant = viewInterface.getUserInputIdklant();
            exists = klantModelInterface.existsByIDKlant(idKlant);
        }
        
        
        idKlant = viewInterface.getUserInputIdklant();
        exists = klantModelInterface.existsBestellingByIdKlant(idKlant);
        while (exists){
            viewInterface.printOutput("De klant met dit idKlant heeft nog bestellingen");
            viewInterface.menuK6();
            idKlant = viewInterface.getUserInputIdklant();
            exists = klantModelInterface.existsBestellingByIdKlant(idKlant);
        }
      
        klantModelInterface.deleteKlant(idKlant);
        viewInterface.printOutput("Klant is verwijderd");
    }
    
    private void verwerkInput_b1(){
        System.out.println("verwerk b1");
        viewInterface.menuB1();
        int idKlant = viewInterface.getUserInputIdklant();
        boolean exists = klantModelInterface.existsByIDKlant(idKlant);
        while (!exists){
            viewInterface.printOutput("Deze idKlant bestaat niet");
            viewInterface.menuK6();
            idKlant = viewInterface.getUserInputIdklant();
            exists = klantModelInterface.existsByIDKlant(idKlant);
        }
        
        int idBestelling = bestellingModelInterface.createBestelling(idKlant,1);
        viewInterface.printOutput("De bestelling met idBestelling "+ idBestelling+ " voor klant "+idKlant+" is aangemaakt");
        
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
        viewInterface.menuB2();
        viewInterface.menuA1();
        viewInterface.askUserInputAantal("Welk aantal wilt u bestellen?");
        int idBestelling = viewInterface.getUserInputIdBestelling();
        int idArtikel = viewInterface.getUserInputIdArtikel();
        int aantal = viewInterface.getUserInputAantal();
        // check uitvoeren of idBestelling en idArtikel ook bestaat en of er genoeg voorraad is van het artikel
        existsIdArtikel = artikelModelInterface.existsByIdArtikel(idArtikel);
        existsIdBestelling = bestellingModelInterface.existsByIdBestelling(idBestelling);
        while (!( existsIdArtikel && existsIdBestelling&& (aantal>0))){
            viewInterface.printOutput("Het idArtikel of idBestelling bestaat niet of het bestelde aantal klopt niet ");
            viewInterface.menuB2();
            viewInterface.menuA1();
            viewInterface.askUserInputAantal("Welk aantal wilt u bestellen?");
            idBestelling = viewInterface.getUserInputIdBestelling();
            idArtikel = viewInterface.getUserInputIdArtikel();
            aantal = viewInterface.getUserInputAantal();
        }
        // check of er genoeg vooraad is van het artikel
        Artikel artikel = artikelModelInterface.readByIdArtikel(idArtikel);
        int voorraad = artikel.getVoorraad();
        if (voorraad >= aantal){
            // verwerken in bestelartikel d.w.z. een bestelartikel record aanmaken
            bestelArtikelModelInterface.createBestelArtikel(idBestelling, idArtikel, aantal);
            
            // pas de voorraad van het artikel aan
            artikelModelInterface.updateVoorraadArtikel(idArtikel, voorraad-aantal);
            
        }
        else {
            viewInterface.printOutput("Er is niet genoeg voorraad van dit artikel voor het bestelde aantal");
        }
        
    }
    private void verwerkInput_b3(){
        System.out.println("verwerk b3");
        viewInterface.menuB3();
        viewInterface.menuA1();
        int idBestelling = viewInterface.getUserInputIdBestelling();
        int idArtikel = viewInterface.getUserInputIdArtikel();
        boolean exists = bestelArtikelModelInterface.existsByIdBestellingIdArtikel(idBestelling, idArtikel);
        BestelArtikel bestelArtikel = bestelArtikelModelInterface.readByIdBestellingIdArtikel(idBestelling, idArtikel);
        int aantal = bestelArtikel.getAantal();
        if (exists){
            bestelArtikelModelInterface.deleteBestelArtikel(idBestelling, idArtikel);
            
            artikelModelInterface.verhoogVoorraadArtikel(idArtikel, aantal);
        }
        else {
            viewInterface.printOutput("De gevraagde combinatie van bestelling en artikel bestaat niet.");
        }
        
    }
    
    private void verwerkInput_b4(){
        System.out.println("verwerk b4");
        viewInterface.menuB4();
        int idKlant = viewInterface.getUserInputIdklant();
        boolean exists = klantModelInterface.existsByIDKlant(idKlant);
        while (!exists){
            viewInterface.printOutput("Dit idKlant bestaat niet");
            viewInterface.menuK1();
            idKlant = viewInterface.getUserInputIdklant();
            exists = klantModelInterface.existsByIDKlant(idKlant);
        }
        // kijken of de klant bestellingen heeft
        exists = klantModelInterface.existsBestellingByIdKlant(idKlant);
        if (!exists){
            viewInterface.printOutput("Deze klant heeft geen bestellingen");
            return;
        }
        
        
        // nu alle bestelling van deze klant laten zien
        
       
        
        List <Bestelling> bestellingen = bestellingModelInterface.readByIdKlantBestelling(idKlant);
        // nu voor elke bestelling alle bijbehorende bestelartikel record weergeven
        
        for (Bestelling bestelling: bestellingen){
            viewInterface.printOutput("idKlant ="+ bestelling.getIdKlant() );
            viewInterface.printOutput("idbestelling ="+ bestelling.getIdBestelling() );
            
            List<BestelArtikel> bestelArtikelen = bestelArtikelModelInterface.readByIdBestellingBestelArtikel(bestelling.getIdBestelling());
            // druk nu alle informatie af van de bijbehorende records van bestelartikel 
            for (BestelArtikel x: bestelArtikelen){
                viewInterface.printOutput("");
                viewInterface.printOutput("-------------------------------");
                viewInterface.printOutput("idBestelling = "+x.getIdBestelling());
                viewInterface.printOutput("idArtikel = "+x.getIdArtikel());
                viewInterface.printOutput("aantal = " + x.getAantal());
                viewInterface.printOutput("-------------------------------");
            }
        }
        
    }
    
    
    
    
   
    
    
    
    public void run(){
        String userInput="";
        // eerste even vragen welke database je wil gebruiken
        //verwerkInput_db();
        
        viewInterface.startScreen();
        viewInterface.menuScreen();
        while (!(userInput.equalsIgnoreCase("exit"))){
            viewInterface.askUserInput("Welke menu optie?");
            userInput = viewInterface.getUserInput();
            verwerkInput(userInput);
        }
        viewInterface.endScreen();
    }
    
    
    
    
}
