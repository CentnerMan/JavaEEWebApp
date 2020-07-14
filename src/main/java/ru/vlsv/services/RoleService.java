package ru.vlsv.services;

import ru.vlsv.entity.RoleDTO;
import ru.vlsv.repositories.RoleRepository;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * GeekBrains Java, JavaEEWebApp.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 13.07.2020
 * @link https://github.com/Centnerman
 */

@Stateless
public class RoleService implements Serializable {

    @Inject
    private RoleRepository roleRepository;

    @TransactionAttribute
    public List<RoleDTO> getAllRoles() {
        return roleRepository.getAllRoles().stream()
                .map(RoleDTO::new)
                .collect(Collectors.toList());
    }
}
