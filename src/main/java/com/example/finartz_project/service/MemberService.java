package com.example.finartz_project.service;

import com.example.finartz_project.controller.request.CreateMemberRequest;
import com.example.finartz_project.controller.request.SignInRequest;
import com.example.finartz_project.controller.request.UpdatePasswordRequest;
import com.example.finartz_project.controller.response.CreateMemberResponse;
import com.example.finartz_project.controller.response.MemberDeleteResponse;
import com.example.finartz_project.controller.response.UpdatePasswordResponse;

public interface MemberService {

    CreateMemberResponse createMember(CreateMemberRequest request) throws Exception;
    UpdatePasswordResponse updatePassword(UpdatePasswordRequest request, Long id) throws Exception;
    String signIn(SignInRequest request);
    MemberDeleteResponse deleteMember(Long id);

}
