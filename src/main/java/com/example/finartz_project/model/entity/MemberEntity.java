package com.example.finartz_project.model.entity;

import javax.management.relation.Role;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;


@Entity
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberId;

    //@Column(name = "member",insertable = false,unique = true)
    private String name;

    private String lastName;

    private LocalDateTime birthDay;

    private String email;

    private String password;



    @OneToMany(mappedBy = "member")
    private List<DemandEntity> demandEntity;



    @ManyToMany
    @JoinTable(
            name = "course_like",
            joinColumns = @JoinColumn(name = "memberId"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    List<RoleEntity> roleEntities;


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

    public Long getMemberId() {
        return memberId;
    }
    public void setMemberId(Long id) {
        this.memberId = id;
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
