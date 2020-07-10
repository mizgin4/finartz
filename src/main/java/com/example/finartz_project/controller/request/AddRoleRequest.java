package com.example.finartz_project.controller.request;

import com.example.finartz_project.model.entity.MemberEntity;

public class AddRoleRequest {
    private Long memberId;
    private String title;
    private MemberEntity memberEntity;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MemberEntity getMemberEntity() {
        return memberEntity;
    }

    public void setMemberEntity(MemberEntity memberEntity) {
        this.memberEntity = memberEntity;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
}
