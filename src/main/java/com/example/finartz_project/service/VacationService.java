package com.example.finartz_project.service;

import com.example.finartz_project.model.request.VacationRequest;
import com.example.finartz_project.model.response.VacationResponse;
import org.springframework.beans.factory.annotation.Autowired;


public interface VacationService {
    VacationResponse vacationRequest(VacationRequest request);
}
