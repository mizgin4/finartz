package com.example.finartz_project.model.entity;

import com.example.finartz_project.model.enums.DemandType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class DemandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vacationId;


    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Integer totalVacationTime;

    @Enumerated(EnumType.STRING)
    private DemandType demandType;



    @ManyToOne
    @JoinColumn(name = "memberId",insertable = false,updatable = false)
    public MemberEntity memberEntitySql;





    public DemandType getDemandType() {
        return demandType;
    }

    public void setDemandType(DemandType demandType) {
        this.demandType = demandType;
    }


    public Long getVacationId() {
        return vacationId;
    }

    public void setVacationId(Long id) {
        this.vacationId = id;
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
