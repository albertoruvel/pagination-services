/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services.app.repository.exception;

import com.services.app.dto.PageNotFound;

/**
 *
 * @author MACARENA
 */
public class NoPageAvailableException extends Exception{

    private PageNotFound entity; 
    
    public NoPageAvailableException(String message) {
        super(message);
    }

    public NoPageAvailableException(PageNotFound entity) {
        super(entity.getDate()); 
        this.entity = entity;
        System.out.println("Creating new NoPageAvailableException: \nMessage: " + entity.getMessage() +
                            "\nStatus: " + entity.getStatus());
    }

    public PageNotFound getEntity() {
        return entity;
    }
}
