package com.example.finartz_project.service;

import com.example.finartz_project.controller.request.CreateDemandRequest;
import com.example.finartz_project.controller.response.DemandResponse;
import com.example.finartz_project.model.dto.DemandDto;

import java.util.List;

public interface DemandService {

    DemandResponse createDemand(CreateDemandRequest request);
    List<DemandDto> getDemandsbyMemberId(Long memberId);






}