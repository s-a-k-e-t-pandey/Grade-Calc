package com.saketpandey.student_grade_checker_service.controller;

import com.saketpandey.student_grade_checker_service.dto.CourseDTO;
import com.saketpandey.student_grade_checker_service.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/add")
    public ResponseEntity<String> addCourse(@Valid @RequestBody CourseDTO courseDTO) {
        courseService.addCourse(courseDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Course added successfully!");
    }
}
