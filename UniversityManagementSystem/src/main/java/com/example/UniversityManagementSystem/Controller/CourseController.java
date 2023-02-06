package com.example.UniversityManagementSystem.Controller;
import com.example.UniversityManagementSystem.Exceptions.AlreadyInUseException;
import com.example.UniversityManagementSystem.Exceptions.NotFoundException;
import com.example.UniversityManagementSystem.Model.Course;
import com.example.UniversityManagementSystem.Service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")

public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping()
    public Course createCourse(@RequestBody Course newCourse) throws AlreadyInUseException {
        return courseService.registerCourse(newCourse);
    }

    @PutMapping()
    public Course updateCourse(@RequestBody Course newCourse) throws NotFoundException, AlreadyInUseException {
        return courseService.updateCourse(newCourse);
    }

    @DeleteMapping()
    public void removeCourse(Long courseId) throws NotFoundException {
        courseService.removeCourse(courseId);
    }

    @GetMapping("/allCourses")
    public List<Course> getAllCourses() throws NotFoundException{
        return courseService.getAllCourses();
    }

    @GetMapping("/courseByName")
    public Optional<Course> getCourseByName(@RequestParam String courseName) throws NotFoundException{
        return courseService.getCourseByName(courseName);
    }
}
