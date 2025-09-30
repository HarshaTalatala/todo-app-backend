package com.harsha.todoapp.controllers;

import com.harsha.todoapp.models.Task;
import com.harsha.todoapp.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "https://gentle-stone-03aeae710.2.azurestaticapps.net")
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // GET all tasks
    @GetMapping(value = {"", "/"})
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTask());
    }

    // GET completed tasks
    @GetMapping("/completed")
    public ResponseEntity<List<Task>> getAllCompletedTasks() {
        return ResponseEntity.ok(taskService.findAllCompletedTask());
    }

    // GET incompleted tasks
    @GetMapping("/incompleted")
    public ResponseEntity<List<Task>> getAllIncompletedTasks() {
        return ResponseEntity.ok(taskService.findAllIncompletedTask());
    }

    // GET task by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Task>> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.findTaskById(id));
    }

    // POST create task (handles trailing slash variations)
    @PostMapping(value = {"", "/"})
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task savedTask = taskService.createNewTask(task);
        return ResponseEntity.ok(savedTask);
    }

    // PUT update task
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        return ResponseEntity.ok(taskService.updateTask(task));
    }

    // DELETE task
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok(true);
    }
}
