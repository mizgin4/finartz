package com.example.finartz_project.service.impl;

import com.example.finartz_project.controller.request.CreateMemberRequest;
import com.example.finartz_project.controller.request.SignInRequest;
import com.example.finartz_project.controller.request.UpdatePasswordRequest;
import com.example.finartz_project.controller.response.CreateMemberResponse;
import com.example.finartz_project.controller.response.MemberDeleteResponse;
import com.example.finartz_project.controller.response.UpdatePasswordResponse;
import com.example.finartz_project.model.dto.MemberDto;
import com.example.finartz_project.model.entity.MemberEntity;
import com.example.finartz_project.model.enumeration.MemberStatus;
import com.example.finartz_project.repository.MemberRepository;
import com.example.finartz_project.service.MemberService;
import com.example.finartz_project.service.converter.CreateMemberRequestConverter;
import com.example.finartz_project.service.converter.MemberEntityConverter;
import com.example.finartz_project.service.internal.MailService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MailService mailService;
    private final CreateMemberRequestConverter createMemberRequestConverter;
    private final MemberEntityConverter memberEntityConverter;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


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

        String password = passwordEncoder(mailService.generatePassword());

        MemberDto memberDto = createMemberRequestConverter.convert(request);

        MemberEntity memberEntity = memberEntityConverter.convert(memberDto,password);

        memberRepository.save(memberEntity);
        memberDto.setMemberId(memberEntity.getMemberId());
        //mailService.sendNotification(request);

        return getResponse(memberDto);
    }
//request.getOldPassword().equals(memberEntity.get().getPassword()) && request.getName().equals(memberEntity.get().getName())
    //FindByMemberId ile bagladim
    @Override
    public UpdatePasswordResponse updatePassword(UpdatePasswordRequest request, Long id) throws Exception {
        Optional<MemberEntity> memberEntity= Optional.ofNullable(memberRepository.findByMemberId(id));
        if (memberEntity.isPresent()) {
            if (encoder.matches(request.getOldPassword(),memberEntity.get().getPassword())&&request.getName().equals(memberEntity.get().getName())) {
                memberEntity.get().setPassword(passwordEncoder(request.getNewPassword()));
                memberRepository.save(memberEntity.get());
                return updateResponse();
            }else{
                throw  new Exception("Username or password is not correct ");
            }
        }
        throw  new Exception("member not exits");

    }

    @Override
    public String signIn(SignInRequest request)   {
        Optional<MemberEntity> optionalMemberEntity=memberRepository.getMemberByEmail(request.getEmail());

        if(optionalMemberEntity.isPresent()){
            MemberEntity member = memberRepository.getMemberEntityByEmail(request.getEmail());
            if (encoder.matches(member.getPassword(),request.getPassword()) && member.getEmail().equals(request.getEmail())) {
                return "Succesfully signed in";
            }
        }

        return "User not found";
    }

    @Override
    public MemberDeleteResponse deleteMember(Long id) {
        MemberEntity memberEntity=memberRepository.findByMemberId(id);
        memberEntity.setIsdeleted(MemberStatus.PASSIVE);
        return null;
    }


    private UpdatePasswordResponse updateResponse() {
        UpdatePasswordResponse response = new UpdatePasswordResponse();
        //response.setPassword(memberEntity.getPassword());
        response.getMesg();
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

    private String passwordEncoder(String password) {
        return encoder.encode(password);
    }
}