package com.example.finartz_project.service;

import com.example.finartz_project.controller.request.CreateMemberRequest;
import com.example.finartz_project.controller.request.SignInRequest;
import com.example.finartz_project.controller.request.UpdatePasswordReqeust;
import com.example.finartz_project.controller.response.CreateMemberResponse;
import com.example.finartz_project.controller.response.MemberDeleteResponse;
import com.example.finartz_project.controller.response.UpdatePasswordResponse;
import com.example.finartz_project.model.entity.MemberEntity;

public interface MemberService {

    CreateMemberResponse createMember(CreateMemberRequest request) throws Exception;
    UpdatePasswordResponse updatePassword(UpdatePasswordReqeust reqeust,Long id);
    String signIn(SignInRequest request);
    MemberDeleteResponse deleteMember(Long id);

}
