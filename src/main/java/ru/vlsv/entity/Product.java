package ru.vlsv.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * GeekBrains Java, JavaEEWebApp.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 05.06.2020
 * @link https://github.com/Centnerman
 */

@Data
@NoArgsConstructor
public class Product {
    private Long id;
    private String productName;
    private String description;
    private BigDecimal price;

    public Product(Long id, String productName, String description, BigDecimal price) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.price = price;
    }
}
