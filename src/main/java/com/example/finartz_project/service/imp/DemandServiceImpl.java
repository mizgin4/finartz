package com.example.finartz_project.service.imp;

import com.example.finartz_project.model.dto.DemandDto;
import com.example.finartz_project.controller.request.CreateDemandRequest;
import com.example.finartz_project.controller.response.DemandResponse;
import com.example.finartz_project.repository.DemandRepository;
import com.example.finartz_project.service.DemandService;
import com.example.finartz_project.service.converter.DemandConverter;
import com.example.finartz_project.service.converter.DemandRequestConverter;

import org.springframework.stereotype.Service;

@Service
class DemandServiceImpl implements DemandService {
    private final DemandRepository demandRepository;

    public DemandServiceImpl(DemandRepository demandRepository) {
        this.demandRepository = demandRepository;
    }

    @Override
    public DemandResponse vacationRequest(CreateDemandRequest request) {

        DemandDto demandDto = DemandRequestConverter.convert(request);
        demandRepository.save(DemandConverter.convert(demandDto));
        return DemandResponse.getResponse(demandDto);
    }

}









