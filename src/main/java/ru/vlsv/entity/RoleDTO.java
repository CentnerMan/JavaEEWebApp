package ru.vlsv.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.vlsv.entity.Role;

import java.io.Serializable;
import java.util.Objects;

/**
 * GeekBrains Java, JavaEEWebApp.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 13.07.2020
 * @link https://github.com/Centnerman
 */

@Data
@NoArgsConstructor
public class RoleDTO implements Serializable {

   private long id;

    private String name;

    public RoleDTO(Role role) {
        this.id = role.getId();
        this.name = role.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleDTO roleDTO = (RoleDTO) o;
        return name.equals(roleDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
