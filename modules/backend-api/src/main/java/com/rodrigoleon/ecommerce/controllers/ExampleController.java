package com.rodrigoleon.ecommerce.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/example")
public class ExampleController {

    @GetMapping
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("Initial controller!");
    }

}
