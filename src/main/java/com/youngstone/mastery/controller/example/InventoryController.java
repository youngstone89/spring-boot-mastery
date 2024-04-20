package com.youngstone.mastery.controller.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youngstone.mastery.model.VendorInventoryRequestV1;

@RestController
@RequestMapping("/v1/example")
public class InventoryController {

    @GetMapping("/vendors/{vendor}/inventories")
    public VendorInventoryRequestV1 getInventories(
            @PathVariable String vendor,
            @ModelAttribute("request") VendorInventoryRequestV1 request) {
        // Your controller logic here
        System.out.println("vendor: " + vendor);
        System.out.println("requestV1: " + request.toString());
        return request;
    }
}
