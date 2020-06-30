package com.example.finartz_project.service;

import com.example.finartz_project.controller.request.CreateDemandRequest;
import com.example.finartz_project.controller.response.DemandResponse;
import org.springframework.http.converter.json.GsonBuilderUtils;


public interface DemandService {
    DemandResponse vacationRequest(CreateDemandRequest request);


}
