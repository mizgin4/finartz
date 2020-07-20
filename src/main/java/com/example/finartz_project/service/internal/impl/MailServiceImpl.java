package com.example.finartz_project.service.internal.impl;

import com.example.finartz_project.controller.request.CreateDemandRequest;
import com.example.finartz_project.controller.request.CreateMemberRequest;
import com.example.finartz_project.model.entity.MemberEntity;
import com.example.finartz_project.model.entity.RoleEntity;
import com.example.finartz_project.repository.MemberRepository;
import com.example.finartz_project.repository.RoleRepository;
import com.example.finartz_project.service.internal.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Hashtable;
import java.util.List;
import java.util.Optional;

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
    public void sendDemandNotification(CreateDemandRequest request) throws MailException {

        Hashtable<String, String> my_dict = new Hashtable<String, String>();
        my_dict.put("USER","ADMIN");


        Optional<RoleEntity> roleEntity=roleRepository.findById(request.getMemberId());
        MemberEntity memberEntity= memberRepository.findByRoles(roleEntity.get().getTitle());

        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setTo(memberEntity.getEmail());
        mailMessage.setSubject("New Demand Requested");
        mailMessage.setText("This happend");
        javaMailSender.send(mailMessage);
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
}