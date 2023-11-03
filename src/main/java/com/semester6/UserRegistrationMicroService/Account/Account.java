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

    private String Password;
    private LocalDate Dateofbirth;
    @Column(unique=true)
    private String Email;

    @ManyToOne()
    @JoinColumn(name = "accountRole_id")
    private AccountRole Role;

    public Account() {
    }

    public Account(int id, LocalDate dateOfBirth, String passWord, String email, AccountRole accountRole)
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



    public int GetUserId()
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
