package ru.vlsv.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * GeekBrains Java, JavaEEWebApp.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 17.06.2020
 * @link https://github.com/Centnerman
 */

@Data
@NoArgsConstructor
public class ProductInCart {

    private Product product;

    int count;

    public ProductInCart(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductInCart that = (ProductInCart) o;
        return product.equals(that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product);
    }
}
