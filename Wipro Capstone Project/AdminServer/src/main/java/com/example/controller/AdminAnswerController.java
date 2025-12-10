package com.example.controller;

import com.example.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/answers")
@CrossOrigin(origins = "*")
public class AdminAnswerController {
    
    private final AdminService adminService;
    
    public AdminAnswerController(AdminService adminService) {
        this.adminService = adminService;
    }
    
    @GetMapping("/question/{questionId}")
    public ResponseEntity<List<Map<String, Object>>> getAnswersByQuestion(@PathVariable Long questionId) {
        return ResponseEntity.ok(adminService.getAnswersByQuestion(questionId));
    }
    
    @PutMapping("/{id}/approve")
    public ResponseEntity<String> approveAnswer(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.approveAnswer(id));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAnswer(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.deleteAnswer(id));
    }
}
