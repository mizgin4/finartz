package com.example.finartz_project.service.converter;

import com.example.finartz_project.model.dto.DemandDto;
import com.example.finartz_project.model.entity.DemandEntity;
import com.example.finartz_project.model.entity.MemberEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DemandEntityConverter {

    public DemandEntity convert(DemandDto demandDto, MemberEntity memberEntity){

        DemandEntity demandEntity =new DemandEntity();

        demandEntity.setMember(memberEntity);
        demandEntity.setDemandType(demandDto.getDemandType());
        demandEntity.setStartDate(demandDto.getStartDate());
        demandEntity.setEndDate(demandDto.getEndDate());
        demandEntity.setTotalDemandTime(demandDto.getTotalDemandTime());

        return demandEntity;
    }

}