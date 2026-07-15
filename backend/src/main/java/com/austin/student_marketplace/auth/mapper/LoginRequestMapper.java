package com.austin.student_marketplace.auth.mapper;

import com.austin.student_marketplace.auth.LoginRequest;
import com.austin.student_marketplace.auth.User;
import com.austin.student_marketplace.auth.dto.LoginRequestDto;
import com.austin.student_marketplace.auth.dto.UserDto;

public interface LoginRequestMapper {
    UserDto toDto(User user);

    LoginRequest fromDto(LoginRequestDto loginRequestDto);
}
