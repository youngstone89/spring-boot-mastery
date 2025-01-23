package com.youngstone.mastery.model;

import jakarta.validation.constraints.NotNull;

public record ProductRequestV1(
        @NotNull(message = "product name should not be null") String productName,
        @NotNull(message = "product category should not be null") String productCategory,
        @NotNull(message = "manufacturer should not be null") String manufacturer) {
}