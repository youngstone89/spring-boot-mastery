package com.youngstone.mastery.controller.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.youngstone.mastery.exception.CustomException1;
import com.youngstone.mastery.exception.CustomException2;
import com.youngstone.mastery.exception.CustomException3;
import com.youngstone.mastery.exception.CustomException4;
import com.youngstone.mastery.exception.ResponseStatusAnnotatedException1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/exception-handle/example")
public class ExceptionHandlerExampleController {

    @GetMapping("/test1")
    public void testBadRequest1() {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/test2")
    public void testBadRequest2() {
        throw new CustomException1();
    }

    @GetMapping("/test3")
    public void testBadRequest3() {
        throw new CustomException2();
    }

    @GetMapping("/test4")
    public void testBadRequest4() {
        throw new ResponseStatusAnnotatedException1();
    }

    @GetMapping("/test5")
    public void testBadRequest5() {
        throw new CustomException3("test5 error");
    }

    @GetMapping("/test6")
    public void testBadRequest6() {
        throw new CustomException4("test6 error");
    }

    @GetMapping("/test7")
    public void testIllegalStateException() {
        throw new IllegalStateException();
    }

    @ExceptionHandler({ CustomException1.class, CustomException2.class })
    public void handleException(Exception ex) {
        log.error("handleException", ex);
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
    }

}
