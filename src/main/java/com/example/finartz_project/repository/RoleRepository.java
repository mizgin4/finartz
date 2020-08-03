package com.example.finartz_project.repository;

import com.example.finartz_project.model.dto.MemberDto;
import com.example.finartz_project.model.dto.RoleDto;
import com.example.finartz_project.model.entity.RoleEntity;
import com.example.finartz_project.model.enumeration.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Long> {

    RoleEntity findByMemberMemberId(Long id);
    RoleEntity findByTitle(Roles title);



}
