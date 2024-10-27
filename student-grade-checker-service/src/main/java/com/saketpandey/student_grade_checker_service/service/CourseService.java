package com.saketpandey.student_grade_checker_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saketpandey.student_grade_checker_service.dto.CourseDTO;
import com.saketpandey.student_grade_checker_service.model.Course;
import com.saketpandey.student_grade_checker_service.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course addCourse(CourseDTO courseDTO) {
        Course course = new Course();
        course.setCourseName(courseDTO.getCourseName());
        return courseRepository.save(course);
    }

}
