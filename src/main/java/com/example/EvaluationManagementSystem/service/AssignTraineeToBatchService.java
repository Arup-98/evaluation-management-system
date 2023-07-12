package com.example.EvaluationManagementSystem.service;

import java.util.List;

public interface AssignTraineeToBatchService {
    void addTraineesToBatch(Long batchId, List<Long> traineeIds);

}
