package com.example.eisenhower_matrix_backend.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.eisenhower_matrix_backend.dto.TaskRequest;
import com.example.eisenhower_matrix_backend.entity.Task;
import com.example.eisenhower_matrix_backend.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:5173")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getList() {
        return ResponseEntity.ok(taskService.getList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(taskService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody TaskRequest request) {
        return ResponseEntity.ok(taskService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(
        @PathVariable("id") UUID id,
        @RequestBody TaskRequest request
    ) {
        return ResponseEntity.ok(taskService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {
        taskService.delete(id);
        return ResponseEntity.ok(null);
    }
}