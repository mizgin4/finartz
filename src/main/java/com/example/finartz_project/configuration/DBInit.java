//package com.example.finartz_project.configuration;
//
//import com.example.finartz_project.model.entity.MemberEntity;
//import com.example.finartz_project.model.entity.RoleEntity;
//import com.example.finartz_project.repository.MemberRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class DBInit {
//
//    @Autowired
//    private MemberRepository memberRepository;
//
//    @PostConstruct
//    private void postConstruct() {
//
//        MemberEntity memberEntity = new MemberEntity();
//        memberEntity.setName("finartz");
//        memberEntity.setLastName("finartz");
//        memberEntity.setPassword("password");
//        //memberEntity.setRoles("ADMIN");
//        memberEntity.setEmail("finartz@gmail.com");
//        memberRepository.save(memberEntity);
//    }
//}
