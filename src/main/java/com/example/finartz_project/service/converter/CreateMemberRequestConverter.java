package com.example.finartz_project.service.converter;

import com.example.finartz_project.controller.request.CreateMemberRequest;
import com.example.finartz_project.model.dto.MemberDto;
import org.springframework.stereotype.Component;

@Component
public class CreateMemberRequestConverter {

    public MemberDto convert(CreateMemberRequest request, String password) {

        MemberDto memberDto = new MemberDto();

        memberDto.setBirthDay(request.getBirthDay());
        memberDto.setName(request.getName());
        memberDto.setLastName(request.getLastName());
        memberDto.setEmail(request.getEmail());
        memberDto.setPassword(password);
        //memberDto.setRoles(request.getRoleList());

        return memberDto;
    }
}