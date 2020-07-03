package com.example.finartz_project.service.imp;

import com.example.finartz_project.controller.request.CreateMemberRequest;
import com.example.finartz_project.model.entity.MemberEntity;
import com.example.finartz_project.model.dto.MemberDto;
import com.example.finartz_project.controller.response.SignUpResponse;
import com.example.finartz_project.repository.MemberRepository;
import com.example.finartz_project.service.MemberService;
import com.example.finartz_project.service.converter.CreateMemberRequestConverter;
import com.example.finartz_project.service.converter.MemberConverter;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private MailService mailService;

    MemberServiceImpl(MemberRepository memberRepository, MailService mailService) {
        this.memberRepository = memberRepository;
        this.mailService = mailService;
    }


    //Random random=new Random();




    @Override
    public SignUpResponse createMember(CreateMemberRequest request) throws Exception {
        Optional<MemberEntity> optionalMember = memberRepository.getMembetByEmail(request.getEmail());
        if (optionalMember.isPresent()) {
            throw new Exception("Member already exist");
        }

        MemberDto memberDto = CreateMemberRequestConverter.convert(request);
        memberRepository.save(MemberConverter.convert(memberDto));
        //mailService.sendNotification(request);

        return getResponse(memberDto);

    }

    public static SignUpResponse getResponse(MemberDto memberDto) {
        SignUpResponse response = new SignUpResponse();
        //response.setMemberId(memberDto.getMemberId());
        response.setBirthDay(memberDto.getBirthDay());
        response.setName(memberDto.getName());
        response.setLastName(memberDto.getLastName());
        response.getEmail(memberDto.getEmail());
        return response;

    }


}