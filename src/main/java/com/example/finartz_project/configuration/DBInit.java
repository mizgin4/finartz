//package com.example.finartz_project.configuration;
//
//import com.example.finartz_project.model.entity.MemberEntity;
//import com.example.finartz_project.model.entity.RoleEntity;
//import com.example.finartz_project.repository.MemberRepository;
//import com.example.finartz_project.repository.RoleRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import javax.management.relation.Role;
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class DBInit {
//
//    @Autowired
//    private MemberRepository memberRepository;
//    @Autowired
//    private RoleRepository roleRepository;
//
//    @PostConstruct
//    private void postConstruct() {
//        MemberEntity memberEntity = new MemberEntity();
//        memberEntity.setName("finartz");
//        memberEntity.setLastName("finartz");
//        memberEntity.setPassword("password");
//        memberEntity.setEmail("finartz@gmail.com");
//        memberRepository.save(memberEntity);
//
//        //Long id=new Long(1);
//        RoleEntity roleEntity=new RoleEntity();
//        roleEntity.setMember(memberEntity);
//        roleEntity.setTitle("ADMIN");
//        roleRepository.save(roleEntity);
////        MemberEntity memberEntity1=memberRepository.findByName("finartz");
////
////        memberEntity1.setRoles();
////        memberRepository.save(memberEntity1);
//    }
//}
