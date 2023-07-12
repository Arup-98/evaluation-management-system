package com.example.EvaluationManagementSystem.controller;

import com.example.EvaluationManagementSystem.service.AssignTraineeToBatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assign_trainee")
@RequiredArgsConstructor
public class AssignTraineeToBatchController {
    private final AssignTraineeToBatchService assignTraineeService;

//    @Autowired
//    public AssignTraineeToBatchService(AssignTraineeToBatchService assignTraineeService) {
//        this.assignTraineeService = assignTraineeService;
//    }


    @PostMapping("/{batchId}")
    public ResponseEntity<String> addTraineesToBatch(
            @PathVariable Long batchId,
            @RequestBody List<Long> traineeIds) {
        try {
            assignTraineeService.addTraineesToBatch(batchId, traineeIds);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Trainees added to batch successfully");
    }

}
