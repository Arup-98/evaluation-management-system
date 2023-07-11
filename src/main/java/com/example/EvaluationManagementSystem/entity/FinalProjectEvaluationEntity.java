package com.example.EvaluationManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="final_project_evaluation")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FinalProjectEvaluationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long requirementUnderstanding;
    private Long expectedOutput;
    private Long codeQuality;
    private Long demonstration;
    private Long codeUnderstanding;
    private Long totalMarks;
    private Long srs;
    private Long wbs;
    private Long presentation;
    private Long designDocument;
}
