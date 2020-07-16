package com.example.finartz_project.service.converter;

import com.example.finartz_project.model.dto.DemandDto;
import com.example.finartz_project.model.dto.MemberDto;
import com.example.finartz_project.model.dto.RoleDto;
import com.example.finartz_project.model.entity.DemandEntity;
import com.example.finartz_project.model.entity.MemberEntity;
import com.example.finartz_project.model.entity.RoleEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemberEntityConverter {

    public MemberEntity convert(MemberDto source, String password) {

        if (source == null) {
            return null;
        }

        MemberEntity memberEntity = new MemberEntity();

        memberEntity.setName(source.getName());
        memberEntity.setLastName(source.getLastName());
        memberEntity.setBirthDay(source.getBirthDay());
        memberEntity.setEmail(source.getEmail());
        memberEntity.setPassword(source.getPassword());
        memberEntity.setRoles(source.getRoles());
        memberEntity.setPassword(password);

        if (!CollectionUtils.isEmpty(source.getDemands())){
            memberEntity.setDemands(getDemands(source.getDemands(), memberEntity));
        }

//        if (!CollectionUtils.isEmpty(source.getRoles())){
//            memberEntity.setRoles(getRoles(source.getRoles()));
//        }

        return memberEntity;
    }




    private List<DemandEntity> getDemands(List<DemandDto> demands, MemberEntity memberEntity) {

        List<DemandEntity> demandEntities = new ArrayList<>();

        for (DemandDto demandDto : demands){

            DemandEntity demandEntity = getDemandEntity(demandDto, memberEntity);

            demandEntities.add(demandEntity);
        }

        return demandEntities;
    }

    private DemandEntity getDemandEntity(DemandDto demandDto, MemberEntity memberEntity) {

        DemandEntity demandEntity = new DemandEntity();

        demandEntity.setMember(memberEntity);
        demandEntity.setDemandType(demandDto.getDemandType());
        demandEntity.setStartDate(demandDto.getStartDate());
        demandEntity.setEndDate(demandDto.getEndDate());
        demandEntity.setTotalDemandTime(demandDto.getTotalDemandTime());

        return demandEntity;
    }

    private List<RoleEntity> getRoles(List<RoleDto> roles, MemberEntity memberEntity) {
        List<RoleEntity> roleEntities=new ArrayList<>();
        for (RoleDto roleDto:roles){
            RoleEntity roleEntity = getRoleEntity(roleDto,memberEntity);
            roleEntities.add(roleEntity);
        }
        return roleEntities;
    }

    private RoleEntity getRoleEntity(RoleDto roleDto, MemberEntity memberEntity) {
        RoleEntity roleEntity=new RoleEntity();
        roleEntity.setMember(memberEntity);
        roleEntity.setTitle(roleDto.getTitle());

        return roleEntity;
    }
}