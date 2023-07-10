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

    private Long ceoInterviewId;
    private Long traineeId;
    private Long batchId;
    private Long aptitudeTest;
    private Long hrInterview;
    private Long totalScore;

}
