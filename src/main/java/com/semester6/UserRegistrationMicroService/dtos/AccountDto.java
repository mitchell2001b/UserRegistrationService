package com.semester6.UserRegistrationMicroService.dtos;

import com.semester6.UserRegistrationMicroService.Account.Account;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


public class AccountDto implements Serializable {
    private int Id;
    private String PassWord;
    private LocalDate DateOfBirth;
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