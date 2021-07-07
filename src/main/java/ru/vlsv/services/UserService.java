package ru.vlsv.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vlsv.entity.User;
import ru.vlsv.entity.UserDTO;
import ru.vlsv.repositories.UserRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
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
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @EJB
    private UserRepository userRepository;

    @TransactionAttribute
    public void merge(UserDTO user) {
        User merged = userRepository.merge(new User(user));
        user.setId(merged.getId());
    }

    @TransactionAttribute
    public void delete(int id) {
        userRepository.delete(id);
    }

    @TransactionAttribute
    public UserDTO findById(int id) {
        return new UserDTO(userRepository.findById(id));
    }

    @TransactionAttribute
    public boolean existsById(int id) {
        return userRepository.findById(id) != null;
    }

    @TransactionAttribute
    public List<UserDTO> getAllUsers() {
        return userRepository.getAllUsers().stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }

}