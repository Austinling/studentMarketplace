package com.austin.student_marketplace.auth.mapper.impl;

import com.austin.student_marketplace.auth.LoginResponse;
import com.austin.student_marketplace.auth.RegisterRequest;
import com.austin.student_marketplace.auth.User;
import com.austin.student_marketplace.auth.dto.LoginRequestDto;
import com.austin.student_marketplace.auth.dto.RegisterRequestDto;
import com.austin.student_marketplace.auth.dto.UserDto;
import com.austin.student_marketplace.auth.mapper.AuthRequestMapper;
import org.springframework.stereotype.Component;

@Component
public class AuthRequestMapperImpl implements AuthRequestMapper {
    @Override
    public UserDto toDto(User user) {
        return new UserDto(
                "user.getProfile().getFirstName()",
                "user.getProfile().getLastName()",
                user.getRole(),
                user.getUsername()
        );
    }

    @Override
    public RegisterRequest fromDto(RegisterRequestDto registerRequestDto) {
        return RegisterRequest.builder()
                .username(registerRequestDto.username())
                .email(registerRequestDto.email())
                .password(registerRequestDto.password())
                .build();
    }


}
