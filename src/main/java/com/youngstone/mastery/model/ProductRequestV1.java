package com.youngstone.mastery.model;

import com.youngstone.mastery.validators.ProductRequestConstraint;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@ProductRequestConstraint
public record ProductRequestV1(
                @NotBlank(message = "product name should not be blank") String productName,
                @NotNull(message = "product category should not be null") String productCategory,
                @NotNull(message = "manufacturer should not be null") String manufacturer) {
}