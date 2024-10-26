package com.saketpandey.student_grade_checker_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saketpandey.student_grade_checker_service.model.Student;
import com.saketpandey.student_grade_checker_service.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;  // Used to hash passwords

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public Student create(Student student) {
        // Check if the student already exists by email or enrollment number
        if (studentRepository.existsByEmail(student.getEmail())) {
            throw new IllegalArgumentException("Student with this email already exists.");
        }

        if (studentRepository.existsByEnrollmentNumber(student.getEnrollmentNumber())) {
            throw new IllegalArgumentException("Student with this enrollment number already exists.");
        }

        // Hash the password before saving
        String encodedPassword = passwordEncoder.encode(student.getPassword());
        student.setPassword(encodedPassword);

        // Save the student to the database
        return studentRepository.save(student);
    }

    public boolean validateLogin(String email, String password) {
        Optional<Student> studentOpt = studentRepository.findByEmail(email);
        if (studentOpt.isPresent()) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            return passwordEncoder.matches(password, studentOpt.get().getPassword());
        }
        return false;
    }

    public Student findByEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByEmail'");
    }

    public List<Student> allUsers() {
        List<Student> users = new ArrayList<>();

        studentRepository.findAll().forEach(users::add);

        return users;
    }

    public Optional<Student> getStudentById(Long studentId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStudentById'");
    }
}
