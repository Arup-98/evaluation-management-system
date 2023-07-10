package com.example.EvaluationManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="admin")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String profilePicture;
    private String designation;
    private String joiningDate;
    private Long totalYearsOfExperience;
    private String expertises;
    private String contactNumber;
    private String presentAddress;




}
