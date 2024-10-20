package com.saketpandey.student_grade_checker_service.repository;

import com.saketpandey.student_grade_checker_service.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
