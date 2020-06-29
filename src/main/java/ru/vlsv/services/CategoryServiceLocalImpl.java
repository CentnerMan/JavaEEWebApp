package ru.vlsv.services;

import ru.vlsv.entity.Category;
import ru.vlsv.repositories.CategoryRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import java.io.Serializable;
import java.util.List;

/**
 * GeekBrains Java, JavaEEWebApp.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 23.06.2020
 * @link https://github.com/Centnerman
 */

@Stateless
public class CategoryServiceImpl implements CategoryService, Serializable {

    @EJB
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    @TransactionAttribute
    public void insert(Category category) {
        categoryRepository.insert(category);
    }

    @Override
    @TransactionAttribute
    public void update(Category category) {
        categoryRepository.update(category);
    }

    @Override
    @TransactionAttribute
    public void delete(Long id) {
        categoryRepository.delete(id);
    }
}
