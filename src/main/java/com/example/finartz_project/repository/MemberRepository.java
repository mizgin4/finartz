package com.example.finartz_project.repository;

import com.example.finartz_project.model.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity,Long> {


    Optional<MemberEntity> getMembetByEmail(String email);


}
