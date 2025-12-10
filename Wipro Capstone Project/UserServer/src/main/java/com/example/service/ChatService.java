package com.example.service;

import com.example.dto.ChatMessageRequest;
import com.example.model.ChatMessage;
import com.example.repository.ChatMessageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChatService {
    
    private final ChatMessageRepository chatRepo;
    
    public ChatService(ChatMessageRepository chatRepo) {
        this.chatRepo = chatRepo;
    }
    
    @Transactional
    public ChatMessage sendMessage(ChatMessageRequest req) {
        ChatMessage message = ChatMessage.builder()
                .senderId(req.getSenderId())
                .receiverId(req.getReceiverId())
                .message(req.getMessage())
                .sentAt(LocalDateTime.now())
                .isRead(false)
                .build();
        
        return chatRepo.save(message);
    }
    
    public List<ChatMessage> getConversation(Long userId1, Long userId2) {
        return chatRepo.findConversationBetween(userId1, userId2);
    }
    
    public List<ChatMessage> getUnreadMessages(Long userId) {
        return chatRepo.findByReceiverIdAndIsReadFalse(userId);
    }
    
    public Long getUnreadCount(Long userId) {
        return chatRepo.countByReceiverIdAndIsReadFalse(userId);
    }
    
    @Transactional
    public String markAsRead(Long messageId) {
        return chatRepo.findById(messageId)
                .map(msg -> {
                    msg.setRead(true);
                    chatRepo.save(msg);
                    return "MESSAGE_READ";
                })
                .orElse("MESSAGE_NOT_FOUND");
    }
}
