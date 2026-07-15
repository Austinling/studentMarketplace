package com.austin.student_marketplace.auth.service.impl;

import com.austin.student_marketplace.Exceptions.EmailNotFoundException;
import com.austin.student_marketplace.Exceptions.IDNotFoundException;
import com.austin.student_marketplace.Exceptions.PasswordException;
import com.austin.student_marketplace.auth.LoginRequest;
import com.austin.student_marketplace.auth.User;
import com.austin.student_marketplace.auth.authRepository;
import com.austin.student_marketplace.auth.dto.AuthResponseDto;
import com.austin.student_marketplace.auth.dto.LoginRequestDto;
import com.austin.student_marketplace.auth.service.LoginRequestService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class LoginRequestServiceImpl implements LoginRequestService {

    private final authRepository authRepository;

    public LoginRequestServiceImpl(authRepository authRepository) {
        this.authRepository = authRepository;
    }

    @Override
    public User login(LoginRequest loginRequest) {
        User user = authRepository.findByEmail(loginRequest.email())
                .orElseThrow(()-> new EmailNotFoundException("Email does not exist!"));

        return user;
    }
}
