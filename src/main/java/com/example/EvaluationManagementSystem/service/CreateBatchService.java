package com.example.EvaluationManagementSystem.service;

import com.example.EvaluationManagementSystem.model.CreateBatchRequestModel;
import com.example.EvaluationManagementSystem.model.TraineeRequestModel;
import org.springframework.http.ResponseEntity;

public interface CreateBatchService {
    ResponseEntity<Object> createBatch(CreateBatchRequestModel createBatchRequestModel);
}
