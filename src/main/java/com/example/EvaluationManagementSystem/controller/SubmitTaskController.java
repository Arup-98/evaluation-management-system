package com.example.EvaluationManagementSystem.controller;

import com.example.EvaluationManagementSystem.entity.SubmitTaskEntity;
import com.example.EvaluationManagementSystem.model.SubmitTaskRequestModel;
import com.example.EvaluationManagementSystem.service.SubmitTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/submitTask")
@RequiredArgsConstructor
public class SubmitTaskController {
    private final SubmitTaskService submitTaskService;
    @PostMapping("/submit")
    public ResponseEntity<Object> submitTask(@RequestBody SubmitTaskRequestModel submitTaskRequestModel){
        return submitTaskService.submitTask(submitTaskRequestModel);
    }
    @GetMapping("/{createTaskId}")
    public ResponseEntity<List<SubmitTaskEntity>> getSubmitTasksByCreateTaskId(@PathVariable Long createTaskId ) {
        return submitTaskService.getSubmitTasksByCreateTaskId(createTaskId);
    }
}
