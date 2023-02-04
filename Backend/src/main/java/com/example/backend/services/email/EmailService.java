package com.example.backend.services.email;

public interface EmailService {
    int sendSimpleMail(String emailTo, String password);
}
