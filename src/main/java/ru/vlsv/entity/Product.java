package ru.vlsv.entity;

import java.math.BigDecimal;

/**
 * GeekBrains Java, JavaEEWebApp.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 01.04.2020
 * @link https://github.com/Centnerman
 */

public class Product {
    private Long id;
    private String productName;
    private String description;
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Product() {
    }

    public Product(Long id, String productName, String description, BigDecimal price) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.price = price;
    }
}
