package com.austin.student_marketplace.auth.dto;
import lombok.Builder;

@Builder
public record UserDto(
        String firstName,
        String lastName,
        String role,
        String username
) {
}
