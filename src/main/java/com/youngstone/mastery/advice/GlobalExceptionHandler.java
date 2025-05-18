package com.youngstone.mastery.advice;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.Builder;
import lombok.Getter;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        Map<String, Object> body = getErrors(ex, status);

        return new ResponseEntity<>(body, headers, status);
    }

    private Map<String, Object> getErrors(MethodArgumentNotValidException ex, HttpStatusCode status) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", ZonedDateTime.now(ZoneId.of("Asia/Seoul")).format(DateTimeFormatter.ISO_DATE_TIME));
        body.put("status", status.value());

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("errors", errors);
        return body;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(
            ConstraintViolationException ex,
            WebRequest request) {

        List<Violation> violations = ex.getConstraintViolations().stream()
                .map(this::convertToViolation)
                .collect(Collectors.toList());

        ErrorResponse response = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message("Validation failed")
                .path(request.getDescription(false).replace("uri=", ""))
                .errors(violations)
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private Violation convertToViolation(ConstraintViolation<?> violation) {
        String field = null;

        // Extract field name from property path if available
        if (violation.getPropertyPath() != null) {
            String path = violation.getPropertyPath().toString();
            if (path.contains(".")) {
                field = path.substring(path.lastIndexOf('.') + 1);
            } else {
                field = path;
            }
        }

        return Violation.builder()
                .field(field)
                .message(violation.getMessage())
                .invalidValue(violation.getInvalidValue())
                .rootBeanClass(violation.getRootBeanClass().getSimpleName())
                .build();
    }

    // Helper classes
    @Builder
    @Getter
    private static class ErrorResponse {
        private final LocalDateTime timestamp;
        private final int status;
        private final String error;
        private final String message;
        private final String path;
        private final List<Violation> errors;
    }

    @Builder
    @Getter
    private static class Violation {
        private final String field;
        private final String message;
        private final Object invalidValue;
        private final String rootBeanClass;
    }
}