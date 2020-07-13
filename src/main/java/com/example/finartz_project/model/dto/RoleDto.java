package com.example.finartz_project.model.dto;

import com.example.finartz_project.model.entity.MemberEntity;

import javax.persistence.*;

public class RoleDto {
    private Long memberId;
    //private MemberEntity member;

    private String title;

//    public MemberEntity getMember() {
//        return member;
//    }
//
//    public void setMember(MemberEntity member) {
//        this.member = member;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
}
