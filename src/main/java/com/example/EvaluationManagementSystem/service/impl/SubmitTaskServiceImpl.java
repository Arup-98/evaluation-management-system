package com.example.EvaluationManagementSystem.service.impl;

import com.example.EvaluationManagementSystem.entity.CreateDailyTaskEntity;
import com.example.EvaluationManagementSystem.entity.SubmitTaskEntity;
import com.example.EvaluationManagementSystem.model.CreateDailyTaskResponseModel;
import com.example.EvaluationManagementSystem.model.SubmitTaskRequestModel;
import com.example.EvaluationManagementSystem.model.SubmitTaskResponseModel;
import com.example.EvaluationManagementSystem.repository.CreateDailyTaskRepository;
import com.example.EvaluationManagementSystem.repository.SubmitTaskRepository;
import com.example.EvaluationManagementSystem.service.SubmitTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubmitTaskServiceImpl implements SubmitTaskService {

    private final SubmitTaskRepository submitTaskRepository;
    private final CreateDailyTaskRepository createDailyTaskRepository;

    @Override
    public ResponseEntity<Object> submitTask(SubmitTaskRequestModel submitTaskRequestModel) {
        SubmitTaskEntity submitTaskEntity = SubmitTaskEntity.builder()
                .traineeId(submitTaskRequestModel.getTraineeId())
                .taskId(submitTaskRequestModel.getTaskId())
                .date(submitTaskRequestModel.getDate())
                .fileUpload(submitTaskRequestModel.getFileUpload())
                .build();

        SubmitTaskEntity savedSubmitTask = submitTaskRepository.save(submitTaskEntity);
        SubmitTaskResponseModel responseModel = SubmitTaskResponseModel.builder()
                .id(savedSubmitTask.getId())
                .taskId(savedSubmitTask.getTaskId())
                .traineeId(savedSubmitTask.getTraineeId())
                .date(savedSubmitTask.getDate())
                .fileUpload(savedSubmitTask.getFileUpload())
                .build();

        return new ResponseEntity<>(responseModel, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<SubmitTaskEntity>> getSubmitTaskByTraineeId(Long traineeId) {
        return null;
    }

    @Override
    public ResponseEntity<List<SubmitTaskEntity>> getSubmitTasksByCreateTaskId(Long createTaskId) {
        Optional <CreateDailyTaskEntity> createDailyTask=createDailyTaskRepository.findById(createTaskId);
        if(createDailyTask !=null){
            CreateDailyTaskResponseModel createDailyTaskResponseModel = CreateDailyTaskResponseModel.builder()
                    .id(createDailyTask.get().getId())
                    .taskName(createDailyTask.get().getTaskName())
                    .task(createDailyTask.get().getTaskFile())
//                    .submitTasks(createDailyTask.get().getSubmitTaskEntities())
                    .build();
            return new ResponseEntity<>(HttpStatus.OK, createDailyTaskResponseModel.getTaskName());
        }
        return new ResponseEntity<List<SubmitTaskEntity>>((List<SubmitTaskEntity>) new RuntimeException("Nothing Found"), HttpStatus.NOT_FOUND);

    }



}
