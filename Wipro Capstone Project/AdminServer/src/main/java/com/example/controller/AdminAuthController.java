package com.example.controller;

import com.example.dto.*;
import com.example.model.AdminUser;
import com.example.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/auth")
@CrossOrigin(origins = "*")
public class AdminAuthController {
    
    private final AdminService adminService;
    
    public AdminAuthController(AdminService adminService) {
        this.adminService = adminService;
    }
    
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest req) {
        return ResponseEntity.ok(adminService.register(req));
    }
    
    @PostMapping("/login")
    public ResponseEntity<AdminUser> login(@RequestBody LoginRequest req) {
        return ResponseEntity.ok(adminService.login(req));
    }
    
    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody ForgotPasswordRequest req) {
        return ResponseEntity.ok(adminService.forgotPassword(req));
    }
    
    @PostMapping("/verify-otp")
    public ResponseEntity<String> verifyOtp(@RequestBody VerifyOtpRequest req) {
        return ResponseEntity.ok(adminService.verifyOtp(req));
    }
    
    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordRequest req) {
        return ResponseEntity.ok(adminService.resetPassword(req));
    }
    
    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        // No JWT/session now; just confirm for client
        return ResponseEntity.ok("Admin logged out successfully");
    }

}
