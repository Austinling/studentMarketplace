package com.austin.student_marketplace.auth.service;

import com.austin.student_marketplace.auth.AuthRepository;
import com.austin.student_marketplace.auth.User;
import com.austin.student_marketplace.auth.UserPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final AuthRepository authRepository;

    public CustomUserDetailsService(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = authRepository.findByUsername(username);
        if (user.isPresent()) {
            return new UserPrincipal(user.get());
        }
        return null;
    }
}
