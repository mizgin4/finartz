package com.example.finartz_project.service;

import com.example.finartz_project.controller.request.CreateMemberRequest;
import com.example.finartz_project.controller.response.SignUpResponse;


public interface MemberService {
    SignUpResponse createMember(CreateMemberRequest request) throws Exception;
}
