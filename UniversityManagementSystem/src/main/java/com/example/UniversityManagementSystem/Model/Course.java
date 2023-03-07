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
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "numberOfStudents")
    private Long numberOfStudents;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "semester")
    private String semester;

    @Column(name = "year")
    private String year;

    @OneToMany(mappedBy = "course",orphanRemoval = true,cascade = {CascadeType.ALL})
    List<Participants> patricipantsList;

    @OneToMany(mappedBy = "course",orphanRemoval = true,cascade = {CascadeType.ALL})
    List<Exam> examList;

    @OneToMany(mappedBy = "course",orphanRemoval = true,cascade = {CascadeType.ALL})
    List<Homework> homeworkList;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private Professor professor;

}
