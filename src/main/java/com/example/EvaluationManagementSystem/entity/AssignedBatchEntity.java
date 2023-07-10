package com.example.EvaluationManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="assigned_batch")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssignedBatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long assignedBatchId;
    private String batchId;
    private String userId;

}
