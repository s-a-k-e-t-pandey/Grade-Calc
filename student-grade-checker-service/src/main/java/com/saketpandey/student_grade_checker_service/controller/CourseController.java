package com.saketpandey.student_grade_checker_service.controller;

import com.saketpandey.student_grade_checker_service.dto.CourseDTO;
import com.saketpandey.student_grade_checker_service.model.Course;
import com.saketpandey.student_grade_checker_service.repository.CourseRepository;
import com.saketpandey.student_grade_checker_service.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping("/add")
    public ResponseEntity<String> addCourse(@Valid @RequestBody CourseDTO courseDTO) {
        int defaultCreditHours = 4; // Default value if creditHours is not provided
        Course course = new Course(
            courseDTO.getCourseId(),
            courseDTO.getCourseName(),
            courseDTO.getCreditHours() != null ? courseDTO.getCreditHours() : defaultCreditHours
        );
        courseRepository.save(course);
        return ResponseEntity.ok("Course added successfully!");
    }

}
