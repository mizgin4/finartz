package com.example.finartz_project.service.internal;

import com.example.finartz_project.controller.request.CreateDemandRequest;
import com.example.finartz_project.controller.request.CreateMemberRequest;
import com.example.finartz_project.model.dto.DemandDto;
import com.example.finartz_project.model.dto.MemberDto;
import org.springframework.mail.MailException;

public interface MailService {

    public void sendNotification(CreateMemberRequest request) throws MailException;
    public void sendDemandNotification(DemandDto demandDto)throws MailException;
    public String generatePassword();
    public void sendBirthDayNotification(MemberDto memberDto) throws  MailException;
}
