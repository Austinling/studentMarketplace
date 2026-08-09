package com.austin.student_marketplace.auth.config;

import com.austin.student_marketplace.auth.AuthRepository;
import com.austin.student_marketplace.auth.UserPrincipal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ApplicationConfiguration {
    private final AuthRepository authRepository;

    public ApplicationConfiguration(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> authRepository.findByEmail(username)
                .map((user)-> new UserPrincipal(user))
                .orElseThrow(()-> new UsernameNotFoundException("Username not found"));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(
            UserDetailsService userDetailsService, PasswordEncoder passwordEncoder
    ) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(userDetailsService);

        return authProvider;
    }
}
