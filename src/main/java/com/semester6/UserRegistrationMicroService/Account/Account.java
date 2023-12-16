package com.semester6.UserRegistrationMicroService.Account;



import java.time.LocalDate;

import com.semester6.UserRegistrationMicroService.AccountRole.AccountRole;
import jakarta.persistence.*;

@Entity
@Table(name = "account")
public class Account
{
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(nullable = false, length = 40)
    private String Password;
    @Column(nullable = false)
    private LocalDate Dateofbirth;
    @Column(unique=true, nullable = false, length = 20)
    private String Email;

    @ManyToOne()
    @JoinColumn(name = "accountRole_id")
    private AccountRole Role;

    public Account() {
    }

    public Account(Long id, LocalDate dateOfBirth, String passWord, String email, AccountRole accountRole)
    {
        Id = id;
        Dateofbirth = dateOfBirth;
        Email = email;
        Password = passWord;
        Role = accountRole;

    }

    public Account(LocalDate dateOfBirth, String passWord, String email, AccountRole accountRole)
    {
        Dateofbirth = dateOfBirth;
        Email = email;
        Password = passWord;
        Role = accountRole;
    }



    public Long GetUserId()
    {
        return Id;
    }

    public  LocalDate GetDateOfBirth()
    {
        return Dateofbirth;
    }

    public String GetPassWord()
    {
        return Password;
    }

    public String GetEmail()
    {
        return Email;
    }

    public AccountRole GetRole() { return Role; }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", PassWord='" + Password + '\'' +
                ", DateOfBirth=" + Dateofbirth +
                ", Email='" + Email + '\'' +
                '}';
    }
}
