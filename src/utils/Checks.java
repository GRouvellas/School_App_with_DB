/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author Geo
 */
public class Checks {

    static Scanner sc = new Scanner(System.in);

    //checks if a String x can be converted to an Integer Number. If it can the method returns true else it returns false
    public static boolean integerNum(String x) {
        try {
            int y = Integer.parseInt(x);
        } catch (NumberFormatException a) {
            return false;
        }
        return true;
    }

    //checks integerNum. Everytime it returns false it asks the user to insert a number
    public static String integerCheck(String x) {        
        do {
            if (integerNum(x) == false) {
                System.out.println("Incorrect Input. Please insert an integer number");
                x = sc.nextLine();
            }
        } while (integerNum(x) == false);
        return x;
    }
    
    //checks if a String x can be converted to a Float Number. If it can the method returns true else it returns false
    public static boolean floatNum(String x) {        
        try {
            float y = Float.parseFloat(x);
        } catch (NumberFormatException a) {
            return false;
        }
        return true;
    }

    //checks floatNum. Everytime it returns false it asks the user to insert a number
    public static String floatCheck(String x) {        
        do {
            if (floatNum(x) == false) {
                System.out.println("Incorrect Input. Please insert a number (use . for decimals)");
                x = sc.nextLine();
            }
        } while (floatNum(x) == false);
        return x;
    }
    
    //checks if a String x can be converted to LocalDate Number. If it can the method returns true else it returns false
    public static boolean isLocalDate(String x) {        
        try {
            LocalDate y = LocalDate.parse(x, DateTimeFormatter.ISO_DATE);
        } catch (DateTimeParseException a){
            return false;
        }return true;
    }
    
    //checks isLocalDate. Everytime it returns false it asks the user to insert a number
    public static String dateCheck (String x){        
        do{
            if(isLocalDate(x)==false){
                System.out.println("Incorrect Input. Please insert a date (use the format YYYY-MM-DD)");
                x = sc.nextLine();
            }
        }while (isLocalDate(x)==false); 
        return x;
    }
    
    
}