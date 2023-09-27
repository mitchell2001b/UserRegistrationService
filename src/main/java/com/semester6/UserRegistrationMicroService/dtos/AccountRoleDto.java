package com.semester6.UserRegistrationMicroService.dtos;

import com.semester6.UserRegistrationMicroService.AccountRole.AccountRole;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link AccountRole} entity
 */
public class AccountRoleDto implements Serializable {
    private int Id;
    private String Name;

    public AccountRoleDto(int id, String name)
    {
        Id = id;
        Name = name;
    }
    public AccountRoleDto(String name)
    {
        Name = name;
    }

    public AccountRoleDto()
    {

    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountRoleDto entity = (AccountRoleDto) o;
        return Objects.equals(this.Id, entity.Id) &&
                Objects.equals(this.Name, entity.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Name);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "Id = " + Id + ", " +
                "Name = " + Name + ")";
    }
}