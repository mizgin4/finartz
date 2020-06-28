package com.example.finartz_project.model.response;

import com.example.finartz_project.model.dto.VacationDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class VacationResponse {

    public static VacationResponse getResponse(VacationDto vacationDto) {
        VacationResponse response = new VacationResponse();
        response.setStartDate(vacationDto.getStartDate());
        response.setEndDate(vacationDto.getEndDate());
        response.setTotalVacationTime(vacationDto.getTotalVacationTime());


        return response;
    }

        private String startDate;

        private String endDate;

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

