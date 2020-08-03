package com.example.finartz_project.model.dto;

import com.example.finartz_project.model.entity.MemberEntity;
import com.example.finartz_project.model.enumeration.Roles;

import javax.persistence.*;

public class RoleDto {
    private Long memberId;
    //private MemberEntity member;

    private Roles title;

//    public MemberEntity getMember() {
//        return member;
//    }
//
//    public void setMember(MemberEntity member) {
//        this.member = member;
//    }


    public Roles getTitle() {
        return title;
    }

    public void setTitle(Roles title) {
        this.title = title;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
}
