package ru.vlsv.services;

import ru.vlsv.entity.Product;
import ru.vlsv.entity.ProductDTO;

import javax.ejb.Asynchronous;
import javax.ejb.Local;
import java.util.List;
import java.util.concurrent.Future;

/**
 * GeekBrains Java, JavaEEWebApp.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 29.06.2020
 * @link https://github.com/Centnerman
 */

@Local
public interface ProductServiceLocal {

    List<Product> findAll();

    void insert(Product product);

    void update(Product product);

    void delete(Long id);

    void insertDTO(ProductDTO productDTO);

    void updateDTO(ProductDTO productDTO);

    ProductDTO findDTOById(Long id);

    List<ProductDTO> findAllDTO();

    @Asynchronous
    Future<ProductDTO> findByIdAsync(Long id);

}
