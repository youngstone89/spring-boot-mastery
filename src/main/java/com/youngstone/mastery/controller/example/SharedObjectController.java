package com.youngstone.mastery.controller.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youngstone.mastery.model.SharedObjectResponseV1;
import com.youngstone.mastery.service.SharedObjectService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/shared-objects")
@RequiredArgsConstructor
public class SharedObjectController {

    private final SharedObjectService service;

    @GetMapping("/objects/{id}")
    public SharedObjectResponseV1 getSharedObject(
            @PathVariable Integer id) {
        return service.getSharedObject(id);
    }
}
