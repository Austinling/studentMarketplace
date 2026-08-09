package com.austin.student_marketplace.auth.service;


import jakarta.mail.MessagingException;

public interface EmailService {
    public void sendVerificationEmail(String to, String subject, String body) throws MessagingException;
}
