package com.semester6.UserRegistrationMicroService.repositories;


import com.semester6.UserRegistrationMicroService.AccountRole.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAccountRoleRepository extends JpaRepository<AccountRole, Integer>
{
    @Query(value = "SELECT * FROM accountrole where name = ?1", nativeQuery = true)
    public AccountRole FindRoleByName(String name);
}
