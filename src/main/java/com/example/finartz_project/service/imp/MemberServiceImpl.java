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
import java.util.Random;

@Service
class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;

    }
    Random random=new Random();


    @Override
    public SignUpResponse createMember(CreateMemberRequest request) throws Exception {
        Optional<MemberEntity> optionalMember = memberRepository.getMembetByEmail(request.getEmail());
        if (optionalMember.isPresent()) {
            throw new Exception("Member already exist");
        }
        MemberDto memberDto = CreateMemberRequestConverter.convert(request);
        memberRepository.save(MemberConverter.convert(memberDto));

        //
        return SignUpResponse.getResponse(memberDto);

    }


}