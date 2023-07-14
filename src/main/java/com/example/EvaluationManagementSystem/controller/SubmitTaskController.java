package com.example.EvaluationManagementSystem.controller;

import com.example.EvaluationManagementSystem.model.SubmitTaskRequestModel;
import com.example.EvaluationManagementSystem.model.SubmitTaskResponseModel;
import com.example.EvaluationManagementSystem.repository.SubmitTaskRepository;
import com.example.EvaluationManagementSystem.service.SubmitTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class SubmitTaskController {
    private final SubmitTaskService submitTaskService;
    private final SubmitTaskRepository submitTaskRepository;

    @PostMapping("/submit")
    public ResponseEntity<Object> submitTask( @RequestBody SubmitTaskRequestModel submitTaskRequestModel) {
        return submitTaskService.submitTask(submitTaskRequestModel);
    }

    @GetMapping("/{taskId}/submissions")
    public ResponseEntity<List<SubmitTaskResponseModel>> getSubmissionsByTaskId(@PathVariable Long taskId) {
        return ResponseEntity.ok(submitTaskService.getTaskSubmissionsById(taskId));
    }
    @GetMapping("/{taskId}/submissions/{submissionsId}")
    public ResponseEntity<?> getSubmissionsByIdUnderTask(@PathVariable Long taskId,@PathVariable Long submissionsId) {
        SubmitTaskResponseModel model=submitTaskService.getSubmissionsByIdUnderTask(taskId,submissionsId);
        return ResponseEntity.ok(model);
    }
}

