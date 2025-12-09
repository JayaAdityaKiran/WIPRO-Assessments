package com.example.service;

import com.example.model.Task;
import com.example.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    // CREATE TASK — let DB auto generate ID
    @Transactional
    public Task createTask(Task task, String teamlead) {

        if (task.getTitle() == null || task.getTitle().isBlank()) {
            throw new IllegalArgumentException("Title is required");
        }

        task.setAssignedBy(teamlead);
        task.setStatus("PENDING");

        return repo.save(task);
    }

    // GET TL TASKS
    public List<Task> getTasksOfTeamLead(String teamlead) {
        return repo.findByAssignedBy(teamlead);
    }

    // GET SD TASKS
    public List<Task> findByAssignedTo(String username) {
        return repo.findByAssignedTo(username);
    }

    // SD UPDATE STATUS
    @Transactional
    public Task updateStatus(long taskId, String status, String sdUsername) {

        Task t = repo.findById(taskId)
                .orElseThrow(() -> new NoSuchElementException("Task not found"));

        if (t.getAssignedTo() == null || !t.getAssignedTo().equals(sdUsername)) {
            throw new SecurityException("Not allowed: Task not assigned to this SD");
        }

        t.setStatus(status);
        return repo.save(t);
    }

    // TL FULL UPDATE
    @Transactional
    public Task updateTask(long id, Task updated, String teamlead) {

        Task t = repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Task not found"));

        if (!t.getAssignedBy().equals(teamlead)) {
            throw new SecurityException("Not allowed: Task belongs to another TeamLead");
        }

        if (updated.getTitle() != null) t.setTitle(updated.getTitle());
        if (updated.getDescription() != null) t.setDescription(updated.getDescription());
        if (updated.getAssignedTo() != null) t.setAssignedTo(updated.getAssignedTo());
        if (updated.getStatus() != null) t.setStatus(updated.getStatus());

        return repo.save(t);
    }

    // TL ASSIGN TASK
    @Transactional
    public Task assignTask(long taskId, String sdUsername, String teamlead) {

        Task t = repo.findById(taskId)
                .orElseThrow(() -> new NoSuchElementException("Task not found"));

        if (!t.getAssignedBy().equals(teamlead)) {
            throw new SecurityException("Not allowed: Task belongs to another TeamLead");
        }

        t.setAssignedTo(sdUsername);
        return repo.save(t);
    }

    // TL DELETE TASK
    @Transactional
    public void deleteTask(Long id, String teamlead) {

        Task t = repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Task not found"));

        if (!t.getAssignedBy().equals(teamlead)) {
            throw new SecurityException("Not allowed: Task belongs to another TeamLead");
        }

        repo.deleteById(id);
    }
}
