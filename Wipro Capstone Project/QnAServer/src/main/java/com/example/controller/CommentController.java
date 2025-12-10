package com.example.controller;

import com.example.dto.CommentRequest;
import com.example.model.Comment;
import com.example.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/qna/comments")
@CrossOrigin(origins = "*")
public class CommentController {
    
    private final QuestionService questionService;
    
    public CommentController(QuestionService questionService) {
        this.questionService = questionService;
    }
    
    @PostMapping
    public ResponseEntity<Comment> addComment(@RequestBody CommentRequest req) {
        return ResponseEntity.ok(questionService.addComment(req));
    }
    
    @GetMapping("/question/{questionId}")
    public ResponseEntity<List<Comment>> getCommentsByQuestion(
            @PathVariable Long questionId,
            @RequestParam(defaultValue = "false") boolean includeUnapproved) {
        return ResponseEntity.ok(questionService.getCommentsByQuestion(questionId, includeUnapproved));
    }
    
    @GetMapping("/answer/{answerId}")
    public ResponseEntity<List<Comment>> getCommentsByAnswer(
            @PathVariable Long answerId,
            @RequestParam(defaultValue = "false") boolean includeUnapproved) {
        return ResponseEntity.ok(questionService.getCommentsByAnswer(answerId, includeUnapproved));
    }
    
    @GetMapping("/replies/{parentCommentId}")
    public ResponseEntity<List<Comment>> getReplies(@PathVariable Long parentCommentId) {
        return ResponseEntity.ok(questionService.getReplies(parentCommentId));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable Long id) {
        return ResponseEntity.ok(questionService.deleteComment(id));
    }
}
