package com.saketpandey.student_grade_checker_service.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.saketpandey.student_grade_checker_service.model.Grade;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> findByStudentId(Long studentId);
    List<Grade> findByCourseId(Long courseId);
    Grade findByStudentIdAndCourseId(Long studentId, Long courseId);
}
