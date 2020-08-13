package com.example.finartz_project.service.internal.impl;


import com.example.finartz_project.controller.request.CreateMemberRequest;
import com.example.finartz_project.model.dto.DemandDto;

import com.example.finartz_project.model.dto.MemberDto;
import com.example.finartz_project.model.entity.MemberEntity;
import com.example.finartz_project.model.entity.RoleEntity;
import com.example.finartz_project.model.enumeration.Roles;
import com.example.finartz_project.repository.MemberRepository;
import com.example.finartz_project.repository.RoleRepository;
import com.example.finartz_project.service.internal.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;


@Component
public class MailServiceImpl implements MailService {

    private JavaMailSender javaMailSender;
    private final MemberRepository memberRepository;
    private final RoleRepository roleRepository;


    @Autowired
    public MailServiceImpl(JavaMailSender javaMailSender, MemberRepository memberRepository, RoleRepository roleRepository) {
        this.javaMailSender = javaMailSender;
        this.memberRepository = memberRepository;
        this.roleRepository = roleRepository;

    }

    public void sendNotification(CreateMemberRequest request) throws MailException {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(request.getEmail());
        mailMessage.setSubject("HR@noreply");
        mailMessage.setText("Your password has been created:    " + generatePassword());
        javaMailSender.send(mailMessage);

    }

    @Override
    public void sendDemandNotification(DemandDto demandDto) throws MailException {



        RoleEntity roleEntity = roleRepository.findByMemberMemberId(demandDto.getMemberId());//Burda elimde request gonderenin rolu var
        switch (roleEntity.getTitle()) {
            case INTERN:
                RoleEntity roleEntity1 = roleRepository.findByTitle(Roles.TEAMLEAD);
                MemberEntity memberEntity = memberRepository.findByMemberId(roleEntity1.getMember().getMemberId());


                SimpleMailMessage mailMessage = new SimpleMailMessage();
                mailMessage.setTo(memberEntity.getEmail());
                mailMessage.setSubject("New Demand Requested");
                mailMessage.setText("Name:"+ memberEntity.getName()+memberEntity.getLastName());
                javaMailSender.send(mailMessage);

        }

    }




    public String generatePassword() {

        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder newPassword = new StringBuilder();

        int passwordLength = 10;
        for (int i = 0; i < passwordLength; i++) {
            int randomIndex = random.nextInt(chars.length());
            newPassword.append(chars.charAt(randomIndex));
        }

        String newPasswordd = newPassword.toString();

        return newPasswordd;
    }

    @Override
    public void sendBirthDayNotification(MemberDto memberDto) throws MailException {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(memberDto.getEmail());
        mailMessage.setSubject("HR@noreply");
        mailMessage.setText("We wish Happy BirtDay to"+ memberDto.getName());
        javaMailSender.send(mailMessage);

    }
}