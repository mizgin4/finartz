package com.example.finartz_project.model.dto;

import com.example.finartz_project.model.enumeration.DemandType;
import com.example.finartz_project.model.enumeration.Status;

import java.time.LocalDateTime;

public class DemandDto {

    private Long memberId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer totalDemandTime;
    private DemandType demandType;
    private Status status;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
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

    public DemandType getDemandType() {
        return demandType;
    }

    public void setDemandType(DemandType demandType) {
        this.demandType = demandType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
//joda.DateTime