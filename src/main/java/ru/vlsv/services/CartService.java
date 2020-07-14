package ru.vlsv.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vlsv.entity.ProductDTO;
import ru.vlsv.entity.ProductInCart;

import javax.ejb.Stateful;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * GeekBrains Java, JavaEEWebApp.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 21.06.2020
 * @link https://github.com/Centnerman
 */

@Stateful
public class CartService implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(CartService.class);

    private Map<ProductInCart, Integer> products;

    public CartService() {
        products = new HashMap<>();
    }

    public void addProduct(ProductDTO product, int count) {
        ProductInCart productIn = new ProductInCart(product);
        products.put(productIn, products.getOrDefault(productIn, 0) + count);
    }

    public void delProduct(ProductDTO product, int count) {
        ProductInCart productIn = new ProductInCart(product);
        int currCount = products.getOrDefault(productIn, 0);
        if (currCount - count > 0) {
            products.put(productIn, currCount - count);
        } else {
            products.remove(productIn);
        }
    }

    public List<ProductInCart> getAll() {
        products.forEach(ProductInCart::setCount);
        return new ArrayList<>(products.keySet());
    }
}
