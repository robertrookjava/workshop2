/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;
import com.mycompany.mavenproject2.model.Model;
import com.mycompany.mavenproject2.view.View;
import com.mycompany.mavenproject2.controller.Controller;
import java.math.BigDecimal;
import java.sql.*;
import com.mycompany.mavenproject2.robertclasses.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.mycompany.mavenproject2.Util.Config;



/**
 *
 * @author robertrook
 */
public class Application {
    
    private static boolean test = false;
    
    public static void main(String[] args) {
      
      if (test){
          Test.test();
      }
      else {
          run();
      } 
      
      
    }
    
    public static void run(){
        
        Logger logger = LoggerFactory.getLogger(Application.class);
        logger.trace("Hello World");
        logger.debug("Hello World");
        logger.info("Hello World");
        logger.warn("Hello World");
        logger.error("Hello World");
        
        //Model model = new Model();
        //View view = new View ();
        //Controller controller = new Controller ();
        //controller.run();
        
        AnnotationConfigApplicationContext context = 
        new AnnotationConfigApplicationContext();
        
        context.register(Config.class);
        context.refresh();

        //MediaPlayer mediaplayer = context.getBean(MediaPlayer.class);
        //mediaplayer.play();
        
        Controller controller = context.getBean(Controller.class);
        controller.run();
    }
    
    
    
    
    
    
    
    
   
}
