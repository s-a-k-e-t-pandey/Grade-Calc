package com.saketpandey.student_grade_checker_service.service;

import com.saketpandey.student_grade_checker_service.dto.GradeDTO;
import com.saketpandey.student_grade_checker_service.model.Course;
import com.saketpandey.student_grade_checker_service.model.Grade;
import com.saketpandey.student_grade_checker_service.model.Student;
import com.saketpandey.student_grade_checker_service.repository.GradeRepository;
import com.saketpandey.student_grade_checker_service.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired // Ensure this is autowired
    private CourseRepository courseRepository;

    public List<Grade> getGradesByStudentId(Long studentId) {
        return gradeRepository.findByStudentId(studentId);
    }

    public void addGradeToStudent(Student student, GradeDTO gradeDto) {
        // Check if the grade for this courseId already exists for the student
        Grade existingGrade = gradeRepository.findByStudentIdAndCourseId(student.getId(), gradeDto.getCourseId());
    
        if (existingGrade != null) {
            // Update the existing grade
            existingGrade.setGradeValue(String.valueOf(gradeDto.getGrade()));
            gradeRepository.save(existingGrade);
        } else {
            // Create a new grade
            Grade newGrade = new Grade();
            newGrade.setStudent(student);
            
            // Fetch course from database to ensure consistency or provide default values
            Course course = courseRepository.findById(gradeDto.getCourseId()).orElse(
                new Course(gradeDto.getCourseId(), gradeDto.getCourseName(), 3) // Default credit hours
            );
            newGrade.setCourse(course);
            newGrade.setGradeValue(String.valueOf(gradeDto.getGrade()));
            gradeRepository.save(newGrade);
        }
    }
    
    
}
