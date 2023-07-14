package com.example.EvaluationManagementSystem.controller;


import com.example.EvaluationManagementSystem.model.*;
import com.example.EvaluationManagementSystem.service.AuthenticationService;
import com.example.EvaluationManagementSystem.service.impl.AuthenticationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final AuthenticationServiceImpl service;

    @PostMapping("/createAdmin")
    public ResponseEntity<Object> createAdmin(@RequestBody AdminRequestModel adminModel) {
        return authenticationService.createAdmin(adminModel);

    }


    @PostMapping("/createTrainee")
    public ResponseEntity<Object> createTrainee(@RequestBody TraineeRequestModel traineeRequestModel) {
       return authenticationService.createTrainee(traineeRequestModel);

    }


    @PostMapping("/createTrainer")
    public ResponseEntity<Object> createTrainer(@RequestBody TrainerRequestModel trainerRequestModel) {
      return  authenticationService.createTrainer(trainerRequestModel);

    }
    @PostMapping("/login")
    public ResponseEntity<Object> authenticate(
            @RequestBody LoginRequestModel request
    ){
        return ResponseEntity.ok(service.authenticate(request));

    }

}
