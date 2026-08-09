package com.austin.student_marketplace.auth;

import lombok.Builder;

@Builder
public record RegisterRequest(
        String email,
        String password,
        String username

) {
}
