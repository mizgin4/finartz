package com.example.finartz_project.service.imp;

import com.example.finartz_project.model.dto.DemandDto;
import com.example.finartz_project.controller.request.CreateDemandRequest;
import com.example.finartz_project.controller.response.DemandResponse;
import com.example.finartz_project.model.entity.DemandEntity;
import com.example.finartz_project.repository.DemandRepository;
import com.example.finartz_project.service.DemandService;
import com.example.finartz_project.service.converter.DemandConverter;
import com.example.finartz_project.service.converter.DemandRequestConverter;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return getResponse(demandDto);
    }


    public static DemandResponse getResponse(DemandDto demandDto) {
        DemandResponse response = new DemandResponse();
        response.setStartDate(demandDto.getStartDate());
        response.setEndDate(demandDto.getEndDate());
        response.setTotalVacationTime(demandDto.getTotalVacationTime());
        response.setDemandType(demandDto.getDemandType());
        return response;
    }

    @Override
    public DemandResponse findDemandByMember(String member) {
        List<DemandEntity> optional=demandRepository.findByMember(member);
        return (DemandResponse) optional;
    }

}









