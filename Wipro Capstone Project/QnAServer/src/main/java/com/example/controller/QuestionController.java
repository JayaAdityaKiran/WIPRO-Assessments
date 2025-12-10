package com.example.controller;

import com.example.dto.QuestionRequest;
import com.example.model.Question;
import com.example.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/qna/questions")
@CrossOrigin(origins = "*")
public class QuestionController {
    
    private final QuestionService questionService;
    
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
    
    @PostMapping
    public ResponseEntity<Question> createQuestion(@RequestBody QuestionRequest req) {
        return ResponseEntity.ok(questionService.createQuestion(req));
    }
    
    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions(
            @RequestParam(defaultValue = "true") boolean approvedOnly) {
        if (approvedOnly) {
            return ResponseEntity.ok(questionService.getAllApprovedQuestions());
        }
        return ResponseEntity.ok(questionService.getAllQuestions());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        return ResponseEntity.ok(questionService.getQuestionById(id));
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<Question>> searchQuestions(@RequestParam String q) {
        return ResponseEntity.ok(questionService.searchQuestions(q));
    }
    
    @GetMapping("/tag/{tag}")
    public ResponseEntity<List<Question>> getQuestionsByTag(@PathVariable String tag) {
        return ResponseEntity.ok(questionService.getQuestionsByTag(tag));
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Question>> getQuestionsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(questionService.getQuestionsByUser(userId));
    }
    
    @GetMapping("/pending")
    public ResponseEntity<List<Question>> getPendingQuestions() {
        return ResponseEntity.ok(questionService.getPendingQuestions());
    }
    
    @PutMapping("/{id}/approve")
    public ResponseEntity<String> approveQuestion(@PathVariable Long id) {
        return ResponseEntity.ok(questionService.approveQuestion(id));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Long id) {
        return ResponseEntity.ok(questionService.deleteQuestion(id));
    }
    
    @PutMapping("/{id}/close")
    public ResponseEntity<String> closeThread(@PathVariable Long id) {
        return ResponseEntity.ok(questionService.closeThread(id));
    }
    
    @PutMapping("/{id}/resolve")
    public ResponseEntity<String> markResolved(@PathVariable Long id) {
        return ResponseEntity.ok(questionService.markResolved(id));
    }
}
