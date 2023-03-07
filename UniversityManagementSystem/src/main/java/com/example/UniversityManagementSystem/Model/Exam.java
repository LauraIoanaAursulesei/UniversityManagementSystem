package com.example.UniversityManagementSystem.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "exam")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "examDate")
    private String examDate;

    //ce punctaj are examenul
    @Column(name = "points")
    private Long points;

    @Column(name = "examRoom")
    private String examRoom;

    @Column(name = "examHour")
    private String examHour;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private Course course;
}
