package com.youngstone.mastery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResponseStatusAnnotatedException1 extends RuntimeException {

    public ResponseStatusAnnotatedException1() {
        super();
    }

    public ResponseStatusAnnotatedException1(String message, Throwable cause) {
        super(message, cause);
    }

    public ResponseStatusAnnotatedException1(String message) {
        super(message);
    }

    public ResponseStatusAnnotatedException1(Throwable cause) {
        super(cause);
    }

}
