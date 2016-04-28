/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services.app.resource;

import com.services.app.dto.PageNotFound;
import com.services.app.model.Page;
import com.services.app.model.Person;
import com.services.app.repository.PersonRepository;
import com.services.app.repository.exception.NoPageAvailableException;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author MACARENA
 */
@Path("/person")
public class PersonResource {
    
    @Inject
    private PersonRepository repository; 
    
    /**
     * return a persons page receiving page number and page size
     * as query parameter, returns "application/json" MIME type
     * @param pageSize
     * @param pageNumber
     * @return 
     */
    
    @GET
    @Path("/get")
    @Produces("application/json")
    public Response getPersons(@QueryParam("pageSize")int pageSize, 
                               @QueryParam("pageNumber")int pageNumber){
        Response payload = null; 
        Page<Person> persons = null; 
        try{
            System.out.println("Getting persons");
            persons = repository.getPersonsPage(pageSize, pageNumber);
            System.out.println("Creating payload");
            payload = Response.ok(persons)
                    .build(); 
        }catch(NoPageAvailableException ex){
            System.out.println("Exception: " + ex.getMessage());
            System.out.println("Creating payload");
            payload = Response.status(Response.Status.OK)
                    .entity(ex.getEntity())
                    .build();
        }
        return payload; 
    }
}
