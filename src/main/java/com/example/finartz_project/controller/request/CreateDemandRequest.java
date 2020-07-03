package com.example.finartz_project.controller.request;

import com.example.finartz_project.model.entity.MemberEntity;
import com.example.finartz_project.model.enums.DemandType;
import com.fasterxml.jackson.annotation.JsonFormat;


import java.time.LocalDateTime;



public class CreateDemandRequest {
    //private Long vacationId;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDate;
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




//    public Long getVacationId() {
//        return vacationId;
//    }
//
//    public void setVacationId(Long vacationId) {
//        this.vacationId = vacationId;
//    }

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



}
