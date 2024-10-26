package com.saketpandey.student_grade_checker_service.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(nullable = false)
    private String courseName;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Grade> grades = new ArrayList<>();

    public Course() {
    }

    public Course(Long courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }


    // Getters and Setters
    public Long getId() { return courseId; }
    public void setId(Long courseId) { this.courseId = courseId; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public List<Student> getStudents() { return students; }
    public void setStudents(List<Student> students) { this.students = students; }

    public List<Grade> getGrades() { return grades; }
    public void setGrades(List<Grade> grades) { this.grades = grades; }
}
