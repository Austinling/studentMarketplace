package com.austin.student_marketplace.auth;

import com.austin.student_marketplace.auth.dto.LoginRequestDto;
import com.austin.student_marketplace.auth.dto.RegisterRequestDto;
import com.austin.student_marketplace.auth.dto.UserDto;
import com.austin.student_marketplace.auth.mapper.impl.AuthRequestMapperImpl;
import com.austin.student_marketplace.auth.service.JwtService;
import com.austin.student_marketplace.auth.service.impl.AuthRequestServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {
    private final AuthRequestServiceImpl authRequestServiceImpl;
    private final AuthRequestMapperImpl authRequestMapperImpl;
    private final JwtService jwtService;

    public AuthController(AuthRequestServiceImpl authRequestServiceImpl, AuthRequestMapperImpl authRequestMapperImpl, JwtService jwtService) {
        this.authRequestServiceImpl = authRequestServiceImpl;
        this.authRequestMapperImpl = authRequestMapperImpl;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @Valid
            @RequestBody LoginRequestDto loginRequestDto
    ) {
        User user = authRequestServiceImpl.login(loginRequestDto);
        String jwtToken = jwtService.generateToken(new UserPrincipal(user));
        LoginResponse loginResponse = new LoginResponse(jwtToken, jwtService.getExpirationTime());


        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(
            @Valid
            @RequestBody RegisterRequestDto registerRequestDto
    ){
        RegisterRequest registerRequest = authRequestMapperImpl.fromDto(registerRequestDto);
        User user = authRequestServiceImpl.register(registerRequest);
        UserDto userDto = authRequestMapperImpl.toDto(user);

        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }
}
