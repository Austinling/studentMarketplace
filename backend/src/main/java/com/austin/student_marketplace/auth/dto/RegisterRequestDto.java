package com.austin.student_marketplace.auth.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record RegisterRequestDto(
        @NotBlank(message = "{auth.firstname.notblank}")
        @Length(max = 255, message = "{auth.length.max}")
        String firstName,
        @NotBlank(message = "{auth.lastname.notblank}")
        @Length(max = 255, message = "{auth.length.max}")
        String lastName,
        @NotBlank(message = "{auth.email.notblank}")
        @Length(max = 255, message = "{auth.length.max}")
        String email,
        @NotBlank(message = "{auth.password.notblank}")
        @Length(max = 255, message = "{auth.length.max}")
        String password
) {
}
