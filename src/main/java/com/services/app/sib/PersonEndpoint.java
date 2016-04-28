/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services.app.sib;

import com.services.app.model.Page;
import com.services.app.model.Person;
import com.services.app.repository.PersonRepository;
import com.services.app.repository.exception.NoPageAvailableException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.BindingType;

/**
 *
 * @author MACARENA
 */
@WebService(targetNamespace = "http://pagination.services.com", 
            serviceName = "PersonsEndpoint")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED, 
             style = SOAPBinding.Style.DOCUMENT,
             use = SOAPBinding.Use.LITERAL)
public class PersonEndpoint {
    
    @Inject
    private PersonRepository repository; 
    
    
    @WebMethod(operationName = "getPersonsPage")
    @WebResult(partName = "Persons",
               targetNamespace =  "http://pagination.services.com")
    public Page<Person> getPersonsPage(@WebParam(mode = WebParam.Mode.IN, name = "pageSize")int pageSize, 
                                       @WebParam(mode = WebParam.Mode.IN, name = "pageNumber")int pageNumber){
        Page<Person> page = null; 
        try{
            page = repository.getPersonsPage(pageSize, pageNumber); 
        }catch(NoPageAvailableException ex){
            page = new Page<Person>(Collections.synchronizedList(new ArrayList<Person>()), 0, 0, 0); 
        }
        
        return page; 
    }
}
