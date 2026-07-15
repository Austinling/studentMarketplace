package com.austin.student_marketplace.auth;

public record LoginRequest(
        String email,
        String password
) {
}
