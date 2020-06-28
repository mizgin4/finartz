package com.example.finartz_project.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

@Entity
public class VacationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vacationId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private String startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private String endDate;

    private String totalVacationTime;



    @ManyToOne
    @JoinColumn(name = "memberId",insertable = false,updatable = false)
    public MemberEntity memberEntitySql;


    public Long getVacationId() {
        return vacationId;
    }

    public void setVacationId(Long id) {
        this.vacationId = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTotalVacationTime() {
        return totalVacationTime;
    }

    public void setTotalVacationTime(String totalVacationTime) {
        this.totalVacationTime = totalVacationTime;
    }


}
