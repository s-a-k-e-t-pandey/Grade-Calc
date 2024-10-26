package com.saketpandey.student_grade_checker_service.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.saketpandey.student_grade_checker_service.model.Student;

public class RegistrationDTO {

    @NotEmpty(message = "The full name is required.")
    @Size(min = 2, max = 100, message = "The length of full name must be between 2 and 100 characters.")
    private String fullName;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    @NotBlank(message = "Enrollment number is required")
    @Size(min = 8, max = 15, message = "Enrollment number must be between 8 and 15 characters long")
    private String enrollmentNumber;

    // Default constructor
    public RegistrationDTO() {}

    // Parameterized constructor
    public RegistrationDTO(String fullName, String email, String password, String enrollmentNumber) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.enrollmentNumber = enrollmentNumber;
    }

    // Getters and Setters
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEnrollmentNumber() {
        return enrollmentNumber;
    }

    public void setEnrollmentNumber(String enrollmentNumber) {
        this.enrollmentNumber = enrollmentNumber;
    }

    public Student toStudent() {
        return new Student()
                .setFullName(this.fullName)
                .setEmail(this.email.toLowerCase())
                .setPassword(this.password) 
                .setEnrollmentNumber(this.enrollmentNumber);
    }
}
