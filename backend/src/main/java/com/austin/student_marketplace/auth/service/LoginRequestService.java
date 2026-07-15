package com.austin.student_marketplace.auth.service;

import com.austin.student_marketplace.auth.LoginRequest;
import com.austin.student_marketplace.auth.User;
import com.austin.student_marketplace.auth.dto.AuthResponseDto;

public interface LoginRequestService {
    User login(LoginRequest loginRequest);

}
