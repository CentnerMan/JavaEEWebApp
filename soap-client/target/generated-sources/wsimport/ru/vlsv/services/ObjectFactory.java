
package ru.vlsv.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.vlsv.services package. 
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

    private final static QName _FindAllDTOResponse_QNAME = new QName("http://services.vlsv.ru/", "findAllDTOResponse");
    private final static QName _FindDTOByIdResponse_QNAME = new QName("http://services.vlsv.ru/", "findDTOByIdResponse");
    private final static QName _FindDTOById_QNAME = new QName("http://services.vlsv.ru/", "findDTOById");
    private final static QName _FindAllDTO_QNAME = new QName("http://services.vlsv.ru/", "findAllDTO");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.vlsv.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindAllDTO }
     * 
     */
    public FindAllDTO createFindAllDTO() {
        return new FindAllDTO();
    }

    /**
     * Create an instance of {@link FindAllDTOResponse }
     * 
     */
    public FindAllDTOResponse createFindAllDTOResponse() {
        return new FindAllDTOResponse();
    }

    /**
     * Create an instance of {@link FindDTOByIdResponse }
     * 
     */
    public FindDTOByIdResponse createFindDTOByIdResponse() {
        return new FindDTOByIdResponse();
    }

    /**
     * Create an instance of {@link FindDTOById }
     * 
     */
    public FindDTOById createFindDTOById() {
        return new FindDTOById();
    }

    /**
     * Create an instance of {@link ProductDTO }
     * 
     */
    public ProductDTO createProductDTO() {
        return new ProductDTO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllDTOResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.vlsv.ru/", name = "findAllDTOResponse")
    public JAXBElement<FindAllDTOResponse> createFindAllDTOResponse(FindAllDTOResponse value) {
        return new JAXBElement<FindAllDTOResponse>(_FindAllDTOResponse_QNAME, FindAllDTOResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindDTOByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.vlsv.ru/", name = "findDTOByIdResponse")
    public JAXBElement<FindDTOByIdResponse> createFindDTOByIdResponse(FindDTOByIdResponse value) {
        return new JAXBElement<FindDTOByIdResponse>(_FindDTOByIdResponse_QNAME, FindDTOByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindDTOById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.vlsv.ru/", name = "findDTOById")
    public JAXBElement<FindDTOById> createFindDTOById(FindDTOById value) {
        return new JAXBElement<FindDTOById>(_FindDTOById_QNAME, FindDTOById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.vlsv.ru/", name = "findAllDTO")
    public JAXBElement<FindAllDTO> createFindAllDTO(FindAllDTO value) {
        return new JAXBElement<FindAllDTO>(_FindAllDTO_QNAME, FindAllDTO.class, null, value);
    }

}
