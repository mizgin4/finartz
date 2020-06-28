package com.example.finartz_project.service.converter;

import com.example.finartz_project.model.dto.VacationDto;
import com.example.finartz_project.model.request.VacationRequest;



public class VacationRequestConverter {
    public static VacationDto convert(VacationRequest request){
        VacationDto vacationDto=new VacationDto();
        String startDate=request.getStartDate();
        String endtDate=request.getEndDate();
        String[] calcuateDifference= (startDate+"/"+endtDate).split("/");
        Integer totalVacationTimeDays= Integer.parseInt(calcuateDifference[3])-Integer.parseInt(calcuateDifference[0]);
        Integer totalVacationTimeMonths= Integer.parseInt(calcuateDifference[4])-Integer.parseInt(calcuateDifference[1]);
        String totalVacationTime =totalVacationTimeDays.toString()+"/"+totalVacationTimeMonths.toString();

        vacationDto.setStartDate(request.getStartDate());
        vacationDto.setEndDate(request.getEndDate());
        vacationDto.setTotalVacationTime(totalVacationTime);
        return vacationDto;

    }
}
