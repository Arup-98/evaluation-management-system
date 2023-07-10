package com.example.EvaluationManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="trainer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainerId;
    private Long userId;
    private String fullName;
    private String profilePicture;
    private String designation;
    private String joiningDate;
    private Long totalYearsOfExperience;
    private String expertises;
    private String contactNumber;
    private String presentAddress;


}
