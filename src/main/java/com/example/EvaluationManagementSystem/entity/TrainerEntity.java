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

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity user;


}
