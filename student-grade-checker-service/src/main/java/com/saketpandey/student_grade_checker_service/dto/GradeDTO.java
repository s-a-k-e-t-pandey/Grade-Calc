package com.saketpandey.student_grade_checker_service.dto;

import com.saketpandey.student_grade_checker_service.model.Course;
import com.saketpandey.student_grade_checker_service.model.Grade;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class GradeDTO {

    @NotNull(message = "Course ID is required")
    private Long courseId;

    @NotNull(message = "Grade is required")
    @Min(value = 0, message = "Grade cannot be less than 0")
    @Max(value = 100, message = "Grade cannot be more than 100")
    private Integer grade;

    private String courseName;

    // No-argument constructor for deserialization
    public GradeDTO() {}

    // Constructor to create DTO from Grade entity
    public GradeDTO(Grade grade) {
        this.courseId = grade.getCourse().getId();
        this.courseName = grade.getCourse().getCourseName(); // Set the course name
        this.grade = Integer.parseInt(grade.getGradeValue());
    }

    public GradeDTO(Long courseId, String courseName, Integer grade) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.grade = grade;
    }

    // Getters and Setters
    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    // Convert DTO to Entity
    public Grade toGrade(Course course) {
        Grade gradeEntity = new Grade();
        gradeEntity.setCourse(course);
        gradeEntity.setGradeValue(String.valueOf(this.grade));
        // gradeEntity.setCreditHours(this.creditHours);
        return gradeEntity;
    }
}
