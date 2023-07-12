package com.example.EvaluationManagementSystem.service.impl;

import com.example.EvaluationManagementSystem.repository.CreateBatchRepository;
import com.example.EvaluationManagementSystem.repository.TraineeRepository;
import com.example.EvaluationManagementSystem.service.AssignTraineeToBatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AssignTraineeToBatchServiceImpl implements AssignTraineeToBatchService {
    private final CreateBatchRepository createBatchRepository;
    private final TraineeRepository traineeRepository;

    @Override
    public void addTraineesToBatch(Long batchId, List<Long> traineeIds) {
        var batch = createBatchRepository.findById(batchId);
        if(batch.isPresent()){
            for (Long traineeId : traineeIds) {
                var trainee =traineeRepository.findById(traineeId);
                if(trainee.isPresent()){
                    // System.out.println(trainee.get().getFullName());
                    batch.get().getTrainees().add(trainee.get());
                }else{
                    System.out.println("No batch found with id"+ traineeId);
                }
            }
            createBatchRepository.save(batch.get());
        }
        else{
            System.out.println("No batch batch");
        }

    }

}
