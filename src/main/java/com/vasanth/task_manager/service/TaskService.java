package com.vasanth.task_manager.service;

import com.vasanth.task_manager.entity.Task;
import java.util.List;

public interface TaskService {

    Task createTask(String title);

    List<Task> getAllTasks();

    Task markCompleted(Long id);

    void deleteTask(Long id);
}