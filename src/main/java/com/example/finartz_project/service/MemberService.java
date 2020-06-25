package com.example.finartz_project.service;

import com.example.finartz_project.controller.request.CreateMemberRequest;
import com.example.finartz_project.model.dto.PersonDto;


public interface MemberService {

    PersonDto createMember(CreateMemberRequest request);
    PersonDto getPersonbyId(Long id);
}
