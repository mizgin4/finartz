package com.example.finartz_project.service.converter;

import com.example.finartz_project.controller.request.CreateDemandRequest;
import com.example.finartz_project.model.dto.DemandDto;
import com.example.finartz_project.model.enumeration.Status;
import org.springframework.stereotype.Component;

import java.time.temporal.ChronoUnit;

@Component
public class DemandRequestConverter {

    public DemandDto convert(CreateDemandRequest request) {

        DemandDto demandDto = new DemandDto();

        demandDto.setMemberId(request.getMemberId());
        demandDto.setStartDate(request.getStartDate());
        demandDto.setEndDate(request.getEndDate());
        demandDto.setDemandType(request.getDemandType());
        demandDto.setStatus(Status.WAITINGFORAPPRROVAL);
        //Integer totalDemandTime = Days.daysBetween(request.getStartDate(), request.getEndDate()).getDays();
        long totalDemandTime = ChronoUnit.DAYS.between(request.getStartDate(), request.getEndDate());
        demandDto.setTotalDemandTime((int) totalDemandTime);

        return demandDto;
    }
}