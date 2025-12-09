package com.example.controller;

import com.example.model.Task;
import com.example.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sd")
@CrossOrigin("*")
public class SDTaskController {

    @Autowired
    private TaskService taskService;

    // SD GETS ONLY HIS TASKS
    @GetMapping("/tasks")
    public List<Task> getMyTasks(Authentication auth) {
        return taskService.findByAssignedTo(auth.getName());
    }

    // SD UPDATES ONLY STATUS (PATCH-style)
    @PutMapping("/status/{taskId}/{status}")
    public ResponseEntity<?> updateStatus(@PathVariable long taskId,
                                          @PathVariable String status,
                                          Authentication auth) {

        try {
            Task updated = taskService.updateStatus(taskId, status, auth.getName());
            return ResponseEntity.ok(updated);

        } catch (SecurityException se) {
            return ResponseEntity.status(403).body(se.getMessage());

        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
