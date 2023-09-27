package com.semester6.UserRegistrationMicroService.repositories;

import com.semester6.UserRegistrationMicroService.Account.Account;
import org.springframework.data.jpa.repository.JpaRepository;



    public interface IAccountRepository extends JpaRepository<Account, Integer>
    {

    }

