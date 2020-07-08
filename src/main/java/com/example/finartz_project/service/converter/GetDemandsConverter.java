package com.example.finartz_project.service.converter;

import com.example.finartz_project.model.dto.DemandDto;
import com.example.finartz_project.model.entity.DemandEntity;
import org.springframework.stereotype.Component;

@Component
public class GetDemandsConverter {

    public DemandDto convert(DemandEntity source) {
        if (source == null) {
            return null;
        }
        DemandDto target = new DemandDto();
        target.setMemberId(source.getMember().getMemberId());
        target.setStartDate(source.getStartDate());
        target.setEndDate(source.getEndDate());
        target.setTotalDemandTime(source.getTotalDemandTime());
        target.setDemandType(source.getDemandType());
        return target;
    }

}
