package com.example.build_du_an_ca_nhan_chien_evotek.service.impl;

import com.example.build_du_an_ca_nhan_chien_evotek.config.EmailConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private EmailConfig emailConfig;

    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
        mailSenderImpl.setHost(emailConfig.getHost());
        mailSenderImpl.setPort(emailConfig.getPort());
        mailSenderImpl.setUsername(emailConfig.getUsername());
        mailSenderImpl.setPassword(emailConfig.getPassword());
        return mailSenderImpl;

    }

    public void sendSimpleMessage(String to, String from, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        message.setFrom(from);
        getJavaMailSender().send(message);
    }
}
