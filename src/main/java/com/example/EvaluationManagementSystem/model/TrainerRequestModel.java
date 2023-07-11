package com.example.EvaluationManagementSystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainerRequestModel {
    private Long id;
    private String fullName;
    private String email;
    private String password;
    private String profilePicture;
    private String designation;
    private String joiningDate;
    private Long yearsOfExperience;
    private String expertises;
    private String contactNumber;
    private String presentAddress;
}
