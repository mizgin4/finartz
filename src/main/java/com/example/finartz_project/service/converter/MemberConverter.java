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

//    public MemberDto convert(MemberEntity source) {
//        if (source==null){
//            return null;
//        }
//        MemberDto memberDto = new MemberDto();
//        memberDto.setId(source.getId());
//        memberDto.setBirthDay(source.getBirthDay());
//        memberDto.setName(source.getName());
//        memberDto.setLastName(source.getLastName());
//        memberDto.setEmail(source.getEmail());
//        memberDto.setPassword(source.getPassword());
//        return memberDto;
//
//    }

