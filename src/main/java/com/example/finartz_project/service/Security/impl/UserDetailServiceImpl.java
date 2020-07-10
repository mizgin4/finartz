package com.example.finartz_project.service.Security.impl;

import com.example.finartz_project.model.entity.MemberEntity;
import com.example.finartz_project.model.entity.RoleEntity;
import com.example.finartz_project.repository.MemberRepository;
import com.example.finartz_project.service.Security.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailServiceImpl implements UserDetailService {
    @Autowired
    MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        MemberEntity memberEntity=memberRepository.findByName(name);
        if(memberEntity==null) throw new UsernameNotFoundException(name);

        Set<GrantedAuthority> grantedAuthorities=new HashSet<>();
        for(RoleEntity roleEntity:memberEntity.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(roleEntity.getTitle()));
        }
        return new org.springframework.security.core.userdetails.User(memberEntity.getName(),memberEntity.getPassword(),grantedAuthorities);
    }
}
