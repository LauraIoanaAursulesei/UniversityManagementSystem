package com.example.UniversityManagementSystem.Service;

import com.example.UniversityManagementSystem.Exceptions.NotFoundException;
import com.example.UniversityManagementSystem.Model.Exam;
import com.example.UniversityManagementSystem.Repository.ExamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {

    private ExamRepository examRepository;

    public ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    public void registerExam(Exam registerExamDTO) {

        Exam exam = Exam.builder()
                .description(registerExamDTO.getDescription())
                .examDate(registerExamDTO.getExamDate())
                .points(registerExamDTO.getPoints())
                .examRoom(registerExamDTO.getExamRoom())
                .examHour(registerExamDTO.getExamHour())
                .build();

        examRepository.save(exam);
    }

    public void updateExam(Exam newExam) throws NotFoundException {

        Exam exam = examRepository.findById(newExam.getId()).orElseThrow(() -> new NotFoundException("Exam not found"));

        if (newExam.getDescription() != null)
            exam.setDescription(newExam.getDescription());

        if (newExam.getExamDate() != null)
            exam.setExamDate(newExam.getExamDate());

        if (newExam.getPoints() != null)
            exam.setPoints(newExam.getPoints());

        if (newExam.getExamRoom() != null)
            exam.setExamRoom(newExam.getExamRoom());

        if (newExam.getExamHour() != null)
            exam.setExamHour(newExam.getExamHour());

        examRepository.save(exam);
    }

    public void removeExam(Long examId) throws NotFoundException {
        Exam exam = examRepository.findById(examId).orElseThrow(() -> new NotFoundException("Exam not found"));
        examRepository.delete(exam);
    }

    public Exam getExamById(Long examId) throws NotFoundException {

        Exam exam = examRepository.findById(examId).orElseThrow(() -> new NotFoundException("Exam not found"));
        return exam;
    }

    public List<Exam> getAllExams() throws NotFoundException {
        if (examRepository.findAll().isEmpty())
            throw new NotFoundException("There are no exams to display");

        return examRepository.findAll();
    }
}
