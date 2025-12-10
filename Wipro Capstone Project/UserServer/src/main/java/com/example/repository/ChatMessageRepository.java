package com.example.repository;

import com.example.model.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    
    @Query("SELECT c FROM ChatMessage c WHERE " +
           "(c.senderId = ?1 AND c.receiverId = ?2) OR " +
           "(c.senderId = ?2 AND c.receiverId = ?1) " +
           "ORDER BY c.sentAt ASC")
    List<ChatMessage> findConversationBetween(Long userId1, Long userId2);
    
    List<ChatMessage> findByReceiverIdAndIsReadFalse(Long receiverId);
    
    Long countByReceiverIdAndIsReadFalse(Long receiverId);
}
