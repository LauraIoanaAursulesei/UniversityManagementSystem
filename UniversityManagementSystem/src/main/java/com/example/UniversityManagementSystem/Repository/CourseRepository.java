package com.example.UniversityManagementSystem.Repository;

import com.example.UniversityManagementSystem.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findById(Long id);

    List<Course> findAllByName(String courseName);
}