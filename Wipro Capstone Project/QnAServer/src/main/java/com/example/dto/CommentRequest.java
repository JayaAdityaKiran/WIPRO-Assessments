package com.example.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequest {
    private Long userId;
    private String body;
    private Long questionId;
    private Long answerId;
    private Long parentCommentId;
}
