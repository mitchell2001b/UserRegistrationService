package com.semester6.UserRegistrationMicroService.Account;

import com.semester6.UserRegistrationMicroService.AccountRole.AccountRole;
import com.semester6.UserRegistrationMicroService.dtos.AccountDto;
import com.semester6.UserRegistrationMicroService.dtos.AccountRoleDto;
import com.semester6.UserRegistrationMicroService.repositories.IAccountRepository;
import com.semester6.UserRegistrationMicroService.repositories.IAccountRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService
{
    private IAccountRepository repoAccount;
    private IAccountRoleRepository repoAccountRole;

    @Autowired
    public AccountService(IAccountRepository accountRepo, IAccountRoleRepository accountRoleRepository) {
        this.repoAccount = accountRepo;
        this.repoAccountRole = accountRoleRepository;
    }
    public void AddUser(AccountDto account)
    {
        AccountRole userRole = repoAccountRole.FindRoleByName("user");

        Account accountToInsert = new Account(account.getDateOfBirth(), account.getPassWord(), account.getEmail(), userRole);
        this.repoAccount.save(accountToInsert);
    }
}
