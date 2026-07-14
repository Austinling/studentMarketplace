package com.austin.student_marketplace.auth.service.impl;

import com.austin.student_marketplace.Exceptions.EmailNotFoundException;
import com.austin.student_marketplace.Exceptions.IDNotFoundException;
import com.austin.student_marketplace.Exceptions.PasswordException;
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
    public AuthResponseDto login(LoginRequestDto loginRequestDto) {
        User user = authRepository.findByEmail(loginRequestDto.email())
                .orElseThrow(()-> new EmailNotFoundException("Email does not exist!"));

        if (!user.getPassword().equals(loginRequestDto.password())) {
            throw new PasswordException("Password is wrong!");
        }

        return new AuthResponseDto(
                "tempFakeJwtToken",
                1000000,
                user
        );
    }
}
