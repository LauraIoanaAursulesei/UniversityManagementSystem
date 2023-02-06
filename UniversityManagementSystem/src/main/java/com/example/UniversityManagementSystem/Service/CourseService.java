package com.example.UniversityManagementSystem.Service;

import com.example.UniversityManagementSystem.Exceptions.AlreadyInUseException;
import com.example.UniversityManagementSystem.Exceptions.NotFoundException;
import com.example.UniversityManagementSystem.Model.Course;
import com.example.UniversityManagementSystem.Repository.CourseRepository;
import com.example.UniversityManagementSystem.Repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private CourseRepository courseRepository;
    private ProfessorRepository professorRepository;

    public CourseService(CourseRepository courseRepository, ProfessorRepository professorRepository) {
        this.courseRepository = courseRepository;
        this.professorRepository = professorRepository;
    }

    public boolean isCourseNameUnique(String name) {
        return courseRepository.findByName(name).isEmpty();
    }


    public Course registerCourse(Course newCourse) throws AlreadyInUseException{
        if (!isCourseNameUnique(newCourse.getName())) {
            throw new AlreadyInUseException("This course already exists");
        }

        //TODO verific ca nu mai exista un curs cu acelasi nume

        Course course = Course.builder()
                .name(newCourse.getName())
                .numberOfStudents(0L)
                .description(newCourse.getDescription())
                .year(newCourse.getYear())
                .semester(newCourse.getSemester())
                .build();

        courseRepository.save(course);
        return course;

    }

    public Course updateCourse(Course newCourse) throws NotFoundException, AlreadyInUseException {
        Course course = courseRepository.findById(newCourse.getId()).orElseThrow(() -> new NotFoundException("Course not found"));

        if (!isCourseNameUnique(newCourse.getName())) {
            throw new AlreadyInUseException("A course with this name already exists");
        }

        if (newCourse.getName() != null)
            course.setName(newCourse.getName());

        if (newCourse.getDescription() != null)
            course.setDescription(newCourse.getDescription());

        if (newCourse.getYear() != null)
            course.setYear(newCourse.getYear());

        if (newCourse.getSemester() != null)
            course.setSemester(newCourse.getSemester());

        return courseRepository.save(course);
    }

    public void removeCourse(Long courseId) throws NotFoundException {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new NotFoundException("Course not found"));
        courseRepository.delete(course);
    }

    public List<Course> getAllCourses() throws NotFoundException {
        List<Course> courses = courseRepository.findAll();

        if (courses.isEmpty())
            throw new NotFoundException("There are no courses to display");

        return courses;
    }

    public Optional<Course> getCourseByName(String courseName) throws NotFoundException {

        Optional<Course> courses = courseRepository.findByName(courseName);

        if (courses.isEmpty())
            throw new NotFoundException("Course / Courses Not Found");

        return courses;
    }

}
