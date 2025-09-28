package com.harsha.todoapp.controllers;

import com.harsha.todoapp.models.Task;
import com.harsha.todoapp.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping({"", "/"})
    public ResponseEntity<List<Task>> getAllTasks(){
        return ResponseEntity.ok(taskService.getAllTask());
    }

    @GetMapping("/completed")
    public ResponseEntity<List<Task>> getAllCompletedTasks(){
        return ResponseEntity.ok(taskService.findAllCompletedTask());
    }

    @GetMapping("/incompleted")
    public ResponseEntity<List<Task>> GetAllIncompletedTasks(){
        return ResponseEntity.ok(taskService.findAllIncompletedTask());
    }

    @PostMapping({"", "/"})
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        return ResponseEntity.ok(taskService.createNewTask(task));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task){
        task.setId(id);
        return ResponseEntity.ok(taskService.updateTask(task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Task>> getTaskById(@PathVariable Long id){
        return ResponseEntity.ok(taskService.findTaskById(id));
    }

    @GetMapping({"/test", "/test/"})
    public String test() {
        return "Controller is working!";
    }
}
