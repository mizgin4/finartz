package com.example.finartz_project.controller;

import com.example.finartz_project.controller.request.AddRoleRequest;
import com.example.finartz_project.controller.request.CreateDemandRequest;
import com.example.finartz_project.controller.request.UpdatePasswordRequest;
import com.example.finartz_project.controller.response.*;
import com.example.finartz_project.model.dto.DemandDto;
import com.example.finartz_project.service.DemandService;
import com.example.finartz_project.service.MemberService;
import com.example.finartz_project.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
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
        return ResponseEntity.ok(demandService.createDemand(request));


    }



    @PutMapping("/updatepassword/{id}")
    public ResponseEntity<UpdatePasswordResponse> updatePassword(@PathVariable("id") Long id, @RequestBody UpdatePasswordRequest request) throws Exception {

        return ResponseEntity.ok(memberService.updatePassword(request,id));
    }

    @PostMapping("/addRole")
    public ResponseEntity<AddRoleResponse> addRole(@RequestBody AddRoleRequest request){
        return ResponseEntity.ok(roleService.addRole(request)) ;
    }


    @PostMapping("/delete/{id}")
    public ResponseEntity<MemberDeleteResponse> delete(@PathVariable("id") Long id){

        return ResponseEntity.ok(memberService.deleteMember(id));
    }

    @GetMapping("/demandsforapproval")
    public ResponseEntity<List<DemandDto>> demandsWaitingForApproval(){
        return ResponseEntity.ok(demandService.demandsForApproval());
    }

    @PostMapping("/approvedemand/{memberid}/{demandid}")
    public ResponseEntity<DemandApproveResponse> approveDemand(@PathVariable("memberid") Long memberid, @PathVariable("demandid") Long demandid){
        return ResponseEntity.ok(demandService.demandApprove( memberid, demandid));
    }





}
