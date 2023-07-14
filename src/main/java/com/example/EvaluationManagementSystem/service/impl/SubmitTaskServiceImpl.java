package com.example.EvaluationManagementSystem.service.impl;

import com.example.EvaluationManagementSystem.entity.CreateDailyTaskEntity;
import com.example.EvaluationManagementSystem.entity.SubmitTaskEntity;
import com.example.EvaluationManagementSystem.model.CreateDailyTaskResponseModel;
import com.example.EvaluationManagementSystem.model.SubmitTaskRequestModel;
import com.example.EvaluationManagementSystem.model.SubmitTaskResponseModel;
import com.example.EvaluationManagementSystem.repository.CreateDailyTaskRepository;
import com.example.EvaluationManagementSystem.repository.SubmitTaskRepository;
import com.example.EvaluationManagementSystem.repository.TraineeRepository;
import com.example.EvaluationManagementSystem.service.SubmitTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubmitTaskServiceImpl implements SubmitTaskService {

    private final SubmitTaskRepository submitTaskRepository;
    private final CreateDailyTaskRepository createDailyTaskRepository;
    private final TraineeRepository traineeRepository;

    @Override
    public ResponseEntity<Object> submitTask(SubmitTaskRequestModel submitTaskRequestModel) {
        CreateDailyTaskEntity createDailyTask = createDailyTaskRepository.findById(submitTaskRequestModel.getTaskId()).orElseThrow();
        SubmitTaskEntity submitTaskEntity = SubmitTaskEntity.builder()
              .traineeId(submitTaskRequestModel.getTraineeId())
                .task(createDailyTask)
                .date(submitTaskRequestModel.getDate())
                .fileUpload(submitTaskRequestModel.getFileUpload())
                .build();

        SubmitTaskEntity savedSubmitTask = submitTaskRepository.save(submitTaskEntity);
//        SubmitTaskResponseModel responseModel = SubmitTaskResponseModel.builder()
//                .submissionId(savedSubmitTask.getId())
//               .traineeId(savedSubmitTask.getTraineeId())
//                .date(savedSubmitTask.getDate())
//                .build();

        return new ResponseEntity<>(savedSubmitTask, HttpStatus.CREATED);
    }

//    @Override
//    public ResponseEntity<List<SubmitTaskEntity>> getSubmitTaskByTraineeId(Long traineeId) {
//        return null;
//    }

//    @Override
//    public ResponseEntity<List<SubmitTaskResponseModel>> getSubmitTasksByCreateTaskId(Long createTaskId) {
//
//        Optional<CreateDailyTaskEntity> createDailyTask=createDailyTaskRepository.findById(createTaskId);
//
//        if (createDailyTask.isEmpty()){
//            throw  new IllegalArgumentException("Invalid task ID");
//        }
//        List<SubmitTaskEntity> submitTaskEntities = submitTaskRepository.findByTaskId(createDailyTask);
//        if(submitTaskEntities != null){
//          List<SubmitTaskResponseModel> submitTaskResponseModels = new ArrayList<>();
//                  for(SubmitTaskEntity submitTaskEntity : submitTaskEntities){
//                      SubmitTaskResponseModel submitTaskResponseModel = new SubmitTaskResponseModel();
//                      submitTaskResponseModel.setTaskId(submitTaskEntity.getTaskId());
//                      submitTaskResponseModel.setTraineeId(submitTaskEntity.getTraineeId());
//                      submitTaskResponseModel.setFileUpload(submitTaskEntity.getFileUpload());
//
//                     submitTaskResponseModels.add(submitTaskResponseModel);
//                  }
//
//            return new ResponseEntity<>( submitTaskResponseModels , HttpStatus.OK);
//
//
//            }
//        else{
//            throw new RuntimeException("Daly task is not created");
//
//        }
//
//    }

    @Override
    public List<SubmitTaskResponseModel> getTaskSubmissionsById(Long taskId) {
        return submitTaskRepository.findByTaskId(taskId).stream().map(submitTaskEntity -> SubmitTaskResponseModel.builder()
                .traineeId(submitTaskEntity.getTraineeId())
                .submissionId(submitTaskEntity.getId())
                .build()
        ).toList();
    }

    @Override
    public SubmitTaskResponseModel getSubmissionsByIdUnderTask(Long taskId, Long submissionsId) {
        SubmitTaskEntity submitTaskEntity=submitTaskRepository.findByIdAndTaskId(submissionsId,taskId).orElseThrow();

        return SubmitTaskResponseModel.builder()
                .submissionId(submitTaskEntity.getId())
                .traineeId(submitTaskEntity.getTraineeId())
                .build();
    }


}
