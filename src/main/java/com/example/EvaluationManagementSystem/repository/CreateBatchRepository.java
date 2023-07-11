package com.example.EvaluationManagementSystem.repository;

import com.example.EvaluationManagementSystem.entity.CreateBatchEntity;
import com.example.EvaluationManagementSystem.entity.TraineeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CreateBatchRepository extends JpaRepository<CreateBatchEntity,Long> {
    CreateBatchEntity findByBatchName(String batchName);
    Set<CreateBatchEntity> findByTrainees(TraineeEntity trainee);
}
