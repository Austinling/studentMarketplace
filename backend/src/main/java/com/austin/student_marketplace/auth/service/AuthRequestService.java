package com.austin.student_marketplace.auth.service;

import com.austin.student_marketplace.auth.LoginRequest;
import com.austin.student_marketplace.auth.RegisterRequest;
import com.austin.student_marketplace.auth.User;

public interface AuthRequestService {
    User login(LoginRequest loginRequest);

    User register(RegisterRequest registerRequest);

}
