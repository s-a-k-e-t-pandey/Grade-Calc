package com.saketpandey.student_grade_checker_service.repository;

import com.saketpandey.student_grade_checker_service.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
