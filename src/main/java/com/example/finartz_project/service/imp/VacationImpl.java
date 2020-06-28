package com.example.finartz_project.service.imp;

import com.example.finartz_project.model.dto.VacationDto;
import com.example.finartz_project.model.request.VacationRequest;
import com.example.finartz_project.model.response.VacationResponse;
import com.example.finartz_project.repository.VacationRepository;
import com.example.finartz_project.service.VacationService;
import com.example.finartz_project.service.converter.VacationConverter;
import com.example.finartz_project.service.converter.VacationRequestConverter;
import com.sun.xml.internal.ws.developer.Serialization;
import org.springframework.stereotype.Service;

@Service
public class VacationImpl implements VacationService {
    private final VacationRepository vacationRepository;

    public VacationImpl(VacationRepository vacationRepository) {
        this.vacationRepository = vacationRepository;
    }

    @Override
    public VacationResponse vacationRequest(VacationRequest request) {

        VacationDto vacationDto= VacationRequestConverter.convert(request);
        vacationRepository.save(VacationConverter.convert(vacationDto));
        return VacationResponse.getResponse(vacationDto);
    }

//    private VacationResponse getResponse(VacationDto vacationDto) {
//        VacationResponse response=new VacationResponse();
//        response.setStartDate(vacationDto.getStartDate());
//        response.setEndDate(vacationDto.getEndDate());
//        response.setTotalVacationTime(vacationDto.getTotalVacationTime());
//        return VacationResponse.getResponse(response);
//
//    }
}









