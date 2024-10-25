package com.youngstone.mastery.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
    protected ResponseEntity<Object> handleConflict(
            RuntimeException ex, WebRequest request) {

        String bodyOfResponse = "This should be application specific";
        Map<String, Object> messageBody = new HashMap();
        messageBody.put("message", bodyOfResponse);
        messageBody.put("code", HttpStatus.CONFLICT.value());
        messageBody.put("error", ex.getMessage());

        return handleExceptionInternal(ex,
                messageBody,
                new HttpHeaders(), HttpStatus.CONFLICT, request);

    }
}
