package com.saketpandey.student_grade_checker_service.controller;

import com.saketpandey.student_grade_checker_service.dto.GradeDTO;
import com.saketpandey.student_grade_checker_service.model.Grade;
import com.saketpandey.student_grade_checker_service.model.Student;
import com.saketpandey.student_grade_checker_service.service.GradeService;
import com.saketpandey.student_grade_checker_service.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private GradeService gradeService;

    // 1. Get the authenticated student's information
    @GetMapping("/me")
    public ResponseEntity<Student> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Student currentUser = (Student) authentication.getPrincipal();
        return ResponseEntity.ok(currentUser);
    }

    // 2. Get all users - Requires authentication
    @GetMapping("/")
    public ResponseEntity<List<Student>> allUsers() {
        List<Student> users = studentService.allUsers();
        return ResponseEntity.ok(users);
    }

    // 3. Get All Grades for a particular student - Requires authentication
    @GetMapping("/{studentId}/grades")
    public ResponseEntity<?> getAllGrades(@PathVariable Long studentId) {
        List<Grade> grades = gradeService.getGradesByStudentId(studentId);
        return ResponseEntity.ok(grades);
    }

    // 4. Add grade to a particular student - Requires authentication
    @PostMapping("/{studentId}/grades")
    public ResponseEntity<String> addGradeToStudent(
            @PathVariable Long studentId,
            @Valid @RequestBody GradeDTO gradeDto) {

        Optional<Student> studentOptional = studentService.getStudentById(studentId);

        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            gradeService.addGradeToStudent(student, gradeDto);
            return new ResponseEntity<>("Grade added successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
        }
    }

}
