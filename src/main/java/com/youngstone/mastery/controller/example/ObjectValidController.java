package com.youngstone.mastery.controller.example;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.youngstone.mastery.model.RequestObjectForValidationV1;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/object/valid")
public class ObjectValidController {

    @GetMapping("/test1")
    public String getTest1(@ModelAttribute @Valid RequestObjectForValidationV1 request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, bindingResult.getFieldError().toString());
        }
        return "passed";
    }
}
