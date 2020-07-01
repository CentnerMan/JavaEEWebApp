package ru.vlsv;

import ru.vlsv.services.ProductService;
import ru.vlsv.services.ProductServiceWs;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * GeekBrains Java, JavaEEWebApp.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 30.06.2020
 * @link https://github.com/Centnerman
 */

public class WsClient {
    public static void main(String[] args) throws MalformedURLException {

        URL url = new URL("http://localhost:8080/JavaEEWebApp/ProductService/ProductServiceLocalImpl?wsdl");
        ProductService productService = new ProductService(url);
        ProductServiceWs servicePort = productService.getProductServiceLocalImplPort();

        servicePort.findAllDTO().forEach(p -> System.out.println("Name: " + p.getName() + ", Description: " + p.getDescription()
                + ", Price: " + p.getPrice()));
    }
}
