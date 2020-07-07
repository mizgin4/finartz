package com.example.finartz_project.controller;

import com.example.finartz_project.controller.request.CreateDemandRequest;
import com.example.finartz_project.controller.request.UpdatePasswordReqeust;
import com.example.finartz_project.controller.response.DemandResponse;
import com.example.finartz_project.controller.response.UpdatePasswordResponse;
import com.example.finartz_project.service.DemandService;
import com.example.finartz_project.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/update")
public class MemberUpdatingController {
    private final MemberService memberService;
    private final DemandService demandService;


    public MemberUpdatingController(MemberService memberService,DemandService demandService) {
        this.memberService = memberService;
        this.demandService = demandService;

    }

    //Demand Request
    @PostMapping("/demandrequest")
    public ResponseEntity<DemandResponse> createDemand(@RequestBody CreateDemandRequest request) {
        return ResponseEntity.ok(demandService.createDemand(request));

    }


    //Update password
    //Retuns useses directly entity,gotta change
    @PutMapping("/{id}")
    public ResponseEntity<UpdatePasswordResponse> edit(@PathVariable("id") Long id, @RequestBody UpdatePasswordReqeust request){

        return ResponseEntity.ok(memberService.updatePassword(request,id));
    }





}
