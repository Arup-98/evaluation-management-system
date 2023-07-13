package com.example.EvaluationManagementSystem.repository;

import com.example.EvaluationManagementSystem.entity.SubmitTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmitTaskRepository extends JpaRepository<SubmitTaskEntity,Long> {
    SubmitTaskEntity findByCreateTaskId(Long createTaskId);
}
