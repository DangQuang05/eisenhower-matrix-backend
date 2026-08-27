package com.example.eisenhower_matrix_backend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.eisenhower_matrix_backend.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
}