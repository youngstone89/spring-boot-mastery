package com.youngstone.mastery.controller.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youngstone.mastery.model.ProductRequestV1;
import com.youngstone.mastery.model.ProductResponseV1;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @PostMapping()
    public ResponseEntity<ProductResponseV1> addProduct(@Valid @RequestBody ProductRequestV1 request) {

        return new ResponseEntity<>(new ProductResponseV1(1), HttpStatus.CREATED);
    }

}