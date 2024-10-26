package com.saketpandey.student_grade_checker_service.dto;

import com.saketpandey.student_grade_checker_service.model.Grade;
import com.saketpandey.student_grade_checker_service.model.Course;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class GradeDTO {

    @NotNull(message = "Course is required")
    private Course course; // Use Course type instead of String

    @NotNull(message = "Grade is required")
    @Min(value = 0, message = "Grade cannot be less than 0")
    @Max(value = 100, message = "Grade cannot be more than 100")
    private Integer grade;

    @NotNull(message = "Credit hours are required")
    @Min(value = 1, message = "Credit hours must be at least 1")
    @Max(value = 6, message = "Credit hours cannot exceed 6")
    private Integer creditHours;

    // Getters and Setters

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(Integer creditHours) {
        this.creditHours = creditHours;
    }

    // Optional: A method to convert the DTO to an entity if needed
    public Grade toGrade() {
        Grade gradeEntity = new Grade();
        gradeEntity.setCourse(this.course); // Set the Course object
        gradeEntity.setGradeValue(this.grade.toString()); // Assuming gradeValue is the string representation of grade
        return gradeEntity;
    }
}
