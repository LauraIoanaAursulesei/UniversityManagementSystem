package com.example.UniversityManagementSystem.Service;
import com.example.UniversityManagementSystem.Model.Participants;
import com.example.UniversityManagementSystem.Repository.ParticipantsRepository;
import org.springframework.stereotype.Service;

@Service
public class ParticipantsService {

    private ParticipantsRepository participantsRepository;

    public ParticipantsService(ParticipantsRepository participantsRepository) {
        this.participantsRepository = participantsRepository;
    }

    public Participants registerParticipant(Participants newParticipant)
}
