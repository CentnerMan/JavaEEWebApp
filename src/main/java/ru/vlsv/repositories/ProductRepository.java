package ru.vlsv.repositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vlsv.entity.Product;
import ru.vlsv.entity.ProductDTO;

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
public class ProductRepository {

    private static final Logger logger = LoggerFactory.getLogger(ProductRepository.class);

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    @TransactionAttribute
    public void insert(Product product) {
        em.persist(product);
    }

    @TransactionAttribute
    public void update(Product product) {
        em.merge(product);
    }

    @TransactionAttribute
    public void delete(long id) {
        Product product = em.find(Product.class, id);
        if (product != null) {
            em.remove(product);
        }
    }

    public Product findById(long id) {
        return em.find(Product.class, id);
    }

    public List<Product> findAll() {
        return em.createQuery("from Product", Product.class).getResultList();
    }

    public List<ProductDTO> findAllDTO() {
        return em.createQuery("select new ru.vlsv.entity.ProductDTO(p.id, p.name, p.description, p.price, " +
                "p.category.id, p.category.name) from Product p", ProductDTO.class)
                .getResultList();

    }

    public ProductDTO findDTOById(long id) {
        return em.createQuery("select new ru.vlsv.entity.ProductDTO(p.id, p.name, p.description, p.price, " +
                "p.category.id, p.category.name) from Product p where p.id = :id", ProductDTO.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
