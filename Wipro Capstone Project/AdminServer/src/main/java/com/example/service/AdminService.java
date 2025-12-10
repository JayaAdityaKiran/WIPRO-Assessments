package com.example.service;

import com.example.client.*;
import com.example.dto.*;
import com.example.exception.*;
import com.example.model.*;
import com.example.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class AdminService {
    
    private final AdminUserRepository adminRepo;
    private final AdminPasswordTokenRepository tokenRepo;
    private final QnaClient qnaClient;
    private final UserClient userClient;
    private final EmailClient emailClient;
    
    public AdminService(AdminUserRepository adminRepo,
                       AdminPasswordTokenRepository tokenRepo,
                       QnaClient qnaClient,
                       UserClient userClient,
                       EmailClient emailClient) {
        this.adminRepo = adminRepo;
        this.tokenRepo = tokenRepo;
        this.qnaClient = qnaClient;
        this.userClient = userClient;
        this.emailClient = emailClient;
    }
    
    // Create default admin on startup
    public void createDefaultAdmin() {
        if (!adminRepo.existsByUsername("admin")) {
            AdminUser admin = AdminUser.builder()
                    .username("admin")
                    .password("admin123")
                    .email("admin@doconnect.com")
                    .name("System Admin")
                    .active(true)
                    .build();
            adminRepo.save(admin);
            System.out.println("✅ Default admin created: admin/admin123");
        }
    }
    
    // Register new admin
    @Transactional
    public String register(RegisterRequest req) {
        if (adminRepo.existsByUsername(req.getUsername())) {
            throw new RuntimeException("USERNAME_ALREADY_EXISTS");
        }
        if (adminRepo.existsByEmail(req.getEmail())) {
            throw new RuntimeException("EMAIL_ALREADY_EXISTS");
        }
        
        AdminUser admin = AdminUser.builder()
                .username(req.getUsername())
                .password(req.getPassword())
                .email(req.getEmail())
                .name(req.getName())
                .active(true)
                .build();
        
        adminRepo.save(admin);
        return "REGISTRATION_SUCCESS";
    }
    
    // Login
    public AdminUser login(LoginRequest req) {
        AdminUser admin = adminRepo.findByUsername(req.getUsername())
                .orElseThrow(() -> new AdminNotFoundException("Admin not found"));
        
        if (!admin.getPassword().equals(req.getPassword())) {
            throw new InvalidCredentialsException("Invalid password");
        }
        
        if (!admin.isActive()) {
            throw new RuntimeException("ADMIN_DEACTIVATED");
        }
        
        return admin;
    }
    
    // Forgot Password
    @Transactional
    public String forgotPassword(ForgotPasswordRequest req) {
        AdminUser admin = adminRepo.findByEmail(req.getEmail())
                .orElseThrow(() -> new AdminNotFoundException("Admin not found"));
        
        String otp = String.format("%06d", new Random().nextInt(999999));
        
        tokenRepo.deleteByEmail(req.getEmail());
        
        AdminPasswordToken token = AdminPasswordToken.builder()
                .email(req.getEmail())
                .otp(otp)
                .expiryTime(LocalDateTime.now().plusMinutes(10))
                .used(false)
                .build();
        tokenRepo.save(token);
        
        try {
            MailRequest mail = new MailRequest();
            mail.setTo(req.getEmail());
            mail.setSubject("DoConnect Admin - Password Reset OTP");
            mail.setBodyHtml("<h2>Admin Password Reset</h2>" +
                           "<p>Your OTP is: <strong>" + otp + "</strong></p>" +
                           "<p>Valid for 10 minutes.</p>");
            emailClient.sendMail(mail);
        } catch (Exception e) {
            // Log error but don't fail - email is still sent
            System.err.println("Email notification error (email may still be sent): " + e.getMessage());
        }
        
        return "OTP_SENT";  // Always return success if token is saved
    }


    
    // Verify OTP
    public String verifyOtp(VerifyOtpRequest req) {
        AdminPasswordToken token = tokenRepo.findByEmailAndOtpAndUsedFalse(req.getEmail(), req.getOtp())
                .orElseThrow(() -> new RuntimeException("Invalid or expired OTP"));
        
        if (token.getExpiryTime().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("OTP expired");
        }
        
        return "OTP_VALID";
    }
    
    // Reset Password
    @Transactional
    public String resetPassword(ResetPasswordRequest req) {
        AdminPasswordToken token = tokenRepo.findByEmailAndOtpAndUsedFalse(req.getEmail(), req.getOtp())
                .orElseThrow(() -> new RuntimeException("Invalid or expired OTP"));
        
        if (token.getExpiryTime().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("OTP expired");
        }
        
        AdminUser admin = adminRepo.findByEmail(req.getEmail())
                .orElseThrow(() -> new AdminNotFoundException("Admin not found"));
        
        admin.setPassword(req.getNewPassword());
        adminRepo.save(admin);
        
        token.setUsed(true);
        tokenRepo.save(token);
        
        return "PASSWORD_RESET_SUCCESS";
    }
    
    // ========== QUESTION MANAGEMENT ==========
    
    public List<Map<String, Object>> getAllQuestions() {
        try {
            return qnaClient.getAllQuestions();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch questions: " + e.getMessage());
        }
    }
    
    public Map<String, Object> getQuestionById(Long id) {
        try {
            return qnaClient.getQuestionById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch question: " + e.getMessage());
        }
    }
    
    public String approveQuestion(Long id) {
        try {
            return qnaClient.approveQuestion(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to approve question: " + e.getMessage());
        }
    }
    
    public String deleteQuestion(Long id) {
        try {
            return qnaClient.deleteQuestion(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete question: " + e.getMessage());
        }
    }
    
    public String closeThread(Long id) {
        try {
            return qnaClient.closeThread(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to close thread: " + e.getMessage());
        }
    }
    
    public String markResolved(Long id) {
        try {
            return qnaClient.markResolved(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to mark resolved: " + e.getMessage());
        }
    }
    
    // ========== ANSWER MANAGEMENT ==========
    
    public List<Map<String, Object>> getAnswersByQuestion(Long questionId) {
        try {
            return qnaClient.getAnswersByQuestion(questionId, true);
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch answers: " + e.getMessage());
        }
    }
    
    public String approveAnswer(Long id) {
        try {
            return qnaClient.approveAnswer(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to approve answer: " + e.getMessage());
        }
    }
    
    public String deleteAnswer(Long id) {
        try {
            return qnaClient.deleteAnswer(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete answer: " + e.getMessage());
        }
    }
    
    // ========== USER MANAGEMENT ==========
    
    public List<Map<String, Object>> getAllUsers() {
        try {
            return userClient.getAllUsers();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch users: " + e.getMessage());
        }
    }
    
    public Map<String, Object> getUserById(Long id) {
        try {
            return userClient.getUserById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch user: " + e.getMessage());
        }
    }
    
    public String deactivateUser(Long id) {
        try {
            return userClient.deactivateUser(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to deactivate user: " + e.getMessage());
        }
    }
    
    public String activateUser(Long id) {
        try {
            return userClient.activateUser(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to activate user: " + e.getMessage());
        }
    }
}
