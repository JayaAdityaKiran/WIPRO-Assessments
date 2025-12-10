package com.example.controller;

import com.example.dto.AnswerRequest;
import com.example.model.Answer;
import com.example.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/qna/answers")
@CrossOrigin(origins = "*")
public class AnswerController {
    
    private final QuestionService questionService;
    
    public AnswerController(QuestionService questionService) {
        this.questionService = questionService;
    }
    
    @PostMapping
    public ResponseEntity<Answer> addAnswer(@RequestBody AnswerRequest req) {
        return ResponseEntity.ok(questionService.addAnswer(req));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Answer> getAnswerById(@PathVariable Long id) {
        return ResponseEntity.ok(questionService.getAnswerById(id));
    }
    
    @GetMapping("/question/{questionId}")
    public ResponseEntity<List<Answer>> getAnswersByQuestion(
            @PathVariable Long questionId,
            @RequestParam(defaultValue = "false") boolean includeUnapproved) {
        return ResponseEntity.ok(questionService.getAnswersByQuestion(questionId, includeUnapproved));
    }
    
    @GetMapping("/pending")
    public ResponseEntity<List<Answer>> getPendingAnswers() {
        return ResponseEntity.ok(questionService.getPendingAnswers());
    }
    
    @PutMapping("/{id}/approve")
    public ResponseEntity<String> approveAnswer(@PathVariable Long id) {
        return ResponseEntity.ok(questionService.approveAnswer(id));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAnswer(@PathVariable Long id) {
        return ResponseEntity.ok(questionService.deleteAnswer(id));
    }
    
    @PostMapping("/{id}/like")
    public ResponseEntity<String> toggleLike(
            @PathVariable Long id,
            @RequestParam Long userId) {
        return ResponseEntity.ok(questionService.toggleLike(userId, id));
    }
    
    @GetMapping("/{id}/like-count")
    public ResponseEntity<Long> getLikeCount(@PathVariable Long id) {
        return ResponseEntity.ok(questionService.getLikeCount(id));
    }
    
    @GetMapping("/{id}/has-liked")
    public ResponseEntity<Boolean> hasUserLiked(
            @PathVariable Long id,
            @RequestParam Long userId) {
        return ResponseEntity.ok(questionService.hasUserLiked(userId, id));
    }
}
