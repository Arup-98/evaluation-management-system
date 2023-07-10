package com.example.EvaluationManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="daily_task_evaluation")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DailyTaskEvaluationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dailyTaskId;
    private Long userId;
    private Long taskId;
    private String requirementUnderstanding;
    private String expectedOutput;
    private String codeQuality;
    private String demonstration;
    private String codeUnderstanding;
    private String totalMarks;

}
