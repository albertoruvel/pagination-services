/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services.app.dto;

/**
 *
 * @author MACARENA
 */
public class PageNotFound {
    private String date; 
    private String message; 
    private Status status; 

    public PageNotFound() {
    }

    public PageNotFound(String date, String message, Status status) {
        this.date = date;
        this.message = message;
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    public static enum Status{
        
        PAGE_NUMBER("Error with pageNumber parameter"), 
        PAGE_SIZE("Error with pageSize parameter"), 
        SERVER_ERROR("Error getting data"); 
        
        String value; 
        
        Status(String value){
            this.value = value; 
        }
        
        @Override
        public String toString(){
            return value; 
        }
    }
    
}
