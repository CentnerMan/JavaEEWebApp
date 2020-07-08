package ru.vlsv.services;

import ru.vlsv.entity.ProductDTO;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * GeekBrains Java, JavaEEWebApp.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 29.06.2020
 * @link https://github.com/Centnerman
 */

@WebService
public interface ProductServiceWs {

    @WebMethod
    void insertDTO(ProductDTO product);

    @WebMethod
    void updateDTO(ProductDTO product);

    @WebMethod
    void delete(Long id);

    @WebMethod
    ProductDTO findDTOById(Long id);

    @WebMethod
    List<ProductDTO> findAllDTO();

}
