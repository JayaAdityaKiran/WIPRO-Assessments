package com.example.controller;

import com.example.dto.ChatMessageRequest;
import com.example.model.ChatMessage;
import com.example.service.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/user/chat")
@CrossOrigin(origins = "*")
public class ChatController {
    
    private final ChatService chatService;
    
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }
    
    @PostMapping("/send")
    public ResponseEntity<ChatMessage> sendMessage(@RequestBody ChatMessageRequest req) {
        return ResponseEntity.ok(chatService.sendMessage(req));
    }
    
    @GetMapping("/conversation")
    public ResponseEntity<List<ChatMessage>> getConversation(
            @RequestParam Long userId1,
            @RequestParam Long userId2) {
        return ResponseEntity.ok(chatService.getConversation(userId1, userId2));
    }
    
    @GetMapping("/unread/{userId}")
    public ResponseEntity<List<ChatMessage>> getUnreadMessages(@PathVariable Long userId) {
        return ResponseEntity.ok(chatService.getUnreadMessages(userId));
    }
    
    @GetMapping("/unread-count/{userId}")
    public ResponseEntity<Long> getUnreadCount(@PathVariable Long userId) {
        return ResponseEntity.ok(chatService.getUnreadCount(userId));
    }
    
    @PutMapping("/{messageId}/read")
    public ResponseEntity<String> markAsRead(@PathVariable Long messageId) {
        return ResponseEntity.ok(chatService.markAsRead(messageId));
    }
}
