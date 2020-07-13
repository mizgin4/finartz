package com.example.finartz_project.controller.request;

import com.example.finartz_project.model.dto.RoleDto;
import com.example.finartz_project.model.entity.RoleEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.List;

public class CreateMemberRequest {

    private String name;

    private String lastName;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birthDay;

    @Email
    private String email;

    private List<RoleEntity> roleList;




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

    public void setBirthDay(LocalDateTime birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<RoleEntity> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<RoleEntity> roleList) {
        this.roleList = roleList;
    }
}
