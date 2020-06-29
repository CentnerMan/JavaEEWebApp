package ru.vlsv.controllers;

import ru.vlsv.entity.Category;
import ru.vlsv.entity.ProductDTO;
import ru.vlsv.repositories.CategoryRepository;
import ru.vlsv.services.CategoryServiceLocal;
import ru.vlsv.services.ProductServiceLocal;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ProductController implements Serializable {

    @EJB
    private ProductServiceLocal productService;

    @EJB
    private CategoryServiceLocal categoryService;

    private ProductDTO product;

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public String createProduct() {
        this.product = new ProductDTO();
        return "/product.xhtml?faces-redirect=true";
    }

    public List<ProductDTO> getAllProduct() {
        return productService.findAllDTO();
    }

    public String editProduct(ProductDTO product) {
        this.product = product;
        return "/product.xhtml?faces-redirect=true";
    }

    public void deleteProduct(ProductDTO product) {
        productService.delete(product.getId());
    }

    public String saveProduct() {
        if (product.getId() == null) {
            productService.insertDTO(product);
        } else {
            productService.updateDTO(product);
        }
        return "/index.xhtml?faces-redirect=true";
    }

    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }

}

