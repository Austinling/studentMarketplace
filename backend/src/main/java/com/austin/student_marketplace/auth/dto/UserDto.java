package com.austin.student_marketplace.auth.dto;
import lombok.Builder;

@Builder
public record UserDto(
        String role,
        String username
) {
}
