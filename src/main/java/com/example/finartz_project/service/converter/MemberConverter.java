package com.example.finartz_project.service.converter;

import com.example.finartz_project.model.dto.MemberDto;
import com.example.finartz_project.model.entity.MemberEntity;

public class MemberConverter {
    public static MemberEntity convert(MemberDto source) {
        if (source == null) {
            return null;
        }
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberId(source.getMemberId());
        memberEntity.setBirthDay(source.getBirthDay());
        memberEntity.setName(source.getName());
        memberEntity.setLastName(source.getLastName());
        memberEntity.setEmail(source.getEmail());
        memberEntity.setPassword(source.getPassword());
        return memberEntity;


    }
}


