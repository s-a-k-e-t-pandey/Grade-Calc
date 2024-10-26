package com.saketpandey.student_grade_checker_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.saketpandey.student_grade_checker_service.model.Course;
import com.saketpandey.student_grade_checker_service.repository.CourseRepository;

@Component
public class CourseInitializer implements CommandLineRunner {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void run(String... args) throws Exception {
        if (courseRepository.count() == 0) {
            courseRepository.saveAll(List.of(
                new Course(1L, "Mathematics"),
                new Course(2L, "Computer Science"),
                new Course(3L, "Physics"),
                new Course(4L, "Chemistry"),
                new Course(5L, "AI ML"),
                new Course(6L, "Data Structures")
            ));
        }
    }
}
