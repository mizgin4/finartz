package com.example.finartz_project.controller;

import com.example.finartz_project.controller.request.SignInRequest;
import com.example.finartz_project.controller.response.SignInResponse;
import com.example.finartz_project.service.MemberService;
import com.example.finartz_project.service.internal.impl.MailServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/signin")
public class LoginController {
    private final MemberService memberService;
    private MailServiceImpl notificationService;


    public LoginController(MemberService memberService, MailServiceImpl notificationService) {
        this.memberService = memberService;
        this.notificationService = notificationService;
    }


    //bu burada kalsın
    @PostMapping("/signin")
    public ResponseEntity<SignInResponse> memberSignIn(@RequestBody SignInRequest request) {
        return null;
    }
}


//    //adminUpdating'e taşı
//    @PostMapping("/signup")
//    public ResponseEntity<CreateMemberResponse> createMember(
//            @Valid @RequestBody @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) CreateMemberRequest request)
//            throws Exception {
//        //notificationService.sendNotification(request);
//        return ResponseEntity.ok(memberService.createMember(request));
//    }
//
