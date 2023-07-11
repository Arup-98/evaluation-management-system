package com.example.EvaluationManagementSystem.service.impl;

import com.example.EvaluationManagementSystem.entity.CreateBatchEntity;
import com.example.EvaluationManagementSystem.model.CreateBatchRequestModel;
import com.example.EvaluationManagementSystem.model.CreateBatchResponseModel;
import com.example.EvaluationManagementSystem.repository.CreateBatchRepository;
import com.example.EvaluationManagementSystem.service.CreateBatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateBatchServiceImpl implements CreateBatchService {
    @Autowired
    private final CreateBatchRepository createBatchRepository;

    @Override
    public  ResponseEntity<Object>  createBatch(CreateBatchRequestModel createBatchRequestModel) {
        CreateBatchEntity createBatchEntity = CreateBatchEntity.builder()
                .batchName(createBatchRequestModel.getBatchName())
                .startingDate(createBatchRequestModel.getStartingDate())
                .endingDate(createBatchRequestModel.getEndingDate())
                .build();
        CreateBatchEntity savedCreateBatch = createBatchRepository.save(createBatchEntity);
        CreateBatchResponseModel createBatchResponseModel = CreateBatchResponseModel.builder()
                .id(savedCreateBatch.getId())
                .batchName(savedCreateBatch.getBatchName())
                .startingDate(savedCreateBatch.getStartingDate())
                .endingDate(savedCreateBatch.getEndingDate())
                .build();
        return new ResponseEntity<>(createBatchResponseModel, HttpStatus.CREATED);

    }



}
