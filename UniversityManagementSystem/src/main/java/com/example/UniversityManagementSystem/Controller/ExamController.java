package com.example.UniversityManagementSystem.Controller;

import com.example.UniversityManagementSystem.Exceptions.NotFoundException;
import com.example.UniversityManagementSystem.Model.Exam;
import com.example.UniversityManagementSystem.Service.ExamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @PostMapping()
    public Exam registerExam(@RequestBody Exam newExam) {
        return examService.registerExam(newExam);
    }

    @PutMapping()
    public Exam updateExam(@RequestBody Exam newExam) throws NotFoundException {
        return examService.updateExam(newExam);
    }

    @DeleteMapping()
    public void removeExam(Long examId) throws NotFoundException {
        examService.removeExam(examId);
    }

    @GetMapping("/examById")
    public Exam getExamById(@RequestParam Long examId) throws NotFoundException {
        return examService.getExamById(examId);
    }

    @GetMapping("/allExams")
    public List<Exam> getAllExams() throws NotFoundException {
        return examService.getAllExams();
    }
}
