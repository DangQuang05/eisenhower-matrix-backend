package com.example.eisenhower_matrix_backend.config;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.eisenhower_matrix_backend.entity.Task;
import com.example.eisenhower_matrix_backend.repository.TaskRepository;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner initData(TaskRepository taskRepository) {
        return args -> {
            if (taskRepository.count() == 0) {
                List<Task> tasks = new ArrayList<>();
                tasks.add(new Task("Fixing a critical production outage (P0/P1 bug)", 1, LocalDateTime.of(2026, 1, 1, 0, 0)));
                tasks.add(new Task("Patching a severe zero-day security vulnerability", 1, LocalDateTime.of(2026, 1, 2, 0, 0)));
                tasks.add(new Task("Delivering a feature for a hard release deadline today", 1, LocalDateTime.of(2026, 1, 3, 0, 0)));
                tasks.add(new Task("Refactoring technical debt and legacy code", 2, LocalDateTime.of(2026, 1, 4, 0, 0)));
                tasks.add(new Task("Writing unit/integration tests and documentation", 2, LocalDateTime.of(2026, 1, 5, 0, 0)));
                tasks.add(new Task("Upgrading dependencies, tools, and framework versions", 2, LocalDateTime.of(2026, 1, 6, 0, 0)));
                tasks.add(new Task("Learning a new framework, language, or system design", 2, LocalDateTime.of(2026, 1, 7, 0, 0)));
                tasks.add(new Task("Urgent Slack messages about routine, non-critical queries", 3, LocalDateTime.of(2026, 1, 8, 0, 0)));
                tasks.add(new Task("Attending daily scrums that run over time or lack focus", 3, LocalDateTime.of(2026, 1, 9, 0, 0)));
                tasks.add(new Task("Reviewing low-priority pull requests right before deep work", 3, LocalDateTime.of(2026, 1, 10, 0, 0)));
                tasks.add(new Task("Endless bikeshedding in code reviews over minor style details", 4, LocalDateTime.of(2026, 1, 11, 0, 0)));
                tasks.add(new Task("Customizing IDE themes or shell configs for hours", 4, LocalDateTime.of(2026, 1, 12, 0, 0)));
                tasks.add(new Task("Browsing Tech Twitter, Reddit, or Hacker News during focus hours", 4, LocalDateTime.of(2026, 1, 13, 0, 0)));
                taskRepository.saveAll(tasks);
            }
        };
    }
}
