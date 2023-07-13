package com.example.EvaluationManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="trainee")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TraineeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String gender;
    private String dateOfBirth;
    private String degreeName;
    private String educationalInstitute;
    private Double cgpa;
    private Integer passingYear;
    private String presentAddress;
    private String fullName;
    private String profilePicture;
    private String designation;
    private String contactNumber;


    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany (mappedBy = "trainee")
    private List<TaskEvaluationEntity> taskEvaluationEntity = new ArrayList<>();

    @OneToOne(mappedBy = "traineeEntity")
    private ManagersEvaluationEntity managersEvaluationEntity;

    @OneToOne(mappedBy = "traineeEntity")
    private AptitudeAndCEOInterviewEntity aptitudeAndCEOInterviewEntity;



}
