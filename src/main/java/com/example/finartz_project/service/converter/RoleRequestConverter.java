package com.example.finartz_project.service.converter;

import com.example.finartz_project.controller.request.AddRoleRequest;
import com.example.finartz_project.model.dto.RoleDto;
import org.springframework.stereotype.Component;

import javax.management.relation.Role;
@Component
public class RoleRequestConverter {

    public RoleDto convert(AddRoleRequest request){
        RoleDto roleDto=new RoleDto();
        roleDto.setTitle(request.getTitle());
        return roleDto;
    }
}
