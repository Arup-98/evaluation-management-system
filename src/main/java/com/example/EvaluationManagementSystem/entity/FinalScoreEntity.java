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
    private Long traineeId;
    private Long batchId;
    private Long totalScore;
}
