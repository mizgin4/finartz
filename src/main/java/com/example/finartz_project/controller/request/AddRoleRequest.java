package com.example.finartz_project.controller.request;

import com.example.finartz_project.model.entity.MemberEntity;
import com.example.finartz_project.model.enumeration.Roles;

public class AddRoleRequest {
    private Long memberId;
    private Roles title;


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
