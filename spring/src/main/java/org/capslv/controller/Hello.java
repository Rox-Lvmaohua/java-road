package org.capslv.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping
public class Hello {
    @GetMapping("hello")
    public String hello() {
        return "Hello world!";
    }

    @GetMapping
    public ResponseEntity<String> bye() {
        return ResponseEntity.status(HttpStatus.FOUND)
                .header(HttpHeaders.LOCATION, "/hello")
                .build();
    }
}
