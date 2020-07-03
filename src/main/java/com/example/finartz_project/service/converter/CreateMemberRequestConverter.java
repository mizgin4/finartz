package com.example.finartz_project.service.converter;

import com.example.finartz_project.model.dto.MemberDto;
import com.example.finartz_project.controller.request.CreateMemberRequest;
import com.example.finartz_project.service.imp.MailService;


public class CreateMemberRequestConverter {
    private static MailService mailService;

    public CreateMemberRequestConverter(MailService mailService) {
        this.mailService=mailService;
    }

    public static MemberDto convert(CreateMemberRequest request) {
        MemberDto memberDto = new MemberDto();
        memberDto.setBirthDay(request.getBirthDay());
        memberDto.setName(request.getName());
        memberDto.setLastName(request.getLastName());
        memberDto.setEmail(request.getEmail());
        memberDto.setPassword(mailService.generatePassword());

        return memberDto;
    }

}
