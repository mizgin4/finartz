package com.example.finartz_project.model;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;


    private String name;

    private String lastName;

    private LocalDateTime birthDay;

    private String email;

    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDateTime birtDay) {
        this.birthDay = birtDay;
    }
}
