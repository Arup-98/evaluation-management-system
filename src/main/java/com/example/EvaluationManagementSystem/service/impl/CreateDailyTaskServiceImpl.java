package com.example.EvaluationManagementSystem.service.impl;

import com.example.EvaluationManagementSystem.entity.AdminEntity;
import com.example.EvaluationManagementSystem.entity.CreateDailyTaskEntity;
import com.example.EvaluationManagementSystem.entity.UserEntity;
import com.example.EvaluationManagementSystem.model.AdminResponseModel;
import com.example.EvaluationManagementSystem.model.CreateDailyTaskRequestModel;
import com.example.EvaluationManagementSystem.model.CreateDailyTaskResponseModel;
import com.example.EvaluationManagementSystem.repository.CreateBatchRepository;
import com.example.EvaluationManagementSystem.repository.CreateDailyTaskRepository;
import com.example.EvaluationManagementSystem.repository.TraineeRepository;
import com.example.EvaluationManagementSystem.service.CreateDailyTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateDailyTaskServiceImpl implements CreateDailyTaskService {
    @Autowired
    private final CreateBatchRepository createBatchRepository;
    private final CreateDailyTaskRepository createDailyTaskRepository;


    @Override
    public ResponseEntity<Object> createDailyTask(CreateDailyTaskRequestModel createDailyTaskRequestModel) {
        CreateDailyTaskEntity createTask= CreateDailyTaskEntity.builder()
//                .id(createDailyTaskRequestModel.getId()) // Set the ID explicitly
                .taskName(createDailyTaskRequestModel.getTaskName())
                .date(createDailyTaskRequestModel.getDate())
                .taskFile(createDailyTaskRequestModel.getTaskFile())
                .batchId(createDailyTaskRequestModel.getBatchId())
                .build();

        // Save the UserEntity to generate the ID
        if(createBatchRepository.findById(createDailyTaskRequestModel.getBatchId()).isPresent()) {
            createTask = createDailyTaskRepository.save(createTask);
        }
        else {
            return new ResponseEntity<>(createDailyTaskRequestModel, HttpStatus.NOT_FOUND);
        }

        // Create a new AdminEntity
//        AdminEntity admin = AdminEntity.builder()
//                .fullName(adminRequestModel.getFullName())
//                .gender(adminRequestModel.getGender())
//                .email(adminRequestModel.getEmail())
//                .password(passwordEncoder.encode(adminRequestModel.getPassword()))
//                .contactNumber(adminRequestModel.getContactNumber())
//                .user(user) // Set the UserEntity as the associated user
//                .build();

        // Save the AdminEntity
//        CreateDailyTaskEntity createDailyTask= createDailyTaskRepository.save(admi);
        CreateDailyTaskResponseModel createDailyTaskResponseModel = CreateDailyTaskResponseModel.builder()
                .id( createTask.getId())
                .taskName( createTask.getTaskName())
                .date( createTask.getDate())
                .taskFile( createTask.getTaskFile())
                .build();


        return new ResponseEntity<>(createDailyTaskResponseModel, HttpStatus.CREATED);
    }
}
