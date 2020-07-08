package ru.vlsv.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * GeekBrains Java, JavaEEWebApp.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 28.06.2020
 * @link https://github.com/Centnerman
 */

@Data
@NoArgsConstructor
public class ProductDTO implements Serializable {

    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private Long categoryId;

    private String categoryDescription;

    public ProductDTO(Long id, String name, String description, BigDecimal price, Long categoryId, String categoryDescription) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
        this.categoryDescription = categoryDescription;
    }
}
