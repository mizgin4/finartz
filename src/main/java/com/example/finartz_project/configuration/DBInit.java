package com.example.finartz_project.configuration;

import com.example.finartz_project.model.entity.MemberEntity;
import com.example.finartz_project.model.entity.RoleEntity;
import com.example.finartz_project.repository.MemberRepository;
import com.example.finartz_project.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DBInit {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private RoleRepository roleRepository;

    @PostConstruct
    private void postConstruct() {
        MemberEntity memberEntity = new MemberEntity();
        MemberEntity memberEntity1 = new MemberEntity();

        memberEntity.setName("Mizgin");
        memberEntity.setLastName("Yilmaz");
        memberEntity.setPassword("password");
        memberEntity.setEmail("finartz@gmail.com");

        memberEntity1.setName("Enes");
        memberEntity1.setLastName("Yilmaz");
        memberEntity1.setPassword("password");
        memberEntity1.setEmail("finartzz@gmail.com");

        memberRepository.save(memberEntity);
        memberRepository.save(memberEntity1);

        RoleEntity roleEntity=new RoleEntity();
        RoleEntity roleEntity1=new RoleEntity();

        roleEntity.setMember(memberEntity);
        roleEntity1.setMember(memberEntity1);
        roleEntity.setTitle("USER");
        roleEntity1.setTitle("ADMIN");

        roleRepository.save(roleEntity);
        roleRepository.save(roleEntity1);

    }
}
