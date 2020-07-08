package com.example.finartz_project.controller;

import com.example.finartz_project.controller.request.CreateMemberRequest;
import com.example.finartz_project.controller.response.CreateMemberResponse;
import com.example.finartz_project.service.MemberService;
import com.example.finartz_project.service.internal.impl.MailServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController

@RequestMapping("/auth")
public class AdminUpdatingController {
    private final MemberService memberService;
    private MailServiceImpl mailServiceImpl;

    public AdminUpdatingController(MemberService memberService, MailServiceImpl mailServiceImpl) {
        this.memberService = memberService;
        this.mailServiceImpl = mailServiceImpl;
    }


    //@PostMapping(value = AdminControllerEndpoint.CREATE_DEMAND)
    @PostMapping("/createmember") //sneaky code
    public ResponseEntity<CreateMemberResponse> createMember(
            @Valid @RequestBody CreateMemberRequest request)
            throws Exception {

        return ResponseEntity.ok(memberService.createMember(request));
    }
}
