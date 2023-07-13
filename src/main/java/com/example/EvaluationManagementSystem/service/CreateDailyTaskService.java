package com.example.EvaluationManagementSystem.service;

import com.example.EvaluationManagementSystem.model.AdminRequestModel;
import com.example.EvaluationManagementSystem.model.CreateDailyTaskRequestModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CreateDailyTaskService {
    ResponseEntity<Object> createDailyTask(CreateDailyTaskRequestModel createDailyTaskRequestModel);
}
