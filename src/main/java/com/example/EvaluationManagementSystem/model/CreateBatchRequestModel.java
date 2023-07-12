package com.example.EvaluationManagementSystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateBatchRequestModel {
    private Long id;
    private String batchName;
    private String startingDate;
    private String endingDate;
    private int totalTrainee;
    private List<Long> traineeIds;
}
