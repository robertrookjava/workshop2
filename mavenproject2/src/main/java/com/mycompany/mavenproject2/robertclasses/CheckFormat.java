/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.robertclasses;
import java.math.BigDecimal;
import org.apache.commons.validator.routines.*;

/**
 *
 * @author robertrook
 */
public class CheckFormat {
    
    
    
    
    // format checks methods
    
    
    
    public static boolean isInteger (String str) {
        try {
            Integer.parseInt(str);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
   
    
    public static boolean isBigDecimal (String str) {
        try {
            BigDecimal bigdecimal = new BigDecimal (str);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
     
    /*public static Integer isInteger (String str) {
        IntegerValidator validator = IntegerValidator.getInstance();
        Integer fooInteger = validator.validate(str );
        return fooInteger;
    }
*/
    
    /*public static boolean isBigDecimal (String str) {
     
        BigDecimalValidator validator = BigDecimalValidator.getInstance();
        BigDecimal fooBigDecimal = validator.validate(str );
        return (fooBigDecimal != null);
       
    }
*/
    
    public static boolean isEmailAdres (String str){
        EmailValidator validator = EmailValidator.getInstance();
        return (validator.isValid(str));
    }
    
    public static boolean isDatabase (String str){
        boolean isMySql = (str.equalsIgnoreCase("MySql"));
        boolean isOracle = (str.equalsIgnoreCase("Oracle")); 
        boolean isValid = (isMySql || isOracle);
        return isValid;
    }
    
    
}
