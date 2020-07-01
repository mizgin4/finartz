package com.example.finartz_project.controller;

import com.example.finartz_project.controller.request.CreateDemandRequest;
import com.example.finartz_project.controller.response.DemandResponse;
import com.example.finartz_project.service.DemandService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.time.format.DateTimeFormatter;


@RestController
@RequestMapping("/demand")
public class DemandController {
    private final DemandService demandService;


    public DemandController(DemandService demandService) {
        this.demandService = demandService;
    }

    @PostMapping("/demandrequest")
    public ResponseEntity<DemandResponse> createDemand(@RequestBody CreateDemandRequest request) {
        return ResponseEntity.ok(demandService.vacationRequest(request));

    }

    @GetMapping("/{member}")
    public ResponseEntity<DemandResponse> getDemandByMember(@PathVariable String member){
        return ResponseEntity.ok(demandService.findDemandByMember(member));
    }

}



