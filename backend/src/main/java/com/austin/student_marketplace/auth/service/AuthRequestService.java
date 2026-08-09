package com.austin.student_marketplace.auth.service;

import com.austin.student_marketplace.auth.RegisterRequest;
import com.austin.student_marketplace.auth.User;
import com.austin.student_marketplace.auth.dto.LoginRequestDto;

public interface AuthRequestService {
    User login(LoginRequestDto loginRequestDto);

    User register(RegisterRequest registerRequest);

}
