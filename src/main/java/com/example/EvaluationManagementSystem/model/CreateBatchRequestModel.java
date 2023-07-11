package com.example.EvaluationManagementSystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateBatchRequestModel {
    private Long id;
    private String batchName;
    private String startingDate;
    private String endingDate;
}
