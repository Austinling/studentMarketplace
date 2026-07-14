package com.austin.student_marketplace.auth.dto;

import com.austin.student_marketplace.auth.User;

public record AuthResponseDto(
        String jwtToken,
        long expiresIn,
        User user
){
}
