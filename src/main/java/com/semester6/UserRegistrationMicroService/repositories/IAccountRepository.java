package com.semester6.UserRegistrationMicroService.repositories;

import com.semester6.UserRegistrationMicroService.Account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IAccountRepository extends JpaRepository<Account, Long>
{
    @Query(value = "SELECT * FROM `account` ORDER BY `id` DESC LIMIT 1", nativeQuery = true)
    public Account findLastCreatedAccount();
}

