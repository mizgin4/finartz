package com.example.finartz_project.model.dto;


import com.example.finartz_project.model.entity.MemberEntity;
import com.example.finartz_project.model.enums.DemandType;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

public class DemandDto {

    ZonedDateTime now=ZonedDateTime.now(ZoneId.of("UTC"));

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Integer totalVacationTime;

    private DemandType demandType;

    private MemberEntity member;

    public MemberEntity getMember() {
        return member;
    }

    public void setMember(MemberEntity member) {
        this.member = member;
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

    public Integer getTotalVacationTime() {
        return totalVacationTime;
    }

    public void setTotalVacationTime(Integer totalVacationTime) {
        this.totalVacationTime = totalVacationTime;
    }
}
