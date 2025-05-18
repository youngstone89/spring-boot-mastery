package com.youngstone.mastery.controller.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.youngstone.mastery.model.ProductRequestV1;
import com.youngstone.mastery.model.ProductResponseV1;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/product")
@Validated
public class ProductController {

    // Use a mutable list for adding products
    private static final List<ProductResponseV1> products = new ArrayList<>(List.of(
            new ProductResponseV1(1), new ProductResponseV1(2)));

    @PostMapping()
    public ResponseEntity<ProductResponseV1> addProduct(@Valid @RequestBody ProductRequestV1 request) {
        final var newProduct = new ProductResponseV1(products.size() + 1);
        products.add(newProduct);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<ProductResponseV1> getProduct(@RequestParam(name = "id") @Min(value = 1) Integer id) {
        return products.stream()
                .filter(x -> x.id().equals(id))
                .findAny()
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
