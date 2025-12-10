package com.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@FeignClient(name = "QnaServer")
public interface QnaClient {
    
    // Questions
    @GetMapping("/api/qna/questions")
    List<Map<String, Object>> getAllQuestions();
    
    @GetMapping("/api/qna/questions/{id}")
    Map<String, Object> getQuestionById(@PathVariable Long id);
    
    @PutMapping("/api/qna/questions/{id}/approve")
    String approveQuestion(@PathVariable Long id);
    
    @DeleteMapping("/api/qna/questions/{id}")
    String deleteQuestion(@PathVariable Long id);
    
    @PutMapping("/api/qna/questions/{id}/close")
    String closeThread(@PathVariable Long id);
    
    @PutMapping("/api/qna/questions/{id}/resolve")
    String markResolved(@PathVariable Long id);
    
    // Answers
    @GetMapping("/api/qna/questions/{questionId}/answers")
    List<Map<String, Object>> getAnswersByQuestion(@PathVariable Long questionId, @RequestParam(defaultValue = "true") boolean includeUnapproved);
    
    @PutMapping("/api/qna/answers/{id}/approve")
    String approveAnswer(@PathVariable Long id);
    
    @DeleteMapping("/api/qna/answers/{id}")
    String deleteAnswer(@PathVariable Long id);
}
