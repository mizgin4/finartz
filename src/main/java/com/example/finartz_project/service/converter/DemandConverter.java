package com.example.finartz_project.service.converter;

import com.example.finartz_project.model.dto.DemandDto;
import com.example.finartz_project.model.entity.DemandEntity;

public class DemandConverter {

    public static DemandEntity convert(DemandDto demandDto){
        DemandEntity demandEntity =new DemandEntity();
        demandEntity.setStartDate(demandDto.getStartDate());
        demandEntity.setEndDate(demandDto.getEndDate());
        demandEntity.setTotalVacationTime(demandDto.getTotalVacationTime());
        demandEntity.setDemandType(demandDto.getDemandType());
        return demandEntity;
    }
}