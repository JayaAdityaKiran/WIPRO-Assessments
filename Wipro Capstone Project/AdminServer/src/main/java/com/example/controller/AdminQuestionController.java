package com.example.controller;

import com.example.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/questions")
@CrossOrigin(origins = "*")
public class AdminQuestionController {
    
    private final AdminService adminService;
    
    public AdminQuestionController(AdminService adminService) {
        this.adminService = adminService;
    }
    
    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAllQuestions() {
        return ResponseEntity.ok(adminService.getAllQuestions());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getQuestionById(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.getQuestionById(id));
    }
    
    @PutMapping("/{id}/approve")
    public ResponseEntity<String> approveQuestion(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.approveQuestion(id));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.deleteQuestion(id));
    }
    
    @PutMapping("/{id}/close")
    public ResponseEntity<String> closeThread(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.closeThread(id));
    }
    
    @PutMapping("/{id}/resolve")
    public ResponseEntity<String> markResolved(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.markResolved(id));
    }
}
