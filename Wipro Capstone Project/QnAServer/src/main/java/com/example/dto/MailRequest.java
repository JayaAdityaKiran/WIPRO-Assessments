package com.example.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailRequest {
    private String to;
    private String subject;
    private String bodyHtml;
}
