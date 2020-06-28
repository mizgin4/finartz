package com.example.finartz_project.controller;

import com.example.finartz_project.model.request.VacationRequest;
import com.example.finartz_project.model.response.VacationResponse;
import com.example.finartz_project.service.VacationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/vacation")
public class VacationController {
    private final VacationService vacationService;


    public VacationController(VacationService vacationService) {
        this.vacationService = vacationService;
    }

    @PostMapping("/vacationrequest")
    public ResponseEntity<VacationResponse> vacationRequest(@RequestBody VacationRequest request) {
        return ResponseEntity.ok(vacationService.vacationRequest(request));

    }
}



