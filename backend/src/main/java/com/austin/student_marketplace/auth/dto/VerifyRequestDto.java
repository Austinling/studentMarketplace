package com.austin.student_marketplace.auth.dto;

public record VerifyRequestDto(
        String email,
        String code
) {
}
