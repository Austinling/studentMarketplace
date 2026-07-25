package com.austin.student_marketplace.auth.service.impl;

import com.austin.student_marketplace.Exceptions.AuthException;
import com.austin.student_marketplace.auth.*;
import com.austin.student_marketplace.auth.service.AuthRequestService;
import com.austin.student_marketplace.listings.ListingRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthRequestServiceImpl implements AuthRequestService {

    private final AuthRepository authRepository;

    public AuthRequestServiceImpl(AuthRepository authRepository, ListingRepository listingRepository) {
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

    @Override
    public User register(RegisterRequest registerRequest) {
        Profile profile = Profile.builder()
                .firstName(registerRequest.firstName())
                .lastName(registerRequest.lastName())
                .numOfListings(0L)
                .rating(0.0)
                .build();


        User user = User.builder()
                .email(registerRequest.email())
                .password(registerRequest.password())
                .profile(profile)
                .username(registerRequest.firstName())
                .role("STUDENT")
                .build();

        return authRepository.save(user);
    }

}
