package com.example.UniversityManagementSystem.Repository;

import com.example.UniversityManagementSystem.Model.Participants;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParticipantsRepository  extends JpaRepository<Participants, Long> {
    Optional<Participants> findById(Long id);
}
