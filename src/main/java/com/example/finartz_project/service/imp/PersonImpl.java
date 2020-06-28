package com.example.finartz_project.service.imp;

import com.example.finartz_project.model.request.CreateMemberRequest;
//import com.example.finartz_project.converter.PersonConverter;
//import com.example.finartz_project.converter.PersonRequestConverter;
import com.example.finartz_project.model.entity.MemberEntity;
import com.example.finartz_project.model.dto.MemberDto;
import com.example.finartz_project.model.response.SignUpResponse;
import com.example.finartz_project.repository.PersonRepository;
import com.example.finartz_project.service.MemberService;
import com.example.finartz_project.service.converter.CreateMemberRequestConverter;
import com.example.finartz_project.service.converter.MemberConverter;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class PersonImpl implements MemberService {

    private final PersonRepository personRepository;

    public PersonImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;

    }


//    @Override
//    public MemberDto createMember(CreateMemberRequest request) throws Exception {
//        Optional<MemberEntity> optionalMemberEntity = personRepository.existsPeopleByEmail(request.getEmail());
//        if (!optionalMemberEntity.isPresent()) {
//            throw new Exception("Member already exist");
//        }
//        MemberDto memberDto = CreateMemberRequestConverter.convert(request);
//        personRepository.save(MemberConverter.convert(memberDto));
//        return memberDto;
//    }


    @Override
    public SignUpResponse createMember(CreateMemberRequest request) throws Exception {
        Optional<MemberEntity> optionalMember = personRepository.existsPeopleByEmail(request.getEmail());
        if (!optionalMember.isPresent()) {
            throw new Exception("Member already exist");
        }
        MemberDto memberDto = CreateMemberRequestConverter.convert(request);
        personRepository.save(MemberConverter.convert(memberDto));

        //
        return SignUpResponse.getResponse(memberDto);

    }


}