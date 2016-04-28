
package com.services.app.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.services.app.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetPersonsPage_QNAME = new QName("http://pagination.services.com", "getPersonsPage");
    private final static QName _GetPersonsPageResponse_QNAME = new QName("http://pagination.services.com", "getPersonsPageResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.services.app.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPersonsPage }
     * 
     */
    public GetPersonsPage createGetPersonsPage() {
        return new GetPersonsPage();
    }

    /**
     * Create an instance of {@link GetPersonsPageResponse }
     * 
     */
    public GetPersonsPageResponse createGetPersonsPageResponse() {
        return new GetPersonsPageResponse();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link Page }
     * 
     */
    public Page createPage() {
        return new Page();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonsPage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pagination.services.com", name = "getPersonsPage")
    public JAXBElement<GetPersonsPage> createGetPersonsPage(GetPersonsPage value) {
        return new JAXBElement<GetPersonsPage>(_GetPersonsPage_QNAME, GetPersonsPage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonsPageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pagination.services.com", name = "getPersonsPageResponse")
    public JAXBElement<GetPersonsPageResponse> createGetPersonsPageResponse(GetPersonsPageResponse value) {
        return new JAXBElement<GetPersonsPageResponse>(_GetPersonsPageResponse_QNAME, GetPersonsPageResponse.class, null, value);
    }

}
