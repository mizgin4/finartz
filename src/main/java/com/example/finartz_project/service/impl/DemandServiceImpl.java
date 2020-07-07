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
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
class DemandServiceImpl implements DemandService {
    private final DemandRepository demandRepository;
    private final DemandRequestConverter demandRequestConverter;
    private final DemandEntityConverter demandEntityConverter;
    private final MemberRepository memberRepository;

    public DemandServiceImpl(DemandRepository demandRepository,
                             DemandRequestConverter demandRequestConverter,
                             DemandEntityConverter demandEntityConverter,
                             MemberRepository memberRepository) {
        this.demandRepository = demandRepository;
        this.demandRequestConverter = demandRequestConverter;
        this.demandEntityConverter = demandEntityConverter;
        this.memberRepository = memberRepository;
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

//umit ve fatihle yapialn kisim
//    @Override
//    public List<DemandDto> getDemandsbyMemberId(Long memberId) {
//        Optional<MemberEntity> memberEntity= memberRepository.findById(memberId);
//        if(memberEntity.isPresent()){
//            if(CollectionUtils.isEmpty(memberEntity.get().getDemands())) {
//
//            }
//        }
//        List<DemandEntity> demands = memberEntity.get().getDemands();
//
//
//        return convert(demandEntity);
//    }

//    private List<DemandDto> convert(List<DemandEntity> source){
//      return source.stream()
//              .map(this::convert)
//              .collect(Collectors.toList());
//
//    }

//    @Override
//    public List<DemandEntity> findDemandByMemberId(Long memberId) {
//        Optional<MemberEntity> memberEntity=memberRepository.findById(memberId);
//        List<DemandEntity> demands = demandRepository.findByMember(memberEntity);
//        return demands;
//
//    }


    //demand entity'den memberId'ye ilişkin demand listesini getirmen
    // BURA DUZENLENIP YAZILACA





//    private DemandResponse getResponseMemberId(DemandEntity demandEntity){
//        DemandResponse demandResponse=new DemandResponse();
//        List<DemandResponse> demandResponses=demandRepository.findByMember(mem)
//    }

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









