package com.example.UniversityManagementSystem.Repository;

import com.example.UniversityManagementSystem.Model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfessorRepository  extends JpaRepository<Professor, Long> {
    Optional<Professor> findById(Long id);
}
