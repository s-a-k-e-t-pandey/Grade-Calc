package com.saketpandey.student_grade_checker_service.repository;

import com.saketpandey.student_grade_checker_service.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
