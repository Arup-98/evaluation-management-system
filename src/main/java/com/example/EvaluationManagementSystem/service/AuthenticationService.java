package com.example.EvaluationManagementSystem.service;

import com.example.EvaluationManagementSystem.model.AdminRequestModel;
import com.example.EvaluationManagementSystem.model.TraineeRequestModel;
import com.example.EvaluationManagementSystem.model.TrainerRequestModel;
import com.example.EvaluationManagementSystem.repository.AdminRepository;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
    ResponseEntity<Object> createAdmin(AdminRequestModel adminRequestModel);
    ResponseEntity<Object> createTrainee(TraineeRequestModel traineeRequestModel);
    ResponseEntity<Object>createTrainer(TrainerRequestModel trainerRequestModel);

}
