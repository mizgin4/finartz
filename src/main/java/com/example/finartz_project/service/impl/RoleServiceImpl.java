package com.example.finartz_project.service.impl;

import com.example.finartz_project.controller.request.AddRoleRequest;
import com.example.finartz_project.controller.response.AddRoleResponse;
import com.example.finartz_project.model.dto.RoleDto;
import com.example.finartz_project.model.entity.MemberEntity;
import com.example.finartz_project.model.entity.RoleEntity;
import com.example.finartz_project.repository.MemberRepository;
import com.example.finartz_project.repository.RoleRepository;
import com.example.finartz_project.service.RoleService;

import com.example.finartz_project.service.converter.RoleEntityConverter;
import com.example.finartz_project.service.converter.RoleRequestConverter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRequestConverter roleRequestConverter;

    private final MemberRepository memberRepository;
    private final RoleEntityConverter roleEntityConverter;
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRequestConverter roleRequestConverter, MemberRepository memberRepository, RoleEntityConverter roleEntityConverter, RoleRepository roleRepository) {
        this.roleRequestConverter = roleRequestConverter;

        this.memberRepository = memberRepository;
        this.roleEntityConverter = roleEntityConverter;
        this.roleRepository = roleRepository;
    }

    @Override
    public AddRoleResponse addRole(AddRoleRequest request) {
        RoleDto roleDto= roleRequestConverter.convert(request);
        Optional<MemberEntity> optionalMemberEntity=memberRepository.findById(request.getMemberId());
        if(!optionalMemberEntity.isPresent()){
            throw new NullPointerException("Member is not found");
        }
        MemberEntity memberEntity=new MemberEntity();
        RoleEntity roleEntity=roleEntityConverter.convert(roleDto,memberEntity);
        roleRepository.save(roleEntity);

        return getRoleResponse(roleDto);
    }

    private AddRoleResponse getRoleResponse(RoleDto roleDto) {
        AddRoleResponse response=new AddRoleResponse();
        response.setTitle(roleDto.getTitle());
        return response;


    }
}
