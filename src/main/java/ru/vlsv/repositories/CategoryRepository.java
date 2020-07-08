package ru.vlsv.repositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vlsv.entity.Category;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * GeekBrains Java, JavaEEWebApp.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 17.06.2020
 * @link https://github.com/Centnerman
 */

@Stateless
public class CategoryRepository {

    private static final Logger logger = LoggerFactory.getLogger(CategoryRepository.class);

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    @TransactionAttribute
    public void insert(Category category) {
        em.persist(category);
    }

    @TransactionAttribute
    public void update(Category category) {
        em.merge(category);
    }

    @TransactionAttribute
    public void delete(long id) {
        Category category = em.find(Category.class, id);
        if (category != null) {
            em.remove(category);
        }
    }

    public Category findById(long id) {
        return em.find(Category.class, id);
    }

    public List<Category> findAll() {
        return em.createQuery("from Category ", Category.class).getResultList();
    }
}
