package com.example.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "chat_messages")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatMessage {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private Long senderId;
    
    @Column(nullable = false)
    private Long receiverId;
    
    @Column(nullable = false, length = 2000)
    private String message;
    
    @Column(nullable = false)
    private LocalDateTime sentAt = LocalDateTime.now();
    
    private boolean isRead = false;
}
