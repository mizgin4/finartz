package com.example.finartz_project.controller;

import com.example.finartz_project.controller.request.AddRoleRequest;
import com.example.finartz_project.controller.request.CreateDemandRequest;
import com.example.finartz_project.controller.request.UpdatePasswordReqeust;
import com.example.finartz_project.controller.response.AddRoleResponse;
import com.example.finartz_project.controller.response.DemandResponse;
import com.example.finartz_project.controller.response.UpdatePasswordResponse;
import com.example.finartz_project.service.DemandService;
import com.example.finartz_project.service.MemberService;
import com.example.finartz_project.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/update")
public class MemberUpdatingController {
    private final MemberService memberService;
    private final DemandService demandService;
    private final RoleService roleService;


    public MemberUpdatingController(MemberService memberService, DemandService demandService, RoleService roleService) {
        this.memberService = memberService;
        this.demandService = demandService;

        this.roleService = roleService;
    }

    //Demand Request
    @PostMapping("/demandrequest")
    public ResponseEntity<DemandResponse> createDemand(@RequestBody CreateDemandRequest request) {
        //return ResponseEntity.ok(demandService.createDemand(request));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(demandService.createDemand(request));


    }


    //Update password
    //Retuns useses directly entity,gotta change
    @PutMapping("/{id}")
    public ResponseEntity<UpdatePasswordResponse> edit(@PathVariable("id") Long id, @RequestBody UpdatePasswordReqeust request){

        return ResponseEntity.ok(memberService.updatePassword(request,id));
    }

    @PostMapping("/addRole")
    public ResponseEntity<AddRoleResponse> addRole(@RequestBody AddRoleRequest request){
        return ResponseEntity.ok(roleService.addRole(request));
    }





}
