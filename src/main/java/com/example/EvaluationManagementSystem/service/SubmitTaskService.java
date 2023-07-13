package com.example.EvaluationManagementSystem.service;

import com.example.EvaluationManagementSystem.entity.SubmitTaskEntity;
import com.example.EvaluationManagementSystem.model.SubmitTaskRequestModel;
import com.example.EvaluationManagementSystem.model.SubmitTaskResponseModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SubmitTaskService {
    ResponseEntity<Object> submitTask(SubmitTaskRequestModel submitTaskRequestModel);
    ResponseEntity<List<SubmitTaskEntity>> getSubmitTaskByTraineeId(Long traineeId);
    ResponseEntity<List<SubmitTaskEntity>> getSubmitTasksByCreateTaskId(Long createTaskId);

}
