package com.example.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    
    private final JavaMailSender mailSender;
    
    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    
    public void sendHtmlMail(String to, String subject, String html) {
        try {
            MimeMessage mime = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mime, "utf-8");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(html, true);
            helper.setFrom("noreply@doconnect.com");
            mailSender.send(mime);
            System.out.println("✅ Email sent to: " + to);
        } catch (Exception e) {
            System.err.println("❌ Email failed: " + e.getMessage());
            throw new RuntimeException("Failed to send mail: " + e.getMessage(), e);
        }
    }
}
