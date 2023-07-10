package com.example.EvaluationManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="trainee")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TraineeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long traineeId;
    private String gender;
    private Date dateOfBirth;
    private String degreeName;
    private String educationalInstitute;
    private Double cgpa;
    private Integer passingYear;
    private String presentAddress;


    @OneToOne
    @JoinColumn(name = "userId")
    private UserEntity user;




}
