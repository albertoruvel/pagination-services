/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services.app.repository;

import com.services.app.model.Page;
import com.services.app.model.Person;
import com.services.app.repository.exception.NoPageAvailableException;

/**
 *
 * @author MACARENA
 */
public interface PersonRepository {
    public Page<Person> getPersonsPage(int pageSize, int pageNumber) throws NoPageAvailableException; 
    public Page<Person> getPersonsPage(int pageNumber) throws NoPageAvailableException;
}
