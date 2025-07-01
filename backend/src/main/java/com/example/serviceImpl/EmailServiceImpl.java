package com.example.serviceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.service.EmailService;

@Service
@Primary
public class EmailServiceImpl implements EmailService {
    public static final Logger logger = LogManager.getLogger(EmailServiceImpl.class);
    
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    @Async
    public void sendEmail(String to, String subject, String body) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("molakathallavinaykumarreddy@gmail.com");
            message.setTo(to);
            message.setSubject(subject);
            message.setText(body);

            javaMailSender.send(message);
            logger.info("Email sent successfully to: {}", to);
        } catch (Exception e) {
            logger.error("Failed to send email to: {}. Error: {}", to, e.getMessage());
            throw new RuntimeException("Failed to send email", e);
        }
    }
}
