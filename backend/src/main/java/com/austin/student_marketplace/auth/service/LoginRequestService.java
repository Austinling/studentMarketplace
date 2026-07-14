package com.austin.student_marketplace.auth.service;

import com.austin.student_marketplace.auth.User;
import com.austin.student_marketplace.auth.dto.AuthResponseDto;
import com.austin.student_marketplace.auth.dto.LoginRequestDto;

import java.util.List;

public interface LoginRequestService {
    AuthResponseDto login(LoginRequestDto loginRequestDto);

}
