package com.example.finartz_project.model.dto;



public class VacationDto {



    private String startDate;

    private String  endDate;

    private String totalVacationTime;

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
