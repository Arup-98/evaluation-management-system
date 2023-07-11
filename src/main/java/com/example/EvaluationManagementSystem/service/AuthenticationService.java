package com.example.EvaluationManagementSystem.service;

import com.example.EvaluationManagementSystem.model.AdminRequestModel;
import com.example.EvaluationManagementSystem.model.TraineeRequestModel;
import com.example.EvaluationManagementSystem.model.TrainerRequestModel;
import com.example.EvaluationManagementSystem.repository.AdminRepository;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
    ResponseEntity<Object> createAdmin(AdminRequestModel adminRequestModel);
    void createTrainee(TraineeRequestModel traineeRequestModel);
    void createTrainer(TrainerRequestModel trainerRequestModel);

}
