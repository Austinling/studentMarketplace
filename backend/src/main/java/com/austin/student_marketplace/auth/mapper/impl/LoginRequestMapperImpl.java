package com.austin.student_marketplace.auth.mapper.impl;

import com.austin.student_marketplace.auth.LoginRequest;
import com.austin.student_marketplace.auth.User;
import com.austin.student_marketplace.auth.dto.LoginRequestDto;
import com.austin.student_marketplace.auth.dto.UserDto;
import com.austin.student_marketplace.auth.mapper.LoginRequestMapper;
import org.springframework.stereotype.Component;

@Component
public class LoginRequestMapperImpl implements LoginRequestMapper {
    @Override
    public UserDto toDto(User user) {
        return new UserDto(
                user.getProfile().getFirstName(),
                user.getProfile().getLastName(),
                user.getRole(),
                user.getUsername()
        );
    }

    @Override
    public LoginRequest fromDto(LoginRequestDto loginRequestDto) {
        return new LoginRequest(
                loginRequestDto.email(),
                loginRequestDto.password()
        );
    }


}
