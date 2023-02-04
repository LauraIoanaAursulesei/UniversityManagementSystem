package com.example.UniversityManagementSystem.Repository;

import com.example.UniversityManagementSystem.Model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExamRepository  extends JpaRepository<Exam, Long> {
    Optional<Exam> findById(Long id);
}
