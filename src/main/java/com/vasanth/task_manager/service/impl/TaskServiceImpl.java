package com.vasanth.task_manager.service.impl;

import com.vasanth.task_manager.entity.Task;
import com.vasanth.task_manager.repository.TaskRepository;
import com.vasanth.task_manager.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(String title) {

        if (title == null || title.isBlank()) {
            throw new RuntimeException("Task title cannot be empty");
        }

        Task task = new Task();
        task.setTitle(title);
        task.setStatus("PENDING");

        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task markCompleted(Long id) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setStatus("COMPLETED");

        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {

        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Task not found");
        }

        taskRepository.deleteById(id);
    }
}