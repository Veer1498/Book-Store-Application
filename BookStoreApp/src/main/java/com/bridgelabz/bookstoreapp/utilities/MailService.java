package com.bridgelabz.bookstoreapp.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
/**
 * Purpose : This Application is to control User and Book Services.
 * Author : Veer
 */
public class MailService {
    @Autowired
    private JavaMailSender mailsender;

    public void sendEmail(String toEmail, String subject, String body ) {
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("singavarapuveerendra@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        mailsender.send(message);
        System.out.println("Mail sent to the User...!");

    }
}
