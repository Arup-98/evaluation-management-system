package com.example.EvaluationManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="task_evaluation")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskEvaluationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String type;
    private Double requirementUnderstanding;
    private Double expectedOutput;
    private Double codeQuality;
    private Double demonstration;
    private Double codeUnderstanding;
    private Double totalMarks;

    @ManyToOne
    @JoinColumn(name = "trainee_id")
    private TraineeEntity trainee;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private CreateDailyTaskEntity createDailyTask;

}
