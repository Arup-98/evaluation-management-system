package com.example.EvaluationManagementSystem.repository;

import com.example.EvaluationManagementSystem.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
