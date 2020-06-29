package ru.vlsv.services;

import ru.vlsv.entity.Category;
import ru.vlsv.entity.Product;
import ru.vlsv.entity.ProductDTO;

import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import java.util.List;

/**
 * GeekBrains Java, JavaEEWebApp.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 29.06.2020
 * @link https://github.com/Centnerman
 */

@Local
public interface ProductService {

    public List<Product> findAll();

    public void insert(Product product);

    public void update(Product product);

    public void delete(Long id);

    public void insertDTO(ProductDTO productDTO);

    public void updateDTO(ProductDTO productDTO);

    public ProductDTO findDTOById(long id);

    public List<ProductDTO> findAllDTO();
}
