package com.example.EvaluationManagementSystem.controller;

import com.example.EvaluationManagementSystem.model.AdminRequestModel;
import com.example.EvaluationManagementSystem.model.CreateDailyTaskRequestModel;
import com.example.EvaluationManagementSystem.service.CreateDailyTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/createDailyTask")
@RequiredArgsConstructor
public class CreateDailyTaskController {

    private final CreateDailyTaskService createDailyTaskService;

    @PostMapping("/create")
    public ResponseEntity<Object> createDailyTask (@RequestBody CreateDailyTaskRequestModel createDailyTaskRequestModel) {
        return createDailyTaskService.createDailyTask(createDailyTaskRequestModel);
    }

}
