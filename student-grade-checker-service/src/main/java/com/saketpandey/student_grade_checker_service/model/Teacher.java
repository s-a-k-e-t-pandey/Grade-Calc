package com.saketpandey.student_grade_checker_service.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "teacher")
    private Set<Course> courses;

    // Getters and Setters
}
