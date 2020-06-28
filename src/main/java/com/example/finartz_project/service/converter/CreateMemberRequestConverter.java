package com.example.finartz_project.service.converter;

import com.example.finartz_project.model.dto.MemberDto;
import com.example.finartz_project.model.request.CreateMemberRequest;
import com.example.finartz_project.model.response.SignUpResponse;

public class CreateMemberRequestConverter {

    public static MemberDto convert(CreateMemberRequest request) {
        MemberDto memberDto = new MemberDto();
        memberDto.setBirthDay(request.getBirthDay());
        memberDto.setName(request.getName());
        memberDto.setLastName(request.getLastName());
        memberDto.setEmail(request.getEmail());
        memberDto.setPassword(request.getPassword());

        return memberDto;
    }

}
