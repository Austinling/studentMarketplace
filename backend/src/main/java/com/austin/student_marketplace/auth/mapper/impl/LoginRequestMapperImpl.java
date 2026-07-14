package com.austin.student_marketplace.auth.mapper.impl;

import com.austin.student_marketplace.auth.dto.LoginRequestDto;
import com.austin.student_marketplace.auth.mapper.LoginRequestMapper;
import com.austin.student_marketplace.auth.returnedObjects.LoginRequest;

public class LoginRequestMapperImpl implements LoginRequestMapper {
    @Override
    public LoginRequest fromDto(LoginRequestDto dto) {
        return new LoginRequest(
                "Your login has been successful"
        );
    }
}
