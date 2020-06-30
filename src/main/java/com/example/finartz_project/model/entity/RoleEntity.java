package com.example.finartz_project.model.entity;

import javax.management.relation.Role;
import javax.persistence.*;
import java.lang.reflect.Member;
import java.util.Collection;
import java.util.List;
import com.example.finartz_project.model.entity.MemberEntity;
import org.springframework.jmx.export.metadata.ManagedMetric;

@Entity
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roleId;

    private String title;


    //NeedMemberEntity

    @ManyToMany
    List<MemberEntity> memberEntities;

}


