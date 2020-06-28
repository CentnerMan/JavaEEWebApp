package ru.vlsv.repositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vlsv.entity.Product;
import ru.vlsv.entity.ProductDTO;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.*;
import java.math.BigDecimal;
import java.util.List;

@Named
@ApplicationScoped
public class ProductRepository {

    private static final Logger logger = LoggerFactory.getLogger(ProductRepository.class);

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    @Transactional
    public void insert(Product product) {
        em.persist(product);
    }

    @Transactional
    public void update(Product product) {
        em.merge(product);
    }

    @Transactional
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
