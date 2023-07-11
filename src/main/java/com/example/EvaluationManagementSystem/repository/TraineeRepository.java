package com.example.EvaluationManagementSystem.repository;

import com.example.EvaluationManagementSystem.entity.TraineeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraineeRepository extends JpaRepository<TraineeEntity, Long> {
    public TraineeEntity findByEmail(String email);
}
