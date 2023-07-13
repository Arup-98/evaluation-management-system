package com.example.EvaluationManagementSystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateDailyTaskResponseModel {
    private Long id;
    private String taskName;
    private String date;
    private String task;
    private Long batchId;
}
