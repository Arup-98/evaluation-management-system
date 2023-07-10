package com.example.EvaluationManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="create_batch")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateBatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long batchId;
    private String batchName;


}
