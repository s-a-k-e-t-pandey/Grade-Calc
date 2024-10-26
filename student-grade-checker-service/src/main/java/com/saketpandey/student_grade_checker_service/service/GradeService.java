package com.saketpandey.student_grade_checker_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saketpandey.student_grade_checker_service.dto.GradeDTO;
import com.saketpandey.student_grade_checker_service.model.Grade;
import com.saketpandey.student_grade_checker_service.model.Student;
import com.saketpandey.student_grade_checker_service.repository.GradeRepository;

import java.util.List;

@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    public List<Grade> getGradesByStudentId(Long studentId) {
        return gradeRepository.findByStudentId(studentId);
    }

    public void addGradeToStudent(Student student, GradeDTO gradeDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addGradeToStudent'");
    }
}
