package ru.vlsv.services;

import ru.vlsv.entity.Category;
import ru.vlsv.entity.Product;
import ru.vlsv.repositories.CategoryRepository;
import ru.vlsv.repositories.ProductRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * GeekBrains Java, JavaEEWebApp.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 23.06.2020
 * @link https://github.com/Centnerman
 */

@Named
@SessionScoped
public class CategoryService implements Serializable {

    @Inject
    private CategoryRepository categoryRepository;


    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Transient
    public void insert(Category category) {
        categoryRepository.insert(category);
    }

    @Transient
    public void update(Category category) {
        categoryRepository.update(category);
    }

    @Transient
    public void delete(Long id) {
        categoryRepository.delete(id);
    }
}
