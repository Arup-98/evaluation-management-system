package com.example.EvaluationManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="aptitude_and_CEO_interview")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AptitudeAndCEOInterviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
//    private Long traineeId;
//    private Long batchId;
    private Double aptitudeTest;
    private Double hrInterview;
    private Double totalScore;

    @OneToOne
    @JoinColumn(name="trainee_id")
    public TraineeEntity traineeEntity;


}
