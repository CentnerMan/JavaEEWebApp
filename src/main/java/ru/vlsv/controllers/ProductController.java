package ru.vlsv.controllers;

import ru.vlsv.entity.Product;
import ru.vlsv.repositories.ProductRepository;
import ru.vlsv.services.ProductService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@Named
@SessionScoped
public class ProductController implements Serializable {

    @Inject
    private ProductService productService;

    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String createProduct() {
        this.product = new Product();
        return "/product.xhtml?faces-redirect=true";
    }

    public List<Product> getAllProduct() {
        return productService.findAll();
    }

    public String editProduct(Product product) {
        this.product = product;
        return "/product.xhtml?faces-redirect=true";
    }

    public void deleteProduct(Product product)  {
        productService.delete(product.getId());
        //return "/index.xhtml?faces-redirect=true";
    }

    public String saveProduct()  {
        if (product.getId() == null) {
            productService.insert(product);
        } else {
            productService.update(product);
        }
        return "/index.xhtml?faces-redirect=true";
    }
}

