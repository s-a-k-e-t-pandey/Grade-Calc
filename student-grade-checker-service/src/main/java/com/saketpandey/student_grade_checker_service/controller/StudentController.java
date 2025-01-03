package com.saketpandey.student_grade_checker_service.controller;

import com.saketpandey.student_grade_checker_service.dto.GradeDTO;
import com.saketpandey.student_grade_checker_service.dto.StudentDTO;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public ResponseEntity<StudentDTO> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Student currentUser = (Student) authentication.getPrincipal(); // Ensure this is correctly typed
        return ResponseEntity.ok(new StudentDTO(currentUser)); // Ensure StudentDTO constructor accepts Student
    }



    // 2. Get all users - Requires authentication
    @GetMapping("/")
    public ResponseEntity<List<Student>> allUsers() {
        List<Student> users = studentService.allUsers();
        return ResponseEntity.ok(users);
    }

    // 3. Get All Grades for a particular student - Requires authentication
    @GetMapping("/{studentId}/grades")
    public ResponseEntity<List<GradeDTO>> getGradesByStudentId(@PathVariable Long studentId) {
        List<Grade> grades = gradeService.getGradesByStudentId(studentId);

        Map<Long, GradeDTO> gradeMap = new HashMap<>();

        for (Grade grade : grades) {
            Long courseId = grade.getCourse().getId();
            String courseName = grade.getCourse().getCourseName();
            Integer gradeValue = Integer.parseInt(grade.getGradeValue());
            Integer creditHours = grade.getCourse().getCreditHours(); // Fetch creditHours from Course

            // Only add the grade if the course ID is not already in the map
            if (!gradeMap.containsKey(courseId)) {
                gradeMap.put(courseId, new GradeDTO(courseId, courseName, gradeValue, creditHours));
            }
        }

        List<GradeDTO> gradeDTOs = new ArrayList<>(gradeMap.values());
        return ResponseEntity.ok(gradeDTOs);
    }


    @GetMapping("/{studentId}/cgpa")
    public ResponseEntity<Double> calculateCGPA(@PathVariable Long studentId) {
        List<Grade> grades = gradeService.getGradesByStudentId(studentId);
        
        double totalGradePoints = 0;
        int totalCreditHours = 0;
        
        for (Grade grade : grades) {
            int creditHours = grade.getCourse().getCreditHours();
            int gradeValue = Integer.parseInt(grade.getGradeValue());
            double gradePoint = convertToGradePoint(gradeValue);

            totalGradePoints += gradePoint * creditHours;
            totalCreditHours += creditHours;
        }

        double cgpa = totalCreditHours != 0 ? totalGradePoints / totalCreditHours : 0.0;
        return ResponseEntity.ok(cgpa);
    }

    // Convert grade percentage to grade point (e.g., 85-100 -> 4.0, 75-84 -> 3.5, etc.)
    private double convertToGradePoint(int grade) {
        if (grade >= 85) return 4.0;
        else if (grade >= 75) return 3.5;
        else if (grade >= 65) return 3.0;
        else if (grade >= 50) return 2.5;
        else return 0.0;
    }

    // @GetMapping("/{studentId}/cgpa")
    // public ResponseEntity<Double> getStudentCgpa(@PathVariable Long studentId) {
    //     double cgpa = studentService.calculateCgpa(studentId);
    //     return ResponseEntity.ok(cgpa);
    // }



    // 4. Add grade to a particular student - Requires authentication
    @PostMapping("/{studentId}/grades")
    public ResponseEntity<String> addGradeToStudent(
            @PathVariable Long studentId,
            @Valid @RequestBody GradeDTO gradeDto) {

        Optional<Student> studentOptional = studentService.getStudentById(studentId);

        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            gradeService.addGradeToStudent(student, gradeDto);
            return new ResponseEntity<>("Grade added/updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
        }
    }
}
