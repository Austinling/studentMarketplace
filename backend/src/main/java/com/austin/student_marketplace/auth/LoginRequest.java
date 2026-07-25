package com.austin.student_marketplace.auth;

import lombok.Builder;

@Builder
public record LoginRequest(
        String email,
        String password
) {
}
