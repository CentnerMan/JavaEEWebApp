package ru.vlsv.controllers;

import ru.vlsv.entity.Product;
import ru.vlsv.entity.ProductInCart;
import ru.vlsv.services.CartService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * GeekBrains Java, JavaEEWebApp.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 21.06.2020
 * @link https://github.com/Centnerman
 */

@Named
@SessionScoped
public class CartController implements Serializable {

    @Inject
    private CartService cartService;

    public List<ProductInCart> getAll() {
        return cartService.getAll();
    }

    public void addToCart(Product product) {
        cartService.addProduct(product, 1);
    }

    public void delFromCart(Product product) {
        cartService.delProduct(product, 1);
    }
}
