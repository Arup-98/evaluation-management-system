package com.example.EvaluationManagementSystem.service;

import com.example.EvaluationManagementSystem.repository.TraineeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterService {
    private final TraineeRepository traineeRepository;
}
