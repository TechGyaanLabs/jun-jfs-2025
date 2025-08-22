package com.careerit.cbook.api;

import com.careerit.cbook.exception.ContactAlreadyExistsException;
import com.careerit.cbook.exception.ContactNotFoundException;
import com.careerit.cbook.util.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandlerAdvisor {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<Void>> handleIllegalArgumentException(IllegalArgumentException e) {
        ApiResponse<Void> response = ApiResponse.<Void>error(
            "Invalid Argument",
            e.getMessage(),
            HttpStatus.BAD_REQUEST.value()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(ContactNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleContactNotFoundException(ContactNotFoundException e) {
        ApiResponse<Void> response = ApiResponse.<Void>error(
            "Contact Not Found",
            e.getMessage(),
            HttpStatus.NOT_FOUND.value()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(ContactAlreadyExistsException.class)
    public ResponseEntity<ApiResponse<Void>> handleContactAlreadyExistsException(ContactAlreadyExistsException e) {
        ApiResponse<Void> response = ApiResponse.<Void>error(
            "Contact Already Exists",
            e.getMessage(),
            HttpStatus.CONFLICT.value()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
}
