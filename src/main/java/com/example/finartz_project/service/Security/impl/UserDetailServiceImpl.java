package com.example.finartz_project.service.Security.impl;

import com.example.finartz_project.model.entity.MemberEntity;
import com.example.finartz_project.model.entity.RoleEntity;
import com.example.finartz_project.repository.MemberRepository;
import com.example.finartz_project.service.Security.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDetailServiceImpl implements UserDetailService {
    @Autowired
    MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MemberEntity> member = Optional.ofNullable(memberRepository.findByName(username));
        return new User(member.get().getName(), member.get().getPassword(),
                getAuthorities(member));
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(Optional<MemberEntity> member) {
        //Burda casting yapti normalde list donuyordu
        RoleEntity memberRole = (RoleEntity) member.get().getRoles();
        if (memberRole != null) {
            return AuthorityUtils.createAuthorityList("ROLE_" + memberRole.getTitle().name());
        }
        return Collections.emptyList();
    }
}