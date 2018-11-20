/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsystem.helper;

import java.util.Random;

/**
 *
 * @author Omar
 */
public class RandomNumber {
    
    public int randomNumber(){
        Random r = new Random();
        int valorEntero = r.nextInt(100)+50;
        return valorEntero;         
    }
    
    public String getPassword(String carnet){
        String Strnumber = String.valueOf(randomNumber());
        return carnet + Strnumber;
        
    }
    
}
