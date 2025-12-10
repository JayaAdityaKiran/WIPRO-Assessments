package com.example.client;

import com.example.dto.MailRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "EmailServer")
public interface EmailClient {
    
    @PostMapping("/api/mail/send")
    void sendMail(@RequestBody MailRequest req);
}
