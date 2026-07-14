package com.austin.student_marketplace.auth.dto;

public record UserDto(
        String firstName,
        String lastName,
        String role,
        String username
) {
}
