package com.example.UniversityManagementSystem.Repository;

import com.example.UniversityManagementSystem.Model.Homework;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HomeworkRepository  extends JpaRepository<Homework, Long> {
    Optional<Homework> findById(Long id);
}
