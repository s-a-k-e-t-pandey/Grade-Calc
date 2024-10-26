package com.saketpandey.student_grade_checker_service.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Table(name = "students")
public class Student implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @CreationTimestamp
    @Column(updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    @Column(name = "enrollment_number", nullable = false, unique = true)
    private String enrollmentNumber;

    @Column(name = "gpa")
    private Double gpa;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "student", cascade = CascadeType.ALL)
    private Set<Grade> grades = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "student_courses",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses = new ArrayList<>();

    // Chainable Getters and Setters
    public Long getId() { return id; }
    public Student setId(Long id) { this.id = id; return this; }

    public String getFullName() { return fullName; }
    public Student setFullName(String fullName) { this.fullName = fullName; return this; }

    public String getEmail() { return email; }
    public Student setEmail(String email) { this.email = email; return this; }

    public String getPassword() { return password; }
    public Student setPassword(String password) { this.password = password; return this; }

    public String getEnrollmentNumber() { return enrollmentNumber; }
    public Student setEnrollmentNumber(String enrollmentNumber) { this.enrollmentNumber = enrollmentNumber; return this; }

    public Double getGpa() { return gpa; }
    public Student setGpa(Double gpa) { this.gpa = gpa; return this; }

    public Set<Grade> getGrades() { return grades; }
    public Student setGrades(Set<Grade> grades) { this.grades = grades; return this; }

    public List<Course> getCourses() { return courses; }
    public Student setCourses(List<Course> courses) { this.courses = courses; return this; }

    // UserDetails overrides
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { return List.of(); }

    @Override
    public String getUsername() { return email; }

    @Override
    public boolean isAccountNonExpired() { return true; }
    @Override
    public boolean isAccountNonLocked() { return true; }
    @Override
    public boolean isCredentialsNonExpired() { return true; }
    @Override
    public boolean isEnabled() { return true; }
}
