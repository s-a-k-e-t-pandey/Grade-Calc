package com.saketpandey.student_grade_checker_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.saketpandey.student_grade_checker_service.dto.CourseDTO;

import javax.validation.Valid;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @PostMapping("/add")
    public ResponseEntity<String> addCourse(@Valid @RequestBody CourseDTO courseDTO) {
        // Save course logic here
        return ResponseEntity.ok("Course added successfully!");
    }
}