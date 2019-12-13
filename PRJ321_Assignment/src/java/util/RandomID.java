/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Random;

/**
 *
 * @author Admin
 */
public class RandomID {
     public String randomID(){
        String id = "";
        
        Random r = new Random();
        int count = 0;
        while(count < 10){
            id += String.valueOf(r.nextInt(10));
            count++;
        }
        return id;
    }
}
