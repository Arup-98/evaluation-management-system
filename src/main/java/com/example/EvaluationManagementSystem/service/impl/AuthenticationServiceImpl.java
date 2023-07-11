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
       //  Check if the admin ID is null
//        if (adminRequestModel.getId() != null) {
//            UserEntity userEntityById = userRepository.findById(adminRequestModel.getId()).orElse(null);
//            if (userEntityById != null) {
//                System.out.println("Admin already exists with the given ID");
//                return; // Exit the method if the admin already exists
//            }
//        }
//
//        UserEntity userEntityByEmail = userRepository.findByEmail(adminRequestModel.getEmail());
//        if (userEntityByEmail != null) {
//            System.out.println("Admin already exists with the given email");
//            return ; // Exit the method if the admin already exists
//        }

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

         AdminResponseModel adminResponseModel = AdminResponseModel.builder()
                 .id(savedadmin.getId())
                 .fullName(savedadmin.getFullName())
                 .email(savedadmin.getEmail())
                 .password(savedadmin.getPassword())
                 .contactNumber(savedadmin.getContactNumber())
                 .token(jwtToken)
                 .build();


         return new ResponseEntity<>(adminResponseModel, HttpStatus.CREATED);

    }

    @Override
    public void createTrainee(TraineeRequestModel traineeRequestModel) {
        // Check if the trainee ID is null
        if (traineeRequestModel.getId() != null) {
            TraineeEntity traineeEntityById = traineeRepository.findById(traineeRequestModel.getId()).orElse(null);
            if (traineeEntityById != null) {
                System.out.println("Trainee already exists with the given ID");
                return; // Exit the method if the trainee already exists
            }
        }

        TraineeEntity traineeEntityByEmail = traineeRepository.findByEmail(traineeRequestModel.getEmail());
        if (traineeEntityByEmail != null) {
            System.out.println("Trainee already exists with the given email");
            return; // Exit the method if the trainee already exists
        }

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
        traineeRepository.save(trainee);




    }

    @Override
    public void createTrainer(TrainerRequestModel trainerRequestModel) {
        // Check if the trainer ID is null
        if (trainerRequestModel.getId() != null) {
            TrainerEntity trainerEntityById = trainerRepository.findById(trainerRequestModel.getId()).orElse(null);
            if (trainerEntityById != null) {
                System.out.println("Trainer already exists with the given ID");
                return; // Exit the method if the trainer already exists
            }
        }

        TrainerEntity trainerEntityByEmail = trainerRepository.findByEmail(trainerRequestModel.getEmail());
        if (trainerEntityByEmail != null) {
            System.out.println("Trainer already exists with the given email");
            return; // Exit the method if the trainer already exists
        }

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
        trainerRepository.save(trainer);

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
