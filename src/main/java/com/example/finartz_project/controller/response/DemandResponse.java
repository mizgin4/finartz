package com.example.finartz_project.controller.response;

import com.example.finartz_project.model.dto.DemandDto;
import com.example.finartz_project.model.enums.DemandType;

import java.time.LocalDateTime;


public class DemandResponse {

        private LocalDateTime startDate;

        private LocalDateTime endDate;

        private Integer totalVacationTime;
        private DemandType demandType;


        public DemandType getDemandType() {
        return demandType;
    }

    public void setDemandType(DemandType demandType) {
        this.demandType = demandType;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Integer getTotalVacationTime() {
        return totalVacationTime;
    }

    public void setTotalVacationTime(Integer totalVacationTime) {
        this.totalVacationTime = totalVacationTime;
    }


    public static DemandResponse getResponse(DemandDto demandDto) {
        DemandResponse response = new DemandResponse();
        response.setStartDate(demandDto.getStartDate());
        response.setEndDate(demandDto.getEndDate());
        response.setTotalVacationTime(demandDto.getTotalVacationTime());
        response.setDemandType(demandDto.getDemandType());



        return response;
    }
}

