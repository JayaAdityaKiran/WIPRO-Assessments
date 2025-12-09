package com.example.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.model.User;
import com.example.service.UserAuthService;
import com.example.security.JwtUtil;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserAuthService userAuthService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        return userAuthService.registerUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginReq) {

        Optional<User> optional = userAuthService.findByUsername(loginReq.getUsername());

        if (optional.isPresent()) {
            User user = optional.get();

            if (passwordEncoder.matches(loginReq.getPassword(), user.getPassword())) {

                String token = jwtUtil.generateToken(user.getUsername(), user.getRole());

                Map<String, String> res = new HashMap<>();
                res.put("token", token);
                res.put("username", user.getUsername());
                res.put("role", user.getRole());

                return ResponseEntity.ok(res);
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Invalid username or password");
    }
}
