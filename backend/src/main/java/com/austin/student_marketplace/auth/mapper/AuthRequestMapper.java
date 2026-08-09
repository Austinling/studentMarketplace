package com.austin.student_marketplace.auth.mapper;

import com.austin.student_marketplace.auth.RegisterRequest;
import com.austin.student_marketplace.auth.User;
import com.austin.student_marketplace.auth.dto.RegisterRequestDto;
import com.austin.student_marketplace.auth.dto.UserDto;

public interface AuthRequestMapper {
    UserDto toDto(User user);

    RegisterRequest fromDto(RegisterRequestDto registerRequestDto);
}
