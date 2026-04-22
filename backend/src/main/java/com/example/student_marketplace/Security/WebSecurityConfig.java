package com.example.student_marketplace.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http){
        http
                .cors(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((requests) ->
                requests.requestMatchers("/h2-console").permitAll()
                        .requestMatchers("/").permitAll()
                        .anyRequest().authenticated()
        )
                .httpBasic(Customizer.withDefaults())
                .headers(headers -> headers.frameOptions(frame-> frame.sameOrigin()))
                .formLogin(Customizer.withDefaults())

                .logout(LogoutConfigurer::permitAll);

        return http.build();

    }
}
