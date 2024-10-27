package com.saketpandey.student_grade_checker_service.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;

public class CourseDTO {

    @NotNull(message = "Course ID cannot be null")
    private Long courseId;

    @NotBlank(message = "Course name cannot be blank")
    private String courseName;

    @NotBlank(message = "Course code cannot be blank")
    private String courseCode;

    @NotNull(message = "Credits cannot be null")
    @Min(value = 1, message = "Minimum credits should be 1")
    @Max(value = 10, message = "Maximum credits should be 10")
    private Integer creditHours;

    @NotBlank(message = "Instructor name cannot be blank")
    private String instructorName;

    // Default constructor
    public CourseDTO() {
    }

    public CourseDTO(Long courseId, String courseName, Integer creditHours) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.creditHours = creditHours;
    }

    // Parameterized constructor
    public CourseDTO(Long courseId, String courseName, String courseCode, Integer creditHours, String instructorName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditHours = creditHours;
        this.instructorName = instructorName;
    }

    // Getters and Setters
    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
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

    public Integer getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(Integer creditHours) {
        this.creditHours = creditHours;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }
}
