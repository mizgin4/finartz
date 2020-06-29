package com.example.finartz_project.service.converter;

import com.example.finartz_project.model.dto.DemandDto;
import com.example.finartz_project.controller.request.CreateDemandRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class DemandRequestConverter {
    public static DemandDto convert(CreateDemandRequest request){

        DemandDto demandDto=new DemandDto();
        LocalDateTime startDate=request.getStartDate();
        LocalDateTime endtDate=request.getEndDate();
        long totalVacationDay= ChronoUnit.DAYS.between(endtDate,startDate);
        demandDto.setStartDate(request.getStartDate());
        demandDto.setEndDate(request.getEndDate());
        demandDto.setTotalVacationTime((int) totalVacationDay);
        demandDto.setDemandType(request.getDemandType());
        return demandDto;


    }
}
