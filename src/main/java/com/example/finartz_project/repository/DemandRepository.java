package com.example.finartz_project.repository;

import com.example.finartz_project.model.entity.DemandEntity;
import com.example.finartz_project.model.entity.MemberEntity;
import com.example.finartz_project.model.enumeration.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface DemandRepository extends JpaRepository<DemandEntity,Long> {
    List<DemandEntity> findByMember(Optional<MemberEntity> member);
    List<DemandEntity> findByStatus(Status status);







}
