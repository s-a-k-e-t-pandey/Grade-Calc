package com.saketpandey.student_grade_checker_service.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;

public class CourseDTO {

    @NotNull(message = "Course ID cannot be null")
    private Long id;

    @NotBlank(message = "Course name cannot be blank")
    private String courseName;

    @NotBlank(message = "Course code cannot be blank")
    private String courseCode;

    @NotNull(message = "Credits cannot be null")
    @Min(value = 1, message = "Minimum credits should be 1")
    @Max(value = 10, message = "Maximum credits should be 10")
    private Integer credits;

    @NotBlank(message = "Instructor name cannot be blank")
    private String instructorName;

    // Default constructor
    public CourseDTO() {
    }

    // Parameterized constructor
    public CourseDTO(Long id, String courseName, String courseCode, Integer credits, String instructorName) {
        this.id = id;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.credits = credits;
        this.instructorName = instructorName;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }
}
