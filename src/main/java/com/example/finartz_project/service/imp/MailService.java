package com.example.finartz_project.service.imp;


import com.example.finartz_project.controller.request.CreateMemberRequest;
import com.example.finartz_project.model.dto.MemberDto;
import com.example.finartz_project.model.entity.MemberEntity;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.security.SecureRandom;

@Component
public class MailService {

    private JavaMailSender javaMailSender;


    @Autowired
    public MailService(JavaMailSender javaMailSender){
        this.javaMailSender=javaMailSender;
    }
    public void sendNotification(CreateMemberRequest request) throws MailException {

        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setTo(request.getEmail());
        mailMessage.setSubject("HR@noreply");
        mailMessage.setText("Your password has been created:    "+generatePassword());
        javaMailSender.send(mailMessage);

    }
    public static String generatePassword(){
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random=new SecureRandom();
        StringBuilder newPassword =new StringBuilder();
        int passwordLength=10;
        for(int i=0;i<passwordLength;i++){
            int randomIndex = random.nextInt(chars.length());
            newPassword.append(chars.charAt(randomIndex));
        }
        String newPasswordd= newPassword.toString();
        return newPasswordd;

    }

}
