package com.semester6.UserRegistrationMicroService.AccountRole;

import jakarta.persistence.*;

@Entity
@Table(name = "accountrole")
public class AccountRole
{
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(unique=true)
    private String Name;

    public AccountRole()
    {

    }

    public  AccountRole(int id, String name)
    {
        Id = id;
        Name = name;
    }
    public AccountRole(String name)
    {
        Name = name;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }
}
