package com.example.finartz_project.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;


public class VacationRequest {
    private Long vacationId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private String startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private String endDate;
    private String totalVacationTime;

    public Long getVacationId() {
        return vacationId;
    }

    public void setVacationId(Long vacationId) {
        this.vacationId = vacationId;
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
