package com.example.finartz_project.service;

import com.example.finartz_project.model.request.CreateMemberRequest;
import com.example.finartz_project.model.dto.MemberDto;
import com.example.finartz_project.model.response.SignUpResponse;


public interface MemberService {
    SignUpResponse createMember(CreateMemberRequest request) throws Exception;
}
