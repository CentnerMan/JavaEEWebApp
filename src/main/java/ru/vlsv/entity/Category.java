package ru.vlsv.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * GeekBrains Java, JavaEEWebApp.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 17.06.2020
 * @link https://github.com/Centnerman
 */

@Data
@NoArgsConstructor
public class Categories {
    private long id;
    private String name;

    public Categories(String name) {
        this.name = name;
    }
}