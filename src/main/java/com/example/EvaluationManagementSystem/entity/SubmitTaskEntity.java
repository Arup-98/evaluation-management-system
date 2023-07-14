package com.example.EvaluationManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.Date;

@Entity
@Table(name="submit_task")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubmitTaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private CreateDailyTaskEntity task;

    private Date date;
    private String fileUpload;
    private Long traineeId;
}
