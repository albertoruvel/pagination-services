/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services.app.client.test;

import com.services.app.client.Page;
import com.services.app.client.Person;
import com.services.app.client.PersonEndpoint;
import com.services.app.client.PersonsEndpoint;

/**
 *
 * @author MACARENA
 */
public class PaginationSOAPClientTest {

    private static int PAGE_SIZE = 100;
    private static int PAGE_NUMBER = 1;

    public static void main(String[] args) {
        PersonEndpoint endpoint = new PersonsEndpoint()
                .getPersonEndpointPort();
        if (endpoint != null) {
            System.out.println("----------------------Starting to get pages");
            System.out.println("--------------Page Size: " + PAGE_SIZE);

            
                Page page = null;
                int pagesAvailable = -1; 
                Z:while(true) {
                    
                    page = endpoint.getPersonsPage(PAGE_SIZE, PAGE_NUMBER);
                    //print the page 
                    System.out.println("-------Page: " + PAGE_NUMBER);
                    
                    Y:for (Object o : page.getItems()) {
                        if (o != null) {
                            printPerson((Person) o);
                        }else break Z;
                    }
                    if(page.getPagesAvailable() == 0)
                        break; 
                    PAGE_NUMBER++;
                }
            
        }
    }

    private static void printPerson(Person person) {
        System.out.println("Person: \nID: " + person.getId() + "\nName: " + person.getName());
    }
}
