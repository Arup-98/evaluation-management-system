package com.example.EvaluationManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="final_score")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FinalScoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double dailyMarks;
    private Double miniProject;
    private Double midProject;
    private Double managerEvaluation;
    private Double croHrInterview;
    private Double totalMarks;

    @OneToOne
    @JoinColumn(name="trainee_id")
    public TraineeEntity traineeEntity;
}
