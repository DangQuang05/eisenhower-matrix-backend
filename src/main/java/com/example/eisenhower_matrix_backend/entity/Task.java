package com.example.eisenhower_matrix_backend.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "quadrant", nullable = false)
    private Integer quadrant;

    @Column(name = "createdAt", nullable = false)
    private LocalDateTime createdAt;

    public Task() {
    }

    public Task(String title, Integer quadrant) {
        this.title = title;
        this.quadrant = quadrant;
        this.createdAt = LocalDateTime.now();
    }

    public Task(String title, Integer quadrant, LocalDateTime createdAt) {
        this.title = title;
        this.quadrant = quadrant;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getQuadrant() {
        return quadrant;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setQuadrant(Integer quadrant) {
        this.quadrant = quadrant;
    }
}