package ru.vlsv.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * GeekBrains Java, JavaEEWebApp.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 17.06.2020
 * @link https://github.com/Centnerman
 */

@Data
@NoArgsConstructor
public class Cart {

    private Integer id;

    private List<ProductInCart> cartList;

}
