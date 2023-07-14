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
public class CreateDailyTaskRequestModel {

    private String taskName;
    private String date;
    private String taskFile;
    private Long batchId;
}
