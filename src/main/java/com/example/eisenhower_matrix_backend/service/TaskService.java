package com.example.eisenhower_matrix_backend.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.eisenhower_matrix_backend.dto.TaskRequest;
import com.example.eisenhower_matrix_backend.entity.Task;
import com.example.eisenhower_matrix_backend.repository.TaskRepository;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getList(Integer quadrant) {
        if (quadrant == null) {
            return taskRepository.findAll();
        } else {
            return taskRepository.findByQuadrant(quadrant);
        }
    }

    public Task getById(UUID id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task create(TaskRequest request) {
        return taskRepository.save(new Task(
            request.title(),
            request.quadrant())
        );
    }

    public Task update(UUID id, TaskRequest request) {
        Task task = getById(id);
        if (task != null) {
            task.setTitle(request.title());
            task.setQuadrant(request.quadrant());
            return taskRepository.save(task);
        } else {
            return null;
        }
    }

    public void delete(UUID id) {
        taskRepository.deleteById(id);
    }
}