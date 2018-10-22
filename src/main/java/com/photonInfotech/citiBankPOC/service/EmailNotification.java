package com.photonInfotech.citiBankPOC.service;

import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.photonInfotech.citiBankPOC.model.Account;

@Service
public class EmailNotification {
    private JavaMailSender javaMailSender;

    public EmailNotification(JavaMailSender javaMailSender) {

        this.javaMailSender = javaMailSender;
    }
    public void createNotification(Account id) throws Exception {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mail = new MimeMessageHelper(message);
        mail.setTo(id.getEmail());
        mail.setFrom("photondemo18@gmail.com");
        mail.setSubject("Account Creation Successful");
        mail.setText("Your account has been successfully created from XYZ payment service.");
        javaMailSender.send(message);
    }

    public void deleteNotification(Account id) throws Exception {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mail = new MimeMessageHelper(message);
        mail.setTo(id.getEmail());
        mail.setFrom("photondemo18@gmail.com");
        mail.setSubject("Account Deletion Successful");
        mail.setText("Your account has been successfully deleted from XYZ payment service.");
        javaMailSender.send(message);
    }

    public void updateNotification(Account id) throws Exception {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mail = new MimeMessageHelper(message);
        mail.setTo(id.getEmail());
        mail.setFrom("photondemo18@gmail.com");
        mail.setSubject("Account Update Successful");
        mail.setText("Your account has been successfully updated from XYZ payment service.");
        javaMailSender.send(message);
    }

}
