package com.example.UniversityManagementSystem.Service;

import com.example.UniversityManagementSystem.Exceptions.NotFoundException;
import com.example.UniversityManagementSystem.Model.Homework;
import com.example.UniversityManagementSystem.Repository.HomeworkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeworkService {

    private HomeworkRepository homeworkRepository;

    public HomeworkService(HomeworkRepository homeworkRepository) {
        this.homeworkRepository = homeworkRepository;
    }

    public void registerHomework(Homework newHomework) {

        Homework homework = Homework.builder()
                .description(newHomework.getDescription())
                .deadline(newHomework.getDeadline())
                .points(newHomework.getPoints())
                .build();

        homeworkRepository.save(homework);
    }

    public void updateHomework(Homework newHomework) throws NotFoundException {

        Homework homework = homeworkRepository.findById(newHomework.getId()).orElseThrow(() -> new NotFoundException("Homework not found"));

        if (newHomework.getDescription() != null)
            homework.setDescription(newHomework.getDescription());

        if (newHomework.getDeadline() != null)
            homework.setDeadline(newHomework.getDeadline());

        if (newHomework.getPoints() != null)
            homework.setPoints(newHomework.getPoints());

        homeworkRepository.save(homework);
    }

    public void removeHomework(Long homeworkId) throws NotFoundException {
        Homework homework = homeworkRepository.findById(homeworkId).orElseThrow(() -> new NotFoundException("Homework not found"));
        homeworkRepository.delete(homework);
    }

    public Homework getHomework(Long homeworkId) throws NotFoundException {
        Homework homework = homeworkRepository.findById(homeworkId).orElseThrow(() -> new NotFoundException("Homework not found"));
        return homework;
    }

    public List<Homework> getAllHomeworks() throws NotFoundException {

        if (homeworkRepository.findAll().isEmpty())
            throw new NotFoundException("There are no homeworks to display");

        return homeworkRepository.findAll();
    }
}
