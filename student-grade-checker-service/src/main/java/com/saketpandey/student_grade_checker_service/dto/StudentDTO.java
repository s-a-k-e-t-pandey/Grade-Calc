package com.saketpandey.student_grade_checker_service.dto;

import com.saketpandey.student_grade_checker_service.model.Student;

public class StudentDTO {
    private Long id;
    private String fullName;
    private String email;
    private String enrollmentNumber;
    private Double gpa;
    // Add other necessary fields

    // Constructor to initialize fields from the Student object
    public StudentDTO(Student student) {
        this.id = student.getId();
        this.fullName = student.getFullName();
        this.email = student.getEmail();
        this.enrollmentNumber = student.getEnrollmentNumber();
        this.gpa = student.getGpa();
        // Initialize other fields as necessary
    }

    // Getters for all fields
    public Long getId() { return id; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getEnrollmentNumber() { return enrollmentNumber; }
    public Double getGpa() { return gpa; }
}
