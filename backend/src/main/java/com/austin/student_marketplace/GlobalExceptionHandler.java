package com.austin.student_marketplace;

import com.austin.student_marketplace.Exceptions.AuthException;
import com.austin.student_marketplace.auth.dto.ErrorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(AuthException.class)
    public ResponseEntity<ErrorDto> handleAuthException(AuthException ex) {
        logger.warn(ex.getMessage());

        ErrorDto errorDto = new ErrorDto("Unauthorized request, please check your credentials");

        return new ResponseEntity<>(errorDto,HttpStatus.UNAUTHORIZED);
    }
}
