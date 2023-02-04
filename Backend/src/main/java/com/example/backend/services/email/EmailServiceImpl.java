package com.example.backend.services.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;


    @Value("${spring.mail.username}") private String sender;

    public int sendSimpleMail(String emailTo, String password)
    {

        // Try block to check for exceptions
        try {
            // Creating a simple mail message
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(emailTo);
            mailMessage.setText("Mật khẩu cho tài khon đăng kí mail này đã được đặt lại thành " + password + ". Bạn có thể dùng để đăng nhập lại vào hệ thống !");
            mailMessage.setSubject("Mail Tìm mật khẩu");

            // Sending the mail
            javaMailSender.send(mailMessage);
            return 200;
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            return 500;
        }
    }
}