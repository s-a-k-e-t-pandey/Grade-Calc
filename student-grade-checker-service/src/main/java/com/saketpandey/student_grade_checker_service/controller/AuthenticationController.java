package com.saketpandey.student_grade_checker_service.controller;

import com.saketpandey.student_grade_checker_service.dto.RegistrationDTO;
import com.saketpandey.student_grade_checker_service.dto.LoginUserDTO;
import com.saketpandey.student_grade_checker_service.model.Student;
import com.saketpandey.student_grade_checker_service.responses.LoginResponse;
import com.saketpandey.student_grade_checker_service.service.JwtService;
import com.saketpandey.student_grade_checker_service.service.AuthenticationService;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {

    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    // Signup Route
    @PostMapping("/signup")
    public ResponseEntity<Student> register(@Valid @RequestBody RegistrationDTO registerUserDto) {
        Student registeredUser = authenticationService.signup(registerUserDto);
        return ResponseEntity.ok(registeredUser);
    }

    // Login Route - Returns JWT token upon successful authentication
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDTO loginUserDto) {
        Student authenticatedUser = authenticationService.authenticate(loginUserDto);

        // Generate JWT token
        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse()
            .setToken(jwtToken)
            .setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }

    // 5. Signout Route (Optional) - Clear JWT token or client-side token deletion
    @PostMapping("/signout")
    public ResponseEntity<?> signout() {
        return ResponseEntity.ok("Signout successful");
    }
}
