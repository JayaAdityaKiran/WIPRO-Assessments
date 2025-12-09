package com.example.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.model.User;
import com.example.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    // return list of SD users (TeamLead will use this to populate dropdown)
    @GetMapping("/sd")
    public List<UserDTO> getSdUsers() {
        return userRepo.findAll().stream()
                .filter(u -> "SD".equalsIgnoreCase(u.getRole()))
                .map(u -> new UserDTO(u.getUsername()))
                .collect(Collectors.toList());
    }

    // DTO to keep response small
    static class UserDTO {
        public String username;
        public UserDTO(String username) { this.username = username; }
    }
}
