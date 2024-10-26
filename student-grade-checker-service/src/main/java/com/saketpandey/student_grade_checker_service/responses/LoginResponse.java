package com.saketpandey.student_grade_checker_service.responses;

public class LoginResponse {
    private String token;
    private long expiresIn;

    public LoginResponse() {}

    public LoginResponse(String token, long expiresIn) {
        this.token = token;
        this.expiresIn = expiresIn;
    }

    // Getter and Setter for `token`
    public String getToken() {
        return token;
    }

    public LoginResponse setToken(String token) {
        this.token = token;
        return this;  // returning `this` for method chaining
    }

    // Getter and Setter for `expiresIn`
    public long getExpiresIn() {
        return expiresIn;
    }

    public LoginResponse setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
        return this;  // returning `this` for method chaining
    }
}
