package com.example.controller;

import com.example.dto.MailRequest;
import com.example.service.MailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mail")
@CrossOrigin(origins = "*")
public class EmailController {
    
    private final MailService mailService;
    
    public EmailController(MailService mailService) {
        this.mailService = mailService;
    }
    
    @PostMapping("/send")
    public ResponseEntity<String> sendMail(@RequestBody MailRequest req) {
        mailService.sendHtmlMail(req.getTo(), req.getSubject(), req.getBodyHtml());
        return ResponseEntity.ok("MAIL_SENT");
    }
    
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("EMAIL_SERVER_RUNNING");
    }
}
