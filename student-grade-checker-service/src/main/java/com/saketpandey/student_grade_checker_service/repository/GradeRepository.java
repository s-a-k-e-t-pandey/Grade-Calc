package com.saketpandey.student_grade_checker_service.repository;

import com.saketpandey.student_grade_checker_service.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {
}
