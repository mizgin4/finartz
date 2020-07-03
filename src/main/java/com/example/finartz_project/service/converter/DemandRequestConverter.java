package com.example.finartz_project.service.converter;

import com.example.finartz_project.model.dto.DemandDto;
import com.example.finartz_project.controller.request.CreateDemandRequest;

import java.time.temporal.ChronoUnit;


public class DemandRequestConverter {
    public static DemandDto convert(CreateDemandRequest request){


        DemandDto demandDto=new DemandDto();
        demandDto.setStartDate(request.getStartDate());
        demandDto.setEndDate(request.getEndDate());
        demandDto.setDemandType(request.getDemandType());
        demandDto.setMember(request.getMember());
        long totalVacationTime=ChronoUnit.DAYS.between(request.getStartDate(),request.getEndDate());
        demandDto.setTotalVacationTime((int)totalVacationTime);
        return demandDto;


    }
}
