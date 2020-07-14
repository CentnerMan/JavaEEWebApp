package ru.vlsv.repositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vlsv.entity.Role;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * GeekBrains Java, JavaEEWebApp.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 13.07.2020
 * @link https://github.com/Centnerman
 */

@Stateless
public class RoleRepository {

    private final Logger logger = LoggerFactory.getLogger(RoleRepository.class);

    @PersistenceContext(unitName = "ds")
    protected EntityManager em;

    @TransactionAttribute
    public Role merge(Role role) {
        return em.merge(role);
    }

    public Role findById(int id) {
        return em.find(Role.class, id);
    }

    public List<Role> getAllRoles() {
        return em.createQuery("from Role ", Role.class).getResultList();
    }

    public long getCount() {
        return em.createQuery("select count(*) from Role", Long.class)
                .getSingleResult();
    }
}
