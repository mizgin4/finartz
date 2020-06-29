package com.example.finartz_project.service;

import com.example.finartz_project.controller.request.CreateDemandRequest;
import com.example.finartz_project.controller.response.DemandResponse;


public interface DemandService {
    DemandResponse vacationRequest(CreateDemandRequest request);
}
