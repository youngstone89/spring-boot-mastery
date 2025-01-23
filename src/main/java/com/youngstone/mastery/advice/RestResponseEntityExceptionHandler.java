package com.youngstone.mastery.advice;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// @ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    // @ExceptionHandler(value = { IllegalArgumentException.class,
    // IllegalStateException.class })
    // protected ResponseEntity<Object> handleConflict(
    // RuntimeException ex, WebRequest request) {

    // String bodyOfResponse = "This should be application specific";
    // Map<String, Object> messageBody = new HashMap();
    // messageBody.put("message", bodyOfResponse);
    // messageBody.put("code", HttpStatus.CONFLICT.value());
    // messageBody.put("error", ex.getMessage());

    // return handleExceptionInternal(ex,
    // messageBody,
    // new HttpHeaders(), HttpStatus.CONFLICT, request);

    // }

    // @ExceptionHandler(value = { MethodArgumentNotValidException.class })
    // public ResponseEntity<String>
    // handleValidationException(MethodArgumentNotValidException ex) {
    // String errors = ex.getBindingResult().getAllErrors()
    // .stream()
    // .map(ObjectError::getDefaultMessage)
    // .collect(Collectors.joining(", "));
    // return ResponseEntity.badRequest().body("Validation errors: " + errors);
    // }
}
