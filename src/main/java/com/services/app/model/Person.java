/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services.app.model;

import java.util.UUID;

/**
 *
 * @author MACARENA
 */
public class Person {
    
    private String id; 
    private String name; 

    public Person() {
        id = UUID.randomUUID().toString(); 
    }
    
    public Person(String name){
        this.name = name; 
        this.id = UUID.randomUUID().toString(); 
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
