package com.example.finartz_project.service.converter;

import com.example.finartz_project.model.dto.VacationDto;
import com.example.finartz_project.model.entity.VacationEntity;

public class VacationConverter {

    public static VacationEntity convert(VacationDto vacationDto){
        VacationEntity vacationEntity=new VacationEntity();
        vacationEntity.setStartDate(vacationDto.getStartDate());
        vacationEntity.setEndDate(vacationDto.getEndDate());
        vacationEntity.setTotalVacationTime(vacationDto.getTotalVacationTime());
        return  vacationEntity;
    }
}
