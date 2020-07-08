package com.example.finartz_project.controller;

import com.example.finartz_project.model.dto.DemandDto;
import com.example.finartz_project.repository.DemandRepository;
import com.example.finartz_project.service.DemandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/memberdemands")
public class MemberLoadingController {
    private final DemandService demandService;
    private final DemandRepository demandRepository;

    public MemberLoadingController(DemandService demandService, DemandRepository demandRepository) {
        this.demandService = demandService;
        this.demandRepository = demandRepository;
    }


    //Find demands for givin memberId
    @GetMapping("/{memberId}")
    public ResponseEntity<List<DemandDto>> getDemandByMemberId(@PathVariable Long memberId){
        return ResponseEntity.ok(demandService.getDemandsbyMemberId(memberId));
    }



}
