package com.saketpandey.student_grade_checker_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.saketpandey.student_grade_checker_service.repository")
public class StudentGradeCheckerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentGradeCheckerServiceApplication.class, args);
	}

}
