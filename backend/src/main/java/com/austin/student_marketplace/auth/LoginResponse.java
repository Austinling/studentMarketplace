package com.austin.student_marketplace.auth;

import lombok.Builder;

@Builder
public record LoginResponse(
    String token,
    long expiresIn
) {
}
