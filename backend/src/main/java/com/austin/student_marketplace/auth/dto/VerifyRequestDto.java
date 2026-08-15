package com.austin.student_marketplace.auth.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record VerifyRequestDto(
        @NotBlank(message = "{auth.email.notblank}")
        @Length(max = 255, message = "{auth.length.max}")
        String email,
        @NotBlank(message = "{auth.code.notblank")
        @Length(max = 6, message = "{auth.length.code.max}")
        String code
) {
}
