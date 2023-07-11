package com.example.EvaluationManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="create_batch")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateBatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String batchName;
    private String startingDate;
    private String endingDate;

    @Builder.Default
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<TraineeEntity> trainees = new HashSet<>();


}
