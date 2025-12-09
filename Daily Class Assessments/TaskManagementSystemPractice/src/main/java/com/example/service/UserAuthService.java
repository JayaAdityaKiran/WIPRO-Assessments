package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.dao.DataIntegrityViolationException;

import com.example.model.User;
import com.example.repository.UserRepository;

@Service
public class UserAuthService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<String> registerUser(User user) {

        if (userRepo.existsByUsername(user.getUsername())) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if (user.getRole() == null || user.getRole().isBlank()) {
            user.setRole("SD");
        }

        try {
            userRepo.save(user);
        } catch (DataIntegrityViolationException ex) {
            return ResponseEntity.badRequest().body("Username already exists (race condition)");
        }

        return ResponseEntity.ok("User registered successfully");
    }

    public Optional<User> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
