package com.example.EvaluationManagementSystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubmitTaskResponseModel {
    private Long id;
    private Long traineeId;
    private Long taskId;
    private Date date;
    private String fileUpload;

}
