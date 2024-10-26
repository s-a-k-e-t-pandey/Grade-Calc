package com.saketpandey.student_grade_checker_service.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.saketpandey.student_grade_checker_service.model.Student;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByEnrollmentNumber(String enrollmentNumber);
}
