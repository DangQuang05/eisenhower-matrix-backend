package com.example.eisenhower_matrix_backend.dto;

import java.util.UUID;

public record TaskDTO(UUID id, String title, Integer quadrant) {}