package ru.vlsv.repositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vlsv.entity.Product;

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

//    @Resource
//    private UserTransaction ut;
//
//    @PostConstruct
//    public void init() throws SystemException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
//        if (findAll().size() == 0) {
//            try {
//                ut.begin();
//                insert(new Product(-1L, "Product1", "Desc1", new BigDecimal(10)));
//                insert(new Product(-1L, "Product2", "Desc2", new BigDecimal(102)));
//                insert(new Product(-1L, "Product3", "Desc3", new BigDecimal(1030)));
//                insert(new Product(-1L, "Product4", "Desc4", new BigDecimal(140)));
//            } catch (Exception e) {
//                logger.error("Error in ProductRepository init", e);
//                ut.rollback();
//            }
//            ut.commit();
//        }
//    }

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
}
