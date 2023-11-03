package com.semester6.UserRegistrationMicroService.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.semester6.UserRegistrationMicroService.Account.Account;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


public class AccountDto implements Serializable {
    @JsonProperty("id")
    private int Id;
    @JsonProperty("password")
    private String PassWord;
    @JsonProperty("dateofbirth")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate DateOfBirth;
    @JsonProperty("email")
    private String Email;

    private AccountRoleDto RoleDto;

    public AccountDto(int id, String passWord, LocalDate dateOfBirth, String email, AccountRoleDto roleId) {
        Id = id;
        PassWord = passWord;
        DateOfBirth = dateOfBirth;
        Email = email;
        RoleDto = roleId;

    }

    public AccountDto(String passWord, LocalDate dateOfBirth, String email, AccountRoleDto roleId) {

        PassWord = passWord;
        DateOfBirth = dateOfBirth;
        Email = email;
        RoleDto = roleId;

    }
    public AccountDto(String passWord, LocalDate dateOfBirth, String email) {

        PassWord = passWord;
        DateOfBirth = dateOfBirth;
        Email = email;

    }

    public AccountDto()
    {

    }

    public int getId() {
        return Id;
    }

    public String getPassWord() {
        return PassWord;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public String getEmail() {
        return Email;
    }

    public AccountRoleDto getRoleDto()
    {
        return RoleDto;
    }

    @Override
    public String toString() {
        return "AccountDto{" +
                "Id=" + Id +
                ", PassWord='" + PassWord + '\'' +
                ", DateOfBirth=" + DateOfBirth +
                ", Email='" + Email + '\'' +
                ", RoleDto=" + RoleDto +
                '}';
    }
}