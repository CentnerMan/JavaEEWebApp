package ru.vlsv.services;

import ru.vlsv.entity.Category;

import javax.ejb.Local;
import java.util.List;

/**
 * GeekBrains Java, JavaEEWebApp.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 29.06.2020
 * @link https://github.com/Centnerman
 */

@Local
public interface CategoryServiceLocal {

    List<Category> findAll();

    void insert(Category category);

    void update(Category category);

    void delete(Long id);
}
