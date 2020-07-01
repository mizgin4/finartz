package com.example.finartz_project.repository;

import com.example.finartz_project.model.entity.DemandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandRepository extends JpaRepository<DemandEntity,Long> {
    List<DemandEntity> findByMember(String member);

}
