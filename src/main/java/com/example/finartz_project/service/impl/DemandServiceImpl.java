package com.example.finartz_project.service.impl;

import com.example.finartz_project.controller.request.CreateDemandRequest;
import com.example.finartz_project.controller.response.DemandResponse;
import com.example.finartz_project.model.dto.DemandDto;
import com.example.finartz_project.model.entity.DemandEntity;
import com.example.finartz_project.model.entity.MemberEntity;
import com.example.finartz_project.repository.DemandRepository;
import com.example.finartz_project.repository.MemberRepository;
import com.example.finartz_project.service.DemandService;
import com.example.finartz_project.service.converter.DemandEntityConverter;
import com.example.finartz_project.service.converter.DemandRequestConverter;
import com.example.finartz_project.service.converter.GetDemandsConverter;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
class DemandServiceImpl implements DemandService {
    private final DemandRepository demandRepository;
    private final DemandRequestConverter demandRequestConverter;
    private final DemandEntityConverter demandEntityConverter;
    private final MemberRepository memberRepository;
    private final GetDemandsConverter getDemandsConverter;

    public DemandServiceImpl(DemandRepository demandRepository,
                             DemandRequestConverter demandRequestConverter,
                             DemandEntityConverter demandEntityConverter,
                             MemberRepository memberRepository,
                             GetDemandsConverter getDemandsConverter) {
        this.demandRepository = demandRepository;
        this.demandRequestConverter = demandRequestConverter;
        this.demandEntityConverter = demandEntityConverter;
        this.memberRepository = memberRepository;
        this.getDemandsConverter = getDemandsConverter;
    }


    @Override
    public DemandResponse createDemand(CreateDemandRequest request) {

        DemandDto demandDto = demandRequestConverter.convert(request);

        Optional<MemberEntity> optionalMemberEntity = memberRepository.findById(request.getMemberId());

        if (!optionalMemberEntity.isPresent()) {
            throw new NullPointerException("Member is not found!");
        }

        MemberEntity memberEntity = optionalMemberEntity.get();

        DemandEntity demandEntity = demandEntityConverter.convert(demandDto, memberEntity);

        demandRepository.save(demandEntity);

        return getResponse(demandDto, demandEntity);

    }


    @Override
    public List<DemandDto> getDemandsbyMemberId(Long memberId) {
        Optional<MemberEntity> memberEntity = memberRepository.findById(memberId);
        List<DemandEntity> demandEntity= demandRepository.findByMember(memberEntity);
        return demandEntity.stream().filter(Objects::nonNull).map(this::convert).collect(Collectors.toList());

    }
    private DemandDto convert(DemandEntity source) {
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


    private DemandResponse getResponse(DemandDto demandDto, DemandEntity demandEntity) {

        DemandResponse response = new DemandResponse();

        response.setDemandId(demandEntity.getDemandId());
        response.setStartDate(demandDto.getStartDate());
        response.setEndDate(demandDto.getEndDate());
        response.setTotalDemandTime(demandDto.getTotalDemandTime());
        response.setDemandType(demandDto.getDemandType());

        return response;
    }
}








