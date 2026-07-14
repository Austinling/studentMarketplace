package com.austin.student_marketplace.auth;

import com.austin.student_marketplace.auth.mapper.impl.LoginRequestMapperImpl;
import com.austin.student_marketplace.auth.service.LoginRequestService;
import jakarta.validation.Valid;
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
    public User login(@Valid @RequestBody User user) {
        return loginRequestService.saveLoginSystem(user);
    }
}
