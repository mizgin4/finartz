package com.example.finartz_project.service.converter;

import com.example.finartz_project.model.dto.RoleDto;
import com.example.finartz_project.model.entity.MemberEntity;
import com.example.finartz_project.model.entity.RoleEntity;
import org.springframework.stereotype.Component;

import javax.management.relation.Role;
@Component
public class RoleEntityConverter {

    public RoleEntity convert(RoleDto roleDto, MemberEntity memberEntity){

        RoleEntity roleEntity=new RoleEntity();

        roleEntity.setTitle(roleDto.getTitle());
        roleEntity.setMember(memberEntity);

        return roleEntity;
    }
}
