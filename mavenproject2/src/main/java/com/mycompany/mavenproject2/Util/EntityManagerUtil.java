/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.Util;

/**
 *
 * @author robertrook
 */



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EntityManagerUtil {
	
	private static final EntityManagerFactory entityManagerFactory;
	  static {
            try {
              System.out.println("Robert1 in EntityManagerUtil");
	      entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
	      System.out.println("Robert2 in EntityManagerUtil");

	    } catch (Throwable ex) {	      
	      throw new ExceptionInInitializerError(ex);
	    }
	  }

	  public static EntityManager getEntityManager() {
	    return entityManagerFactory.createEntityManager();

	  }
	}


