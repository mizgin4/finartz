package com.example.finartz_project.repository;

import com.example.finartz_project.model.entity.MemberEntity;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.lang.reflect.Member;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity,Long> {

    Optional<MemberEntity> getMemberByEmail(String email);
    MemberEntity findByName(String name);
    MemberEntity getMemberEntityByEmail(String email);
    MemberEntity findByMemberId(Long id);
    MemberEntity findByRoles(String role);





}
