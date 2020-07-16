package com.example.finartz_project.controller.response;

import com.example.finartz_project.model.enumeration.DemandType;
import com.example.finartz_project.model.enumeration.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;


public class DemandResponse {

    private Long demandId;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime startDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime endDate;

    private Integer totalDemandTime;

    private DemandType demandType;

    private Status status;

    public Long getDemandId() {
        return demandId;
    }

    public void setDemandId(Long demandId) {
        this.demandId = demandId;
    }

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

    public Integer getTotalDemandTime() {
        return totalDemandTime;
    }

    public void setTotalDemandTime(Integer totalDemandTime) {
        this.totalDemandTime = totalDemandTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

