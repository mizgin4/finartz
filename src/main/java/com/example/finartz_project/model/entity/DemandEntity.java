package com.example.finartz_project.model.entity;

import com.example.finartz_project.model.enumeration.DemandType;
import com.example.finartz_project.model.enumeration.Status;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "demand")
public class DemandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEMAND_ID")
    private Long demandId;

    @NotNull
    @JoinColumn(name = "MEMBER_ID", referencedColumnName = "MEMBER_ID", nullable = false)
    @ManyToOne(targetEntity = MemberEntity.class)
    private MemberEntity member;

    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @Column(name = "TOTAL_DEMAND_TIME")
    private Integer totalDemandTime;

    @Column(name = "DEMAND_TYPE")
    @Enumerated(value = EnumType.STRING)
    private DemandType demandType;

    @Column(name = "STATUS_TYPE")
    @Enumerated(value = EnumType.STRING)
    private Status status;

    public Long getDemandId() {
        return demandId;
    }

    public void setDemandId(Long demandId) {
        this.demandId = demandId;
    }

    public MemberEntity getMember() {
        return member;
    }

    public void setMember(MemberEntity member) {
        this.member = member;
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