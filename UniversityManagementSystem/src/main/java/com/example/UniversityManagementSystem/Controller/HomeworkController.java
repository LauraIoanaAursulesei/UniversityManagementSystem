package com.example.UniversityManagementSystem.Controller;
import com.example.UniversityManagementSystem.Exceptions.NotFoundException;
import com.example.UniversityManagementSystem.Model.Homework;
import com.example.UniversityManagementSystem.Service.HomeworkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/homework")

public class HomeworkController {

    private HomeworkService homeworkService;

    public HomeworkController(HomeworkService homeworkService) {
        this.homeworkService = homeworkService;
    }

    @PostMapping()
    public Homework registerHomework(@RequestBody Homework newHomework) {
        return homeworkService.registerHomework(newHomework);
    }

    @PutMapping()
    public Homework updateHomekork(@RequestBody Homework newHomework) throws NotFoundException {
        return homeworkService.updateHomework(newHomework);
    }

    @DeleteMapping()
    public void removeHomekork(Long homekorkId) throws NotFoundException {
        homeworkService.removeHomework(homekorkId);
    }

    @GetMapping("/homeworkById")
    public Homework getHomeworkById(@RequestParam Long id) throws NotFoundException {
        return homeworkService.getHomework(id);
    }

    @GetMapping("/allHomework")
    public List<Homework> getAllHomework() throws NotFoundException {
        return homeworkService.getAllHomework();
    }
}
