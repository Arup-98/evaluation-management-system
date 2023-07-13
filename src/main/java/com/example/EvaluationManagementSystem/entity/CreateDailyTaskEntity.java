package com.example.EvaluationManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="daily_task")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateDailyTaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String taskName;
    private String date;
    private String taskFile;
    private Long batchId;

    @ManyToOne
    @JoinColumn(name="trainer_id")
    private TrainerEntity trainerEntity;

    @OneToMany(cascade = CascadeType.ALL)
    public List<SubmitTaskEntity> submitTaskEntities;
}
