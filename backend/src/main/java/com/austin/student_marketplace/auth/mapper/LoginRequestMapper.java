package com.austin.student_marketplace.auth.mapper;

import com.austin.student_marketplace.auth.dto.LoginRequestDto;
import com.austin.student_marketplace.auth.returnedObjects.LoginRequest;

public interface LoginRequestMapper {
    LoginRequest fromDto(LoginRequestDto dto);

}
