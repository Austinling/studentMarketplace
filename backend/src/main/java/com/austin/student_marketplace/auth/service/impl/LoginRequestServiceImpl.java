package com.austin.student_marketplace.auth.service.impl;

import com.austin.student_marketplace.Exceptions.AuthException;
import com.austin.student_marketplace.auth.LoginRequest;
import com.austin.student_marketplace.auth.User;
import com.austin.student_marketplace.auth.AuthRepository;
import com.austin.student_marketplace.auth.service.LoginRequestService;
import org.springframework.stereotype.Service;

@Service
public class LoginRequestServiceImpl implements LoginRequestService {

    private final AuthRepository authRepository;

    public LoginRequestServiceImpl(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    @Override
    public User login(LoginRequest loginRequest) {
        User user = authRepository.findByEmail(loginRequest.email())
                .orElseThrow(()-> new AuthException("Email is incorrect!"));

        if (!user.getPassword().equals(loginRequest.password())) {
            throw new AuthException("Password is incorrect!");
        }

        return user;
    }
}
