package ru.vlsv.rest;

import ru.vlsv.entity.ProductDTO;

import javax.ejb.Local;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * GeekBrains Java, JavaEEWebApp.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 30.06.2020
 * @link https://github.com/Centnerman
 */

@Local
@Path("/v1/product")
public interface ProductServiceRs {

    @PUT
    @Path("/new")
    @Consumes(MediaType.APPLICATION_JSON)
    void insertDTO(ProductDTO product);

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    void updateDTO(ProductDTO product);

    @DELETE
    @Path("/{id}/id")
    void delete(@PathParam("id") Long id);

    @GET
    @Path("/{id}/id")
    @Produces(MediaType.APPLICATION_JSON)
    ProductDTO findDTOById(@PathParam("id") Long id);

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    List<ProductDTO> findAllDTO();
}
