package com.example.finartz_project.controller;

import com.example.finartz_project.controller.request.CreateDemandRequest;
import com.example.finartz_project.controller.response.DemandResponse;
import com.example.finartz_project.service.DemandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/demand")
public class DemandController {
    private final DemandService demandService;


    public DemandController(DemandService demandService) {
        this.demandService = demandService;
    }

    @PostMapping("/demandrequest")
    public ResponseEntity<DemandResponse> demandRequest(@RequestBody CreateDemandRequest request) {
        return ResponseEntity.ok(demandService.vacationRequest(request));

    }
}



