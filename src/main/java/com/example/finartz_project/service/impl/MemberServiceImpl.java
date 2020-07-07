package com.example.finartz_project.service.impl;

import com.example.finartz_project.controller.request.CreateMemberRequest;
import com.example.finartz_project.controller.request.UpdatePasswordReqeust;
import com.example.finartz_project.controller.response.CreateMemberResponse;
import com.example.finartz_project.controller.response.UpdatePasswordResponse;
import com.example.finartz_project.model.dto.MemberDto;
import com.example.finartz_project.model.entity.MemberEntity;
import com.example.finartz_project.repository.MemberRepository;
import com.example.finartz_project.service.MemberService;
import com.example.finartz_project.service.converter.CreateMemberRequestConverter;
import com.example.finartz_project.service.converter.MemberEntityConverter;
import com.example.finartz_project.service.internal.MailService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MailService mailService;
    private final CreateMemberRequestConverter createMemberRequestConverter;
    private final MemberEntityConverter memberEntityConverter;

    MemberServiceImpl(MemberRepository memberRepository, MailService mailService,
                      CreateMemberRequestConverter createMemberRequestConverter,
                      MemberEntityConverter memberEntityConverter) {
        this.memberRepository = memberRepository;
        this.mailService = mailService;
        this.createMemberRequestConverter = createMemberRequestConverter;
        this.memberEntityConverter = memberEntityConverter;
    }

    @Override
    public CreateMemberResponse createMember(CreateMemberRequest request) throws Exception {

        Optional<MemberEntity> optionalMember = memberRepository.getMemberByEmail(request.getEmail());

        if (optionalMember.isPresent()) {
            throw new Exception("Member already exist");
        }

        String password = mailService.generatePassword();

        MemberDto memberDto = createMemberRequestConverter.convert(request, password);

        MemberEntity memberEntity = memberEntityConverter.convert(memberDto);

        memberRepository.save(memberEntity);
        //For sending passwords via mails.Works but closed for dev. purposes
        //mailService.sendNotification(request);

        return getResponse(memberDto);
    }

    @Override
    public UpdatePasswordResponse updatePassword(UpdatePasswordReqeust reqeust,Long id) {
        MemberEntity memberEntity= memberRepository.getOne(id);
        memberEntity.setPassword(reqeust.getPassword());
        memberRepository.save(memberEntity);
        return updateResponse(memberEntity);

    }

    private UpdatePasswordResponse updateResponse(MemberEntity memberEntity) {
        UpdatePasswordResponse response = new UpdatePasswordResponse();
        response.setPassword(memberEntity.getPassword());
        return response;

    }


    private CreateMemberResponse getResponse(MemberDto memberDto) {

        CreateMemberResponse response = new CreateMemberResponse();

        response.setMemberId(memberDto.getMemberId());
        response.setBirthDay(memberDto.getBirthDay());
        response.setName(memberDto.getName());
        response.setLastName(memberDto.getLastName());
        response.setEmail(memberDto.getEmail());

        return response;
    }
}