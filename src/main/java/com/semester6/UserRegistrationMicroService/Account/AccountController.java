package com.semester6.UserRegistrationMicroService.Account;

import com.semester6.UserRegistrationMicroService.AccountRole.AccountRoleService;
import com.semester6.UserRegistrationMicroService.Events.UserCreatedEvent;
import com.semester6.UserRegistrationMicroService.dtos.AccountDto;
import com.semester6.UserRegistrationMicroService.dtos.AccountRoleDto;
import com.semester6.UserRegistrationMicroService.kafka.KafkaTopicClearService;
import com.semester6.UserRegistrationMicroService.kafka.RegistrationProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
@RequestMapping(path = "api/accounts")
public class AccountController {

   private final AccountService service;
   private final KafkaTopicClearService clearTopicService;
   private final RegistrationProducer registrationProducer;

   @Value("${spring.kafka.topic.name}")
   private String TopicName;
    @Autowired
    public AccountController(AccountService accountService, RegistrationProducer givenRegistrationProducer, KafkaTopicClearService clearService)
    {
        this.service = accountService;
        this.registrationProducer = givenRegistrationProducer;
        this.clearTopicService = clearService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<String> createUser(@RequestBody AccountDto newAccount)
    {
        Account account = null;
        try
        {
            account = service.AddUser(newAccount);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("{could not create user}");
        }

        UserCreatedEvent event = new UserCreatedEvent(account.GetUserId(), account.GetPassWord(), account.GetDateOfBirth(), account.GetEmail(), account.GetRole().getId(), account.GetRole().getName(), LocalDate.now());
        registrationProducer.SendMessage(event);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("{ \"id\": "+ account.GetUserId() + " }");
    }

    @GetMapping(value = "/testcall")
    public String testcall()
    {
        AccountRoleDto roleDto = new AccountRoleDto(1,"admin");
        AccountDto dto = new AccountDto(1, "pass", LocalDate.now(), "email", roleDto);
        UserCreatedEvent event = new UserCreatedEvent(1, "pass", LocalDate.now(), "email2gmail.com", roleDto.getId(), roleDto.getName(), LocalDate.now());
        registrationProducer.SendMessage(event);

        return "dit is een test bericht";
    }

    @GetMapping(value = "/testcall2")
    public String ClearTopic()
    {
        clearTopicService.clearTopic(TopicName);
        return "Topic cleared";
    }
}
