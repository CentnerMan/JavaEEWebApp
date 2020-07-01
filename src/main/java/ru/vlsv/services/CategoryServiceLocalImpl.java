package ru.vlsv.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vlsv.entity.Category;
import ru.vlsv.repositories.CategoryRepository;
import ru.vlsv.repositories.ProductRepository;

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
public class CategoryServiceLocalImpl implements CategoryServiceLocal {

    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceLocalImpl.class);

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
