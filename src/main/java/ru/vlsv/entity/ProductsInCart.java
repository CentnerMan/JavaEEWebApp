package ru.vlsv.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * GeekBrains Java, JavaEEWebApp.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 17.06.2020
 * @link https://github.com/Centnerman
 */

@Data
@NoArgsConstructor
public class ProductsInCart {
    private long id;
    private Product product;
    int count;
    BigDecimal sum;

    public ProductsInCart(Product product, int count) {
        this.product = product;
        this.count = count;
        this.sum = product.getPrice().multiply(BigDecimal.valueOf(count));
    }
}
