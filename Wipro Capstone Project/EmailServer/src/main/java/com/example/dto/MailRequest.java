package com.example.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MailRequest {
    @Email @NotBlank
    private String to;
    @NotBlank
    private String subject;
    @NotBlank
    private String bodyHtml;
}
