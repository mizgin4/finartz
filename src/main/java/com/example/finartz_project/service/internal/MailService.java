package com.example.finartz_project.service.internal;

import com.example.finartz_project.controller.request.CreateDemandRequest;
import com.example.finartz_project.controller.request.CreateMemberRequest;
import org.springframework.mail.MailException;

public interface MailService {

    public void sendNotification(CreateMemberRequest request) throws MailException;
    public void sendDemandNotification(CreateDemandRequest request) throws MailException;
    public String generatePassword();
}
