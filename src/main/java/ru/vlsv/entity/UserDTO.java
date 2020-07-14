package ru.vlsv.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.vlsv.entity.User;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * GeekBrains Java, JavaEEWebApp.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 13.07.2020
 * @link https://github.com/Centnerman
 */

@Data
@NoArgsConstructor
public class UserDTO implements Serializable {

    private int id;

    private String login;

    private String password;

    private Set<RoleDTO> roles;

    public UserDTO(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.roles = new HashSet<>();
        user.getRoles().forEach(r -> this.roles.add(new RoleDTO(r)));
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", login='" + login + '\'' +
                '}';
    }
}
