package ru.vlsv.controllers;

import ru.vlsv.entity.ProductDTO;
import ru.vlsv.entity.ProductInCart;
import ru.vlsv.services.CartService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
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

    @EJB
    private CartService cartService;

    public List<ProductInCart> getAll() {
        return cartService.getAll();
    }

    public void addToCart(ProductDTO product) {
        cartService.addProduct(product, 1);
    }

    public void delFromCart(ProductDTO product) {
        cartService.delProduct(product, 1);
    }

}
