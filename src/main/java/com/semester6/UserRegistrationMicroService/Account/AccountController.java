package com.semester6.UserRegistrationMicroService.Account;

import com.semester6.UserRegistrationMicroService.AccountRole.AccountRoleService;
import com.semester6.UserRegistrationMicroService.dtos.AccountDto;
import com.semester6.UserRegistrationMicroService.dtos.AccountRoleDto;
import com.semester6.UserRegistrationMicroService.kafka.RegistrationProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
@RequestMapping(path = "api/accounts")
public class AccountController {

   private final AccountService service;
   private RegistrationProducer registrationProducer;
    @Autowired
    public AccountController(AccountService accountService, RegistrationProducer givenRegistrationProducer)
    {
        this.service = accountService;
        this.registrationProducer = givenRegistrationProducer;
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
        AccountRoleDto roleDto = new AccountRoleDto(1,"admin");
        AccountDto dto = new AccountDto(1, "pass", LocalDate.now(), "email", roleDto);
        registrationProducer.SendMessage(dto);

        return "dit is een test bericht";
    }
}
