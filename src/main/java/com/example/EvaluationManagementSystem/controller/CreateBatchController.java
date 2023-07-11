package com.example.EvaluationManagementSystem.controller;

import com.example.EvaluationManagementSystem.model.CreateBatchRequestModel;
import com.example.EvaluationManagementSystem.service.CreateBatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/createBatch")
@RequiredArgsConstructor
public class CreateBatchController {
    private final CreateBatchService createBatchService;
    @PostMapping("/create")
    public ResponseEntity<Object> booksCreate(@RequestBody CreateBatchRequestModel createBatchRequestModel){
        return createBatchService.createBatch(createBatchRequestModel);
    }

}
