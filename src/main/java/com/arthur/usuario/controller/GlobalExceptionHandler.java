package com.arthur.usuario.controller;

import com.arthur.usuario.infrastructure.exceptions.ConflictException;
import com.arthur.usuario.infrastructure.exceptions.ResourceNotFoundException;
import com.arthur.usuario.infrastructure.exceptions.UnauthorizedException;
import com.arthur.usuario.infrastructure.exceptions.dto.ErrorResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleResourceNotFoundException(ResourceNotFoundException ex,
                                                                            HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(buildError(HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                request.getRequestURI(),
                "Not Found"
                ));
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ErrorResponseDTO> handleConflictException(ConflictException ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(buildError(HttpStatus.CONFLICT.value(),
                ex.getMessage(),
                request.getRequestURI(),
                "Conflict"
        ));
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<String> handleUnauthorizedException(UnauthorizedException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    private ErrorResponseDTO buildError(int status, String message, String path, String error) {
        return ErrorResponseDTO.builder()
                .timestamp(LocalDateTime.now())
                .message(message)
                .error(error)
                .status(status)
                .path(path)
                .build();
    }
}
