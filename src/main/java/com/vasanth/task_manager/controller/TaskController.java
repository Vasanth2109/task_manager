package com.vasanth.task_manager.controller;

import com.vasanth.task_manager.entity.Task;
import com.vasanth.task_manager.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin("*")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody Map<String, String> body) {

        return taskService.createTask(
                body.get("title")
        );
    }

    @GetMapping
    public List<Task> getAllTasks() {

        return taskService.getAllTasks();
    }

    @PutMapping("/{id}")
    public Task markCompleted(
            @PathVariable Long id) {

        return taskService.markCompleted(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(
            @PathVariable Long id) {

        taskService.deleteTask(id);
    }
}