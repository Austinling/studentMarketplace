package com.austin.student_marketplace.auth;

import com.austin.student_marketplace.auth.dto.LoginRequestDto;
import com.austin.student_marketplace.auth.dto.UserDto;
import com.austin.student_marketplace.auth.mapper.impl.LoginRequestMapperImpl;
import com.austin.student_marketplace.auth.service.impl.LoginRequestServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {
    private final LoginRequestServiceImpl loginRequestServiceImpl;
    private final LoginRequestMapperImpl loginRequestMapperImpl;

    public AuthController(LoginRequestServiceImpl loginRequestServiceImpl, LoginRequestMapperImpl loginRequestMapperImpl) {
        this.loginRequestServiceImpl = loginRequestServiceImpl;
        this.loginRequestMapperImpl = loginRequestMapperImpl;
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(
            @Valid
            @RequestBody LoginRequestDto loginRequestDto
    ) {
        LoginRequest loginRequest = loginRequestMapperImpl.fromDto(loginRequestDto);
        User user = loginRequestServiceImpl.login(loginRequest);
        UserDto userDto = loginRequestMapperImpl.toDto(user);

        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}
