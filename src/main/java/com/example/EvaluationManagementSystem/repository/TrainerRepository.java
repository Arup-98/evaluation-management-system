package com.example.EvaluationManagementSystem.repository;

import com.example.EvaluationManagementSystem.entity.TrainerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<TrainerEntity,Long> {
    TrainerEntity findByEmail (String email);
}
