package com.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@FeignClient(name = "UserServer")
public interface UserClient {
    
    @GetMapping("/api/user/all")
    List<Map<String, Object>> getAllUsers();
    
    @GetMapping("/api/user/{id}")
    Map<String, Object> getUserById(@PathVariable Long id);
    
    @PutMapping("/api/user/{id}/deactivate")
    String deactivateUser(@PathVariable Long id);
    
    @PutMapping("/api/user/{id}/activate")
    String activateUser(@PathVariable Long id);
}
