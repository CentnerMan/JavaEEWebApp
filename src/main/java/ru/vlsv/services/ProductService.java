package ru.vlsv.services;

import ru.vlsv.entity.Category;
import ru.vlsv.entity.Product;
import ru.vlsv.entity.ProductDTO;
import ru.vlsv.repositories.CategoryRepository;
import ru.vlsv.repositories.ProductRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Transient;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * GeekBrains Java, JavaEEWebApp.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 23.06.2020
 * @link https://github.com/Centnerman
 */

@Named
@SessionScoped
public class ProductService implements Serializable {

    @Inject
    private ProductRepository productRepository;

    @Inject
    private CategoryRepository categoryRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Transient
    public void insert(Product product) {
        productRepository.insert(product);
    }

    @Transient
    public void update(Product product) {
        productRepository.update(product);
    }

    @Transient
    public void delete(Long id) {
        productRepository.delete(id);
    }

//    @Transactional
    public void insertDTO(ProductDTO productDTO) {
        Category category = categoryRepository.findById(productDTO.getCategoryId());
        productRepository.insert(new Product(null, productDTO.getName(), productDTO.getDescription(),
                productDTO.getPrice(), category));
    }

//    @Transactional
    public void updateDTO(ProductDTO productDTO) {
        Category category = categoryRepository.findById(productDTO.getCategoryId());
        productRepository.update(new Product(productDTO.getId(), productDTO.getName(), productDTO.getDescription(),
                productDTO.getPrice(), category));
    }

    public ProductDTO findDTOById(long id) {
        return productRepository.findDTOById(id);
    }

    public List<ProductDTO> findAllDTO() {
        return productRepository.findAllDTO();
    }

}
