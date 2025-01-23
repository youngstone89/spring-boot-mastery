package com.youngstone.mastery.validators;

import java.util.Arrays;
import java.util.List;

import com.youngstone.mastery.model.ProductRequestV1;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ProductRequestValidator implements ConstraintValidator<ProductRequestConstraint, ProductRequestV1> {

    @Override
    public boolean isValid(ProductRequestV1 value, ConstraintValidatorContext context) {
        boolean isValid = true;

        // Check if product name contains the manufacturer name
        if (!value.productName().toLowerCase().contains(value.manufacturer().toLowerCase())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Product name should contain the manufacturer name")
                    .addPropertyNode("productName")
                    .addConstraintViolation();
            isValid = false;
        }

        // Check if product category is valid based on a predefined list
        List<String> validCategories = Arrays.asList("Electronics", "Clothing", "Food", "Books");
        if (!validCategories.contains(value.productCategory())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Invalid product category")
                    .addPropertyNode("productCategory")
                    .addConstraintViolation();
            isValid = false;
        }

        // Check if manufacturer name is not the same as product name
        if (value.manufacturer().equalsIgnoreCase(value.productName())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Manufacturer name cannot be the same as product name")
                    .addPropertyNode("manufacturer")
                    .addConstraintViolation();
            isValid = false;
        }
        return isValid;
    }

}
