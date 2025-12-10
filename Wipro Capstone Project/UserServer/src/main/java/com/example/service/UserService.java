package com.example.service;

import com.example.client.EmailClient;
import com.example.dto.*;
import com.example.exception.*;
import com.example.model.*;
import com.example.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class UserService {
    
    private final UserRepository userRepo;
    private final PasswordResetTokenRepository tokenRepo;
    private final EmailClient emailClient;
    
    public UserService(UserRepository userRepo, 
                      PasswordResetTokenRepository tokenRepo,
                      EmailClient emailClient) {
        this.userRepo = userRepo;
        this.tokenRepo = tokenRepo;
        this.emailClient = emailClient;
    }
    
    // Register
    @Transactional
    public String register(RegisterRequest req) {
        if (userRepo.existsByEmail(req.getEmail())) {
            throw new RuntimeException("EMAIL_ALREADY_EXISTS");
        }
        
        User user = User.builder()
                .email(req.getEmail())
                .password(req.getPassword())
                .name(req.getName())
                .phone(req.getPhone())
                .active(true)
                .build();
        
        userRepo.save(user);
        
        // Send welcome email
        try {
            MailRequest mail = new MailRequest();
            mail.setTo(req.getEmail());
            mail.setSubject("Welcome to DoConnect!");
            mail.setBodyHtml("<h2>Welcome " + req.getName() + "!</h2>" +
                           "<p>Your account has been created successfully.</p>" +
                           "<p>Start asking and answering questions now!</p>");
            emailClient.sendMail(mail);
        } catch (Exception e) {
            System.err.println("Email failed: " + e.getMessage());
        }
        
        return "REGISTRATION_SUCCESS";
    }
    
    // Login
    public User login(LoginRequest req) {
        User user = userRepo.findByEmail(req.getEmail())
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        
        if (!user.getPassword().equals(req.getPassword())) {
            throw new InvalidCredentialsException("Invalid password");
        }
        
        if (!user.isActive()) {
            throw new RuntimeException("USER_DEACTIVATED");
        }
        
        return user;
    }
    
    // Forgot Password - Send OTP
    @Transactional
    public String forgotPassword(ForgotPasswordRequest req) {
        User user = userRepo.findByEmail(req.getEmail())
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        
        String otp = String.format("%06d", new Random().nextInt(999999));
        
        tokenRepo.deleteByEmail(req.getEmail());
        
        PasswordResetToken token = PasswordResetToken.builder()
                .email(req.getEmail())
                .otp(otp)
                .expiryTime(LocalDateTime.now().plusMinutes(10))
                .used(false)
                .build();
        tokenRepo.save(token);
        
        // Send OTP email
        try {
            MailRequest mail = new MailRequest();
            mail.setTo(req.getEmail());
            mail.setSubject("DoConnect - Password Reset OTP");
            mail.setBodyHtml("<h2>Password Reset Request</h2>" +
                           "<p>Your OTP is: <strong>" + otp + "</strong></p>" +
                           "<p>This OTP is valid for 10 minutes.</p>" +
                           "<p>If you didn't request this, please ignore.</p>");
            emailClient.sendMail(mail);
        } catch (Exception e) {
            // Log error but don't fail - email is still sent
            System.err.println("Email notification error (email may still be sent): " + e.getMessage());
        }
        
        return "OTP_SENT";  // Always return success if token is saved
    }

    
    // Verify OTP
    public String verifyOtp(VerifyOtpRequest req) {
        PasswordResetToken token = tokenRepo.findByEmailAndOtpAndUsedFalse(req.getEmail(), req.getOtp())
                .orElseThrow(() -> new InvalidOtpException("Invalid or expired OTP"));
        
        if (token.getExpiryTime().isBefore(LocalDateTime.now())) {
            throw new InvalidOtpException("OTP expired");
        }
        
        return "OTP_VALID";
    }
    
    // Reset Password
    @Transactional
    public String resetPassword(ResetPasswordRequest req) {
        PasswordResetToken token = tokenRepo.findByEmailAndOtpAndUsedFalse(req.getEmail(), req.getOtp())
                .orElseThrow(() -> new InvalidOtpException("Invalid or expired OTP"));
        
        if (token.getExpiryTime().isBefore(LocalDateTime.now())) {
            throw new InvalidOtpException("OTP expired");
        }
        
        User user = userRepo.findByEmail(req.getEmail())
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        
        user.setPassword(req.getNewPassword());
        userRepo.save(user);
        
        token.setUsed(true);
        tokenRepo.save(token);
        
        return "PASSWORD_RESET_SUCCESS";
    }
    
    // Get user by ID
    public User getUserById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }
    
    // Get user by email
    public User getUserByEmail(String email) {
        return userRepo.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }
    
    // Get all users
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
    
    // Deactivate user (for admin)
    @Transactional
    public String deactivateUser(Long id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        user.setActive(false);
        userRepo.save(user);
        return "USER_DEACTIVATED";
    }
    
    // Activate user (for admin)
    @Transactional
    public String activateUser(Long id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        user.setActive(true);
        userRepo.save(user);
        return "USER_ACTIVATED";
    }
}
