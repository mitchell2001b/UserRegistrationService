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
    private int Id;

    private String PassWord;
    private LocalDate DateOfBirth;
    @Column(unique=true)
    private String Email;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "accountRole_id")
    private AccountRole Role;

    public Account() {
    }

    public Account(int id, LocalDate dateOfBirth, String passWord, String email, AccountRole accountRole)
    {
        Id = id;
        DateOfBirth = dateOfBirth;
        Email = email;
        PassWord = passWord;
        Role = accountRole;

    }

    public Account(LocalDate dateOfBirth, String passWord, String email, AccountRole accountRole)
    {
        DateOfBirth = dateOfBirth;
        Email = email;
        PassWord = passWord;
        Role = accountRole;
    }



    public int GetUserId()
    {
        return Id;
    }

    public  LocalDate GetDateOfBirth()
    {
        return DateOfBirth;
    }

    public String GetPassWord()
    {
        return PassWord;
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
                ", PassWord='" + PassWord + '\'' +
                ", DateOfBirth=" + DateOfBirth +
                ", Email='" + Email + '\'' +
                '}';
    }
}
