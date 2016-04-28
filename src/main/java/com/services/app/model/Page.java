/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services.app.model;

import java.util.List;

/**
 *
 * @author MACARENA
 */
public class Page<T> {
    private List<T> items; 
    private int pageSize; 
    private int pageNumber; 
    private int pagesAvailable; 

    public Page() {
    }

    public Page(List<T> items, int pageSize, int pageNumber, int pagesAvailable) {
        this.items = items;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.pagesAvailable = pagesAvailable; 
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPagesAvailable() {
        return pagesAvailable;
    }

    public void setPagesAvailable(int pagesAvailable) {
        this.pagesAvailable = pagesAvailable;
    }
    
    
}
