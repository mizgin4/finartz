package com.example.finartz_project.controller;

import com.example.finartz_project.controller.request.CreateMemberRequest;
import com.example.finartz_project.controller.response.SignUpResponse;
import com.example.finartz_project.service.MemberService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/auth")
public class LoginController {
    private final MemberService memberService;



    public LoginController(MemberService memberService) {
        this.memberService = memberService;


    }


    @PostMapping("/signup")
    public ResponseEntity<SignUpResponse> createMember(@Valid @RequestBody  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) CreateMemberRequest request ) throws Exception {
        return ResponseEntity.ok(memberService.createMember(request));
    }


}


