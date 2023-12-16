package com.semester6.UserRegistrationMicroService.Account;

import com.semester6.UserRegistrationMicroService.AccountRole.AccountRole;
import com.semester6.UserRegistrationMicroService.dtos.AccountDto;
import com.semester6.UserRegistrationMicroService.repositories.IAccountRepository;
import com.semester6.UserRegistrationMicroService.repositories.IAccountRoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public Account AddUser(AccountDto account)
    {
        AccountRole userRole = repoAccountRole.findRoleByName("user");

        Account accountToInsert = new Account(account.getDateOfBirth(), account.getPassWord(), account.getEmail(), userRole);
        this.repoAccount.save(accountToInsert);

        return repoAccount.findLastCreatedAccount();
    }

    @Transactional
    public void DeleteUser(Account accountToDelete)
    {
        if(accountToDelete != null)
        {
            this.repoAccount.delete(accountToDelete);
        }

    }

    public Optional<Account> SelectAccountById(Long id)
    {
        return this.repoAccount.findById(id);
    }

}
