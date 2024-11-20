package com.youngstone.mastery.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestObjectForValidationV1 {
    @NotBlank
    private String name;
}
