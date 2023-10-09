package com.semester6.UserRegistrationMicroService.Account;

import com.semester6.UserRegistrationMicroService.AccountRole.AccountRoleService;
import com.semester6.UserRegistrationMicroService.dtos.AccountDto;
import com.semester6.UserRegistrationMicroService.dtos.AccountRoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "api/accounts")
public class AccountController {

   private final AccountService service;

   //a
    @Autowired
    public AccountController(AccountService accountService)
    {
        this.service = accountService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<String> createUser(@RequestBody AccountDto newAccount)
    {
        service.AddUser(newAccount);

        return ResponseEntity.status(HttpStatus.OK)
                .body("{ \"id\": "+ 111 + " }");
    }

    @GetMapping(value = "/testcall")
    public String testcall()
    {
        return "bamiba";
    }
}
