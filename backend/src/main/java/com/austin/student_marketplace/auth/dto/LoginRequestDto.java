package com.austin.student_marketplace.auth.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import static com.austin.student_marketplace.auth.dto.ErrorMessageStorage.*;

public record LoginRequestDto(
        @NotBlank(message = ERROR_MESSAGE_BLANK_EMAIL)
        @Length(max = 255, message = ERROR_MESSAGE_255_LENGTH)
        String email,
        @NotBlank(message =  ERROR_MESSAGE_BLANK_PASSWORD)
        @Length(max = 255, message = ERROR_MESSAGE_255_LENGTH)
        String password
) {

}
