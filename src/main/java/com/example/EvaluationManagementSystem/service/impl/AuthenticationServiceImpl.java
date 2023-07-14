package com.example.EvaluationManagementSystem.service.impl;

import com.example.EvaluationManagementSystem.entity.AdminEntity;
import com.example.EvaluationManagementSystem.entity.TraineeEntity;
import com.example.EvaluationManagementSystem.entity.TrainerEntity;
import com.example.EvaluationManagementSystem.entity.UserEntity;
import com.example.EvaluationManagementSystem.model.*;
import com.example.EvaluationManagementSystem.repository.AdminRepository;
import com.example.EvaluationManagementSystem.repository.TraineeRepository;
import com.example.EvaluationManagementSystem.repository.TrainerRepository;
import com.example.EvaluationManagementSystem.repository.UserRepository;
import com.example.EvaluationManagementSystem.service.AuthenticationService;
import com.example.EvaluationManagementSystem.service.JwtService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private final AdminRepository adminRepository;
    private final TrainerRepository trainerRepository;
    private final UserRepository userRepository;
    private final TraineeRepository traineeRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository repository;

    @Override
    public ResponseEntity<Object> createAdmin(AdminRequestModel adminRequestModel) {

        // Create a new UserEntity
        UserEntity user= UserEntity.builder()
                .id(adminRequestModel.getId()) // Set the ID explicitly
                .email(adminRequestModel.getEmail())
                .password(passwordEncoder.encode(adminRequestModel.getPassword()))
                .role("Admin")
                .build();

        // Save the UserEntity to generate the ID
        user = userRepository.save(user);

        // Create a new AdminEntity
        AdminEntity admin = AdminEntity.builder()
                .fullName(adminRequestModel.getFullName())
                .gender(adminRequestModel.getGender())
                .email(adminRequestModel.getEmail())
                .password(passwordEncoder.encode(adminRequestModel.getPassword()))
                .contactNumber(adminRequestModel.getContactNumber())
                .user(user) // Set the UserEntity as the associated user
                .build();

        // Save the AdminEntity
         AdminEntity savedadmin= adminRepository.save(admin);
        var jwtToken = jwtService.generateToken(user);
//
//         AdminResponseModel adminResponseModel = AdminResponseModel.builder()
//                 .id(savedadmin.getId())
//                 .fullName(savedadmin.getFullName())
//                 .email(savedadmin.getEmail())
//                 .password(savedadmin.getPassword())
//                 .contactNumber(savedadmin.getContactNumber())
//                 .token(jwtToken)
//                 .build();


         return new ResponseEntity<>(savedadmin , HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<Object> createTrainee(TraineeRequestModel traineeRequestModel) {


        // Create a new UserEntity
        UserEntity user = UserEntity.builder()
                .id(traineeRequestModel.getId()) // Set the ID explicitly
                .email(traineeRequestModel.getEmail())
                .password(traineeRequestModel.getPassword())
                .role("Trainee")
                .build();

        // Save the UserEntity to generate the ID
        user = userRepository.save(user);

        // Create a new TraineeEntity
        TraineeEntity trainee = TraineeEntity.builder()
                .fullName(traineeRequestModel.getFullName())
                .profilePicture(traineeRequestModel.getProfilePicture())
                .gender(traineeRequestModel.getGender())
                .dateOfBirth(traineeRequestModel.getDateOfBirth())
                .email(traineeRequestModel.getEmail())
                .password(traineeRequestModel.getPassword())
                .contactNumber(traineeRequestModel.getContactNumber())
                .degreeName(traineeRequestModel.getDegreeName())
                .educationalInstitute(traineeRequestModel.getEducationalInstitute())
                .cgpa(traineeRequestModel.getCgpa())
                .passingYear(traineeRequestModel.getPassingYear())
                .presentAddress(traineeRequestModel.getPresentAddress())
                .user(user) // Set the UserEntity as the associated user
                .build();

        // Save the TraineeEntity
        TraineeEntity savedTrainee= traineeRepository.save(trainee);
        var jwtToken = jwtService.generateToken(user);

        return new ResponseEntity<>(savedTrainee , HttpStatus.CREATED);




    }

    @Override
    public ResponseEntity<Object> createTrainer(TrainerRequestModel trainerRequestModel) {


        // Create a new UserEntity
        UserEntity user = UserEntity.builder()
                .id(trainerRequestModel.getId()) // Set the ID explicitly
                .email(trainerRequestModel.getEmail())
                .password(trainerRequestModel.getPassword())
                .role("Trainer")
                .build();

        // Save the UserEntity to generate the ID
        user = userRepository.save(user);

        // Create a new TrainerEntity
        TrainerEntity trainer = TrainerEntity.builder()
                .fullName(trainerRequestModel.getFullName())
                .profilePicture(trainerRequestModel.getProfilePicture())
                .email(trainerRequestModel.getEmail())
                .password(trainerRequestModel.getPassword())
                .designation(trainerRequestModel.getDesignation())
                .joiningDate(trainerRequestModel.getJoiningDate())
                .yearsOfExperience(trainerRequestModel.getYearsOfExperience())
                .expertises(trainerRequestModel.getExpertises())
                .contactNumber(trainerRequestModel.getContactNumber())
                .presentAddress(trainerRequestModel.getPresentAddress())
                .user(user) // Set the UserEntity as the associated user
                .build();

        // Save the TrainerEntity
        TrainerEntity savedTrainer= trainerRepository.save(trainer);
        var jwtToken = jwtService.generateToken(user);

        return new ResponseEntity<>(savedTrainer , HttpStatus.CREATED);

    }
    public AuthenticationResponseModel authenticate(LoginRequestModel request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        Optional<UserEntity> userEntity = repository.findByEmail(request.getEmail());
        if(userEntity.isPresent()){
            UserEntity user = userEntity.get();
            var jwtToken = jwtService.generateToken(user);
            return AuthenticationResponseModel.builder()
                    .token(jwtToken)
                    .build();
        }
        else{
            throw new RuntimeException("user not found");
        }

    }
}
