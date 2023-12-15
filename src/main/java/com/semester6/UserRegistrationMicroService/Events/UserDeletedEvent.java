package com.semester6.UserRegistrationMicroService.Events;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class UserDeletedEvent implements Serializable
{
    private Long Id;
    private String Email;

    private Date Createdat;

    public UserDeletedEvent(Long id, String email, Date createdat) {
        Id = id;
        Email = email;
        Createdat = createdat;
    }

    public UserDeletedEvent()
    {

    }

    public Long getId() {
        return Id;
    }

    public String getEmail() {
        return Email;
    }

    public Date getCreatedat() {
        return Createdat;
    }

    @Override
    public String toString() {
        return "UserDeletedEvent{" +
                "Id=" + Id +
                ", Email='" + Email + '\'' +
                ", Createdat=" + Createdat +
                '}';
    }
}
