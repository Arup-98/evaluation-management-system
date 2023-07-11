package com.example.EvaluationManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="manager_evaluation")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ManagersEvaluationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long traineeId;
    private Long batchId;
    private Long commonScore;
    private Long officeRules;
    private Long sincerity;
    private Long qualityMindset;
    private Long attendance;
    private Long communicationSkill;
    private Long englishLanguageSkill;

}