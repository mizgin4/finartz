package com.example.finartz_project.service.converter;

import com.example.finartz_project.model.dto.DemandDto;
import com.example.finartz_project.controller.request.CreateDemandRequest;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
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
