package com.example.EvaluationManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.Date;

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
    private Long batchId;
    private String taskName;
    private Date date;
    private File task;
}
