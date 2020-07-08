package ru.vlsv.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vlsv.entity.Category;
import ru.vlsv.entity.Product;
import ru.vlsv.entity.ProductDTO;
import ru.vlsv.repositories.CategoryRepository;
import ru.vlsv.repositories.ProductRepository;
import ru.vlsv.rest.ProductServiceRest;

import javax.ejb.AsyncResult;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.jws.WebService;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.Future;

/**
 * GeekBrains Java, JavaEEWebApp.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 23.06.2020
 * @link https://github.com/Centnerman
 */

@Stateless
@WebService(endpointInterface = "ru.vlsv.services.ProductServiceWs", serviceName = "ProductService")
public class ProductServiceLocalImpl implements ProductServiceLocal, ProductServiceWs, ProductServiceRest, Serializable {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceLocalImpl.class);

    @EJB
    private ProductRepository productRepository;

    @EJB
    private CategoryRepository categoryRepository;

    @Override
    public String hello() {
        return "Hello!";
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    @TransactionAttribute
    public void insert(Product product) {
        productRepository.insert(product);
    }

    @Override
    @TransactionAttribute
    public void update(Product product) {
        productRepository.update(product);
    }

    @Override
    @TransactionAttribute
    public void delete(Long id) {
        productRepository.delete(id);
    }

    @Override
    public void insertDTO(ProductDTO productDTO) {
        Category category = categoryRepository.findById(productDTO.getCategoryId());
        productRepository.insert(new Product(null, productDTO.getName(), productDTO.getDescription(),
                productDTO.getPrice(), category));
    }

    @Override
    public void updateDTO(ProductDTO productDTO) {
        Category category = categoryRepository.findById(productDTO.getCategoryId());
        productRepository.update(new Product(productDTO.getId(), productDTO.getName(), productDTO.getDescription(),
                productDTO.getPrice(), category));
    }

    @Override
    public ProductDTO findDTOById(Long id) {
        return productRepository.findDTOById(id);
    }

    @Override
    public List<ProductDTO> findAllDTO() {
        return productRepository.findAllDTO();
    }

    @Override
    public Future<ProductDTO> findByIdAsync(Long id) {
        return new AsyncResult<>(productRepository.findDTOById(id));
    }

}
