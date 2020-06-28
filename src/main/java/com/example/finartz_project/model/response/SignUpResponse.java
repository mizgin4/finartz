package com.example.finartz_project.model.response;

import com.example.finartz_project.model.dto.MemberDto;


import java.time.LocalDateTime;

public class SignUpResponse {
    public static SignUpResponse getResponse(MemberDto memberDto) {
        SignUpResponse response = new SignUpResponse();
        response.setMemberId(memberDto.getMemberId());
        response.setBirthDay(memberDto.getBirthDay());
        response.setName(memberDto.getName());
        response.setLastName(memberDto.getLastName());
        response.getEmail(memberDto.getEmail());
        return response;
    }

    private Long memberId;
    private String name;
    private String lastName;
    private LocalDateTime birthDay;
    private String email;
    private String password;

    public String getEmail() {
        return email;
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

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
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

    public void setBirthDay(LocalDateTime birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail(String email) {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




    }
