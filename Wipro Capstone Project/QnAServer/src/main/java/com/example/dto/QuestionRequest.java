package com.example.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionRequest {
    private Long userId;
    private String title;
    private String body;
    private String tags;
}
