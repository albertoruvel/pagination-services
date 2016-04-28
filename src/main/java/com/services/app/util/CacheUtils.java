/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services.app.util;

import com.services.app.model.Person;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author MACARENA
 */
public class CacheUtils {
    private static final Person[] persons; 
    private static final int COUNT = 932; 
    //adds 5,000 persons
    static{
        System.out.println("Creating cached persons");
        persons = new Person[COUNT]; 
        
        //add 5,000 persons 
        for (int i = 0; i < COUNT; i++) {
            persons[i] = new Person("PersonName" + i); 
        }
    }

    public static Person[] getPersons() {
        return persons;
    }
    
    
    
    
}
