package com.example.controller;

import com.example.model.Task;
import com.example.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teamlead")
@CrossOrigin("*")
public class TeamLeadTaskController {

    @Autowired
    private TaskService taskService;

    // CREATE TASK
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Task task, Authentication auth) {
        String tl = auth.getName();
        try {
            return ResponseEntity.ok(taskService.createTask(task, tl));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // GET ALL TASKS OF THIS TEAMLEAD
    @GetMapping("/tasks")
    public List<Task> getMyTasks(Authentication auth) {
        return taskService.getTasksOfTeamLead(auth.getName());
    }

    // UPDATE TASK FULLY (ONLY TL)
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable long id,
                                    @RequestBody Task updated,
                                    Authentication auth) {
        try {
            return ResponseEntity.ok(taskService.updateTask(id, updated, auth.getName()));
        } catch (SecurityException se) {
            return ResponseEntity.status(403).body(se.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // ASSIGN A TASK TO SD
    @PutMapping("/assign/{id}/{sdUsername}")
    public ResponseEntity<?> assign(@PathVariable long id,
                                    @PathVariable String sdUsername,
                                    Authentication auth) {
        try {
            return ResponseEntity.ok(taskService.assignTask(id, sdUsername, auth.getName()));
        } catch (SecurityException se) {
            return ResponseEntity.status(403).body(se.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // DELETE TASK (ONLY TL WHO CREATED IT)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id, Authentication auth) {
        try {
            taskService.deleteTask(id, auth.getName());  // FIXED: correct service method
            return ResponseEntity.ok("Deleted");
        } catch (SecurityException se) {
            return ResponseEntity.status(403).body(se.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
