package com.example.EvaluationManagementSystem.repository;

import com.example.EvaluationManagementSystem.entity.CreateBatchEntity;
import com.example.EvaluationManagementSystem.entity.CreateDailyTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreateDailyTaskRepository extends JpaRepository<CreateDailyTaskEntity,Long> {
//    CreateDailyTaskEntity findByIdString taskName);
          CreateDailyTaskEntity findById(long id);
}
