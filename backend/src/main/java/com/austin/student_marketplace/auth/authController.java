package com.austin.student_marketplace.auth;

import com.austin.student_marketplace.auth.dto.LoginRequestDto;
import com.austin.student_marketplace.auth.dto.UserDto;
import com.austin.student_marketplace.auth.mapper.impl.LoginRequestMapperImpl;
import com.austin.student_marketplace.auth.service.LoginRequestService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/auth")
public class authController {
    private final LoginRequestService loginRequestService;
    private final LoginRequestMapperImpl loginRequestMapperImpl;

    public authController(LoginRequestService loginRequestService, LoginRequestMapperImpl loginRequestMapperImpl) {
        this.loginRequestService = loginRequestService;
        this.loginRequestMapperImpl = loginRequestMapperImpl;
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(
            @Valid
            @RequestBody LoginRequestDto loginRequestDto
    ) {
        LoginRequest loginRequest = loginRequestMapperImpl.fromDto(loginRequestDto);
        User user = loginRequestService.login(loginRequest);
        UserDto userDto = loginRequestMapperImpl.toDto(user);

        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}
