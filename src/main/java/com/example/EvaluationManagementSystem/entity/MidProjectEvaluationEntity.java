package com.example.EvaluationManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="mid_Project_evaluation")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MidProjectEvaluationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long midTaskId;
    private Long traineeId;
    private Long taskId;
    private Long requirementUnderstanding;
    private Long expectedOutput;
    private Long codeQuality;
    private Long demonstration;
    private Long codeUnderstanding;
    private Long totalMarks;
}
