package com.saketpandey.student_grade_checker_service.service;

import com.saketpandey.student_grade_checker_service.repository.StudentRepository;
import com.saketpandey.student_grade_checker_service.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.saketpandey.student_grade_checker_service.dto.*;

@Service
public class AuthenticationService {

    @Autowired
    private final StudentRepository studentRepository;
    
    @Autowired
    private final PasswordEncoder passwordEncoder;
    
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(StudentRepository studentRepository, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder) {
        this.studentRepository = studentRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    public Student signup(RegistrationDTO input) {
        Student student = new Student()
                .setFullName(input.getFullName())
                .setEmail(input.getEmail())
                .setPassword(passwordEncoder.encode(input.getPassword()))
                .setEnrollmentNumber(input.getEnrollmentNumber());
    
        return studentRepository.save(student);
    }
    

    public Student authenticate(LoginUserDTO input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return studentRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}