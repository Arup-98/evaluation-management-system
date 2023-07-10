package com.example.EvaluationManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="quiz")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuizScoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quizId;
    private Long traineeId;
    private Long batchId;
    private Long quizScore;

}
