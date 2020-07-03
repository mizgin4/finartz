package com.example.finartz_project.controller;

import com.example.finartz_project.controller.request.CreateMemberRequest;
import com.example.finartz_project.controller.request.SignInRequest;
import com.example.finartz_project.controller.response.SignInResponse;
import com.example.finartz_project.controller.response.SignUpResponse;
import com.example.finartz_project.service.MemberService;
import com.example.finartz_project.service.imp.MailService;
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
    private MailService notificationService;




    public LoginController(MemberService memberService, MailService notificationService) {
        this.memberService = memberService;


        this.notificationService = notificationService;
    }
    @PostMapping("/signup")
    public ResponseEntity<SignUpResponse> createMember(@Valid @RequestBody  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) CreateMemberRequest request ) throws Exception {
        //notificationService.sendNotification(request);
        return ResponseEntity.ok(memberService.createMember(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<SignInResponse> memberSignIn(@RequestBody SignInRequest request){
        return null;
    }


}


