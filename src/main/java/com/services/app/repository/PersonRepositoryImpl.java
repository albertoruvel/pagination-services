/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services.app.repository;

import com.services.app.dto.PageNotFound;
import com.services.app.model.Page;
import com.services.app.model.Person;
import com.services.app.repository.exception.NoPageAvailableException;
import com.services.app.util.CacheUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *
 * @author MACARENA
 */
public class PersonRepositoryImpl implements PersonRepository{

    /**
     * default constructor
     */
    public PersonRepositoryImpl() {
    }

    
    
    /**
     * default page count size
     */
    public static Integer DEFAULT_PAGE_COUNT = 50; 
    
    /**
     * return a page using a page number and page size
     * @param pageSize
     * @param pageNumber
     * @return
     * @throws NoPageAvailableException 
     */
    @Override
    public Page<Person> getPersonsPage(int pageSize, int pageNumber) throws NoPageAvailableException{
        if(pageSize <= 0)
            throw new NoPageAvailableException(new PageNotFound(
                                                new Date().toString(), 
                                                "Page size not acceptable: " + pageSize, 
                                                PageNotFound.Status.PAGE_SIZE)); 
        else if(pageNumber <= 0)
            throw new NoPageAvailableException(new PageNotFound(
                                                new Date().toString(), 
                                                "Page number not acceptable: " + pageNumber, 
                                                PageNotFound.Status.PAGE_NUMBER)); 
        return getPage(pageNumber, pageSize); 
    }

    /**
     * returns a page using the page number and the default page count (50)
     * @param pageNumber
     * @return
     * @throws NoPageAvailableException 
     */
    @Override
    public Page<Person> getPersonsPage(int pageNumber) throws NoPageAvailableException{
        if(pageNumber <= 0)
            throw new NoPageAvailableException(new PageNotFound(
                                                new Date().toString(), 
                                                "Page number not acceptable: " + pageNumber, 
                                                PageNotFound.Status.PAGE_NUMBER)); 
        return getPage(pageNumber, DEFAULT_PAGE_COUNT);
    }
    
    
    /**
     * Filters a persons page using page number and size
     * @param pageNumber
     * @param pageSize
     * @return
     * @throws NoPageAvailableException 
     */
    private Page<Person> getPage(int pageNumber, int pageSize) throws NoPageAvailableException{
        //get count 
        int count = CacheUtils.getPersons().length; 
        System.out.println("Persons count: " + count);
        //get the number of pages 
        int pageCount = count / pageSize; 
        System.out.println("Total pages: " + pageCount);
        if(pageCount <= 0)
            pageCount = 1; 
        if(pageNumber > pageCount)
            throw new NoPageAvailableException(new PageNotFound(
                                                new Date().toString(), 
                                                "Page " + pageNumber + " not available", 
                                                PageNotFound.Status.PAGE_NUMBER)); 
        //if count > pageSize * pageCount, increment the pageCount to regularize 
        if(count > pageSize * pageCount)
            pageCount ++; 
        
        //get the initial row 
        int start = (pageNumber - 1) * pageSize; 
        System.out.println("Starting from row " + start);
        //TODO: Get the items starting from start variable to start + pageSize
        Person[] persons = Arrays.copyOfRange(CacheUtils.getPersons(),
                start, 
                start + pageSize); 
        //return a new page
        System.out.println("Returning persons page\n\n");
        return new Page<Person>(Arrays.asList(persons), pageSize, pageNumber, pageCount); 
    }
    
}
